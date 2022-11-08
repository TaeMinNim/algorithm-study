import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ApplicationTest {
    @DisplayName("공백이 나올때까지 변수형을 읽어들인다. 이때 읽어들인 문자가 공통 변수형이다")
    @Nested
    class findCommonTypeTest {
        @Nested
        class findCommonTypeDivisionIndexTest {
            @Test
            void case1() {
                String input = "int& a*[]&, b, c*;";
                int result = 4;

                assertThat(Application.findCommonTypeDivisionIndex(input))
                        .isEqualTo(result);
            }
        }

        @Nested
        class getCommonTypeTest {
            @Test
            void case1() {
                int commonTypeDivisionIndex = 4;
                String input = "int& a*[]&, b, c*;";
                String result = "int&";

                assertThat(Application.getCommonType(input, commonTypeDivisionIndex))
                        .isEqualTo(result);
            }
        }

        @Nested
        class getRestString {
            @Test
            void case1() {
                int commonTypeDivisionIndex = 4;
                String input = "int& a*[]&, b, c*;";
                String result = " a*[]&, b, c*;";

                assertThat(Application.getRestString(input, commonTypeDivisionIndex))
                        .isEqualTo(result);
            }
        }
    }

    @DisplayName("문자를 읽어들이다 공백 이외의 문자가 발견되면 `,`가 나오기 전까지가 선언하는 변수이다")
    @Nested
    class findVariableTest {
        @Nested
        class findVariableStartIndexTest {
            @Test
            void case1() {
                String restString = " a*[]&, b, c*;";
                int result = 1;

                assertThat(Application.findVariableStartIndex(restString))
                        .isEqualTo(result);
            }
        }

        @Nested
        class findVariableEndIndexTest{
            @Test
            void case1(){
                String restString = " a*[]&, b, c*;";
                int result = 6;

                assertThat(Application.findVariableEndIndex(restString))
                        .isEqualTo(result);
            }

            @Test
            void case2(){
                String restString = " c*;";
                int result = 3;

                assertThat(Application.findVariableEndIndex(restString))
                        .isEqualTo(result);
            }
        }

        @Nested
        class getVariableTest{
            @Test
            void case1(){
                String restString = " a*[]&, b, c*;";
                int startIndex = 1;
                int endIndex = 6;
                String result = "a*[]&";

                assertThat(Application.getVariable(restString, startIndex, endIndex))
                        .isEqualTo(result);
            }
        }

        @DisplayName("`&`, `[]`, `*`이 나올때까지 문자를 읽는다. `&`, `[]`, `*`을 찾으면 그 부분을 기준으로 변수명, 변수형을 나눈다")
        @Nested
        class findTypeTest{
            @Nested
            class findVariableNameIndexTest{
                @Test
                void case1(){
                    String variable = "a*[]&";
                    int result = 1;

                    assertThat(Application.findVariableTypeStartIndex(variable))
                            .isEqualTo(result);
                }
            }
        }
    }
}
