import MathOperations.*;

public class MathTest {
    public static void main(String[] args) {
        double num = 7.6;
        new Floor().apply(num);
        new Ceil().apply(num);
        new Round().apply(num);
    }
}
