class BankAccount {
    double balance;

    BankAccount(double b) {
        balance = b;
    }

    void balanceEnquiry() {
        System.out.println("Balance: " + balance);
    }

    void withdraw(double amt) throws LowBalanceException, NegativeNumberException {
        if (amt < 0) throw new NegativeNumberException("Negative amount");
        if (amt > balance) throw new LowBalanceException("Insufficient balance");
        balance -= amt;
    }

    void deposit(double amt) throws NegativeNumberException {
        if (amt < 0) throw new NegativeNumberException("Negative amount");
        balance += amt;
    }
}
