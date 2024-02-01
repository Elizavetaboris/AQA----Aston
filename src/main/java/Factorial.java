import java.util.stream.IntStream;

public class Factorial {
    public int getFactorial(int f) {
        if (f <= 1) {
            return 1;
        } else {
            return IntStream.rangeClosed(2, f).reduce((x, y) -> x * y).getAsInt();
        }
    }
}


