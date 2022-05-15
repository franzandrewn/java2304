import lesson8.Calculator;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple add tests")
    void simpleAddTests() {
//        SoftAssertions softAssertions = new SoftAssertions();
//        softAssertions.assertThat(calculator.add(2,3)).isEqualByComparingTo(5);
//        softAssertions.assertThat(calculator.add(3,3)).isEqualByComparingTo(5);
        assertEquals(5, calculator.add(3, 2), "5 == 3 + 2");
        assertEquals(5, calculator.add(2, 3), "5 == 2 + 3");
    }

    @RepeatedTest(5)
    @DisplayName("Simple mul tests")
    void simpleMulTests() {
        assertEquals(6, calculator.mul(2,3), "2*3=6");
        assertEquals(-6, calculator.mul(-2,3), "-2*3=6");
        assertEquals(-6, calculator.mul(2,-3), "2*(-3)=6");
        assertEquals(6, calculator.mul(-2,-3), "-2*(-3)=6");
    }
}
