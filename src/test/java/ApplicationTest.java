import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ApplicationTest {
    @DisplayName("공통타입 구분자 인덱스 위치 반환 테스트")
    @Nested
    class findCommonTypeDivisionIndexTest{
        @Test
        void case1(){
            String input = "int& a*[]&, b, c*;";
            assertThat(Application.findCommonTypeDivisionIndex(input)).isEqualTo(4);
        }
    }
}
