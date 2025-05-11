class BankAccount {
    double balance;

    BankAccount(double b) {
        balance = b;
    }

    void deposit(double amt) {
        balance += amt;
    }

    void withdraw(double amt) {
        balance -= amt;
    }

    void showBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(double b) {
        super(b);
    }

    void withdraw(double amt) {
        if (balance - amt >= 100) {
            balance -= amt;
        } else {
            System.out.println("Withdrawal not allowed. Minimum balance should be 100.");
        }
    }
}

public class BankTest {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(500);
        sa.deposit(200);
        sa.withdraw(550);
        sa.showBalance();
        sa.withdraw(50);
        sa.showBalance();
    }
}
