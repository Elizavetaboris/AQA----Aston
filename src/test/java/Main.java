import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Main {
    @DataProvider(name = "Проверка на факториал")
    public static Object[][] primeNumbers() {
        return new Object[][]{{1, 1}, {2, 2}, {6, 3}, {24, 4}, {120, 5}, {720, 6}, {5040, 7}};
    }

    @Test(dataProvider = "Проверка на факториал")
    public void factorialTest(int expectedValue, int actualValue) {
        Factorial factorial = new Factorial();
        Assert.assertEquals(expectedValue, factorial.getFactorial(actualValue));
    }
}
