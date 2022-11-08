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

            @Test
            void case2() {
                String restString = ", b, c*;";
                int result = 2;

                assertThat(Application.findVariableStartIndex(restString))
                        .isEqualTo(result);
            }

            @Test
            void case3() {
                String restString = ", c*;";
                int result = 2;

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

            @Test
            void case3(){
                String restString = ", b, c*;";
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
    }

    @DisplayName("`&`, `[]`, `*`이 나올때까지 문자를 읽는다. `&`, `[]`, `*`을 찾으면 그 부분을 기준으로 변수명, 변수형을 나눈다")
    @Nested
    class findTypeTest{
        @Nested
        class findVariableTypeStartIndexTest{
            @Test
            void case1(){
                String variable = "a*[]&";
                int result = 1;

                assertThat(Application.findVariableTypeStartIndex(variable))
                        .isEqualTo(result);
            }

            @Test
            void case2(){
                String variable = "b";
                int result = 0;

                assertThat(Application.findVariableTypeStartIndex(variable))
                        .isEqualTo(result);
            }
        }

        @Nested
        class getVariableNameTest{
            @Test
            void case1(){
                String variable = "a*[]&";
                int variableTypeStartIndex = 1;
                String result = "a";

                assertThat(Application.getVariableName(variable, variableTypeStartIndex))
                        .isEqualTo(result);
            }
        }

        @Nested
        class getVariableTypeTest{
            @Test
            void case1(){
                String variable = "a*[]&";
                int variableTypeStartIndex = 1;
                String result = "*[]&";

                assertThat(Application.getVariableType(variable, variableTypeStartIndex))
                        .isEqualTo(result);
            }
        }
    }

    @DisplayName("읽어들인 변수형을 뒤집는다")
    @Nested
    class reverseTest{
        @Nested
        class reverseVariableTypeTest{
            @Test
            void case1(){
                String variableType = "*[]&";
                String result = "&[]*";
                assertThat(Application.reverseVariableType(variableType))
                        .isEqualTo(result);
            }
        }
    }

    @DisplayName("공통 자료형 + 변수형 + 변수명으로 하나의 선언으로 바꾼다")
    @Nested
    class combineTest{
        @Nested
        class combineVariableTest{
            @Test
            void case1(){
                String commonType = "int&";
                String variableType = "&[]*";
                String variableName = "a";

                String result = "int&&[]* a;";
                assertThat(Application.combineVariable(commonType, variableType, variableName))
                        .isEqualTo(result);
            }
        }
    }
}
