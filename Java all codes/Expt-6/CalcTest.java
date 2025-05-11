import ExceptionHandlingDemo.*;

public class CalcTest {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        try {
            int result = c.divide(10, 0);
            System.out.println("Result: " + result);
        } catch (DivisionException e) {
            System.out.println(e.getMessage());
        }
    }
}
