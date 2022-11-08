import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ApplicationTest {
    @Test
    void runTest(){
        assertThat(1).isEqualTo(Application.runTest());
    }
}
