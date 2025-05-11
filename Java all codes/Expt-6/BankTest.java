public class BankTest {
    public static void main(String[] args) {
        BankAccount b = new BankAccount(500);
        try {
            b.deposit(200);
            b.withdraw(800);
        } catch (LowBalanceException | NegativeNumberException e) {
            System.out.println(e.getMessage());
        }
        b.balanceEnquiry();
    }
}
