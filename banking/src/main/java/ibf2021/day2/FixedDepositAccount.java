package ibf2021.day2;

public class FixedDepositAccount extends BankAccount {

    private float interest = 3.0f;
    private int durationMonth = 6;
    public boolean isInterestChanged = false;
    public boolean isDurationChanged = false;

    public FixedDepositAccount(String acHolderName, Float acBalance) {
        super(acHolderName, acBalance);
    }

    public FixedDepositAccount(String acHolderName, Float acBalance, Float interest) {
        super(acHolderName, acBalance);
        this.interest = interest;
    }

    public FixedDepositAccount(String acHolderName, Float acBalance, Float interest, Integer duration) {
        super(acHolderName, acBalance);
        this.interest = interest;
        this.durationMonth = duration;
    }

    @Override
    public void deposit(float moneyIn) {

    }

    @Override
    public void withdraw(float moneyIn) {

    }

    public void setInterest(float interest) {
        if (isInterestChanged) {
            throw new IllegalArgumentException();
        }
        this.interest = interest;
        isInterestChanged = true;
    }

    public void setDurationMonth(int durationMonth) {
        if (isDurationChanged) {
            throw new IllegalArgumentException();
        }
        this.durationMonth = durationMonth;
        isDurationChanged = true;
    }

    @Override
    public float getAccountBalance() {
        float balanceBeforeInterest = super.getAccountBalance();
        return balanceBeforeInterest += interest;
    }
}
