public class OddTest {
    static void checkEven(int n) throws OddNumberException {
        if (n % 2 != 0) throw new OddNumberException("Odd number");
        System.out.println("Even number: " + n);
    }

    public static void main(String[] args) {
        try {
            checkEven(5);
        } catch (OddNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}
