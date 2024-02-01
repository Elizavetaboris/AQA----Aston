import org.junit.gen5.api.DisplayName;
import org.junit.gen5.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Main {
    @Test
    @DisplayName("Проверка расчёта факториала")
    @ParameterizedTest
    @CsvSource({"120,5", "720,6", "5040,7", "40320,8", "362880,9", " 3628800,10", "39916800,11"})
    public void factorialTest(int expectedValue, int actualValue) {
        Factorial factorial = new Factorial();
        Assertions.assertEquals(expectedValue, factorial.getFactorial(actualValue));
    }
}
