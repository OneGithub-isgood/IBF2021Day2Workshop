package ibf2021.day2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String acHolderName;
    private String acNumber;
    private float acBalance;
    private List<String> acTransactions;
    private boolean isClosed;
    private String acCreationDate;
    private String acClosedDate;

    private String createTimeStamp() {
        DateTimeFormatter datetimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime transactionDatetime = LocalDateTime.now();
        return datetimeFormat.format(transactionDatetime);
    }

    public BankAccount(String acHolderName) {
        this.acHolderName = acHolderName;
        String acTempNumber = Integer.toString(100000001+(int)(Math.random()*(1000000000-100000001)));
        this.acNumber = (acTempNumber.substring(0,3)+"-"+acTempNumber.substring(3,8)+"-"+acTempNumber.substring(8));
        this.acBalance = 0f;
        acTransactions = new ArrayList<>();
        acClosedDate = createTimeStamp();
    }

    public BankAccount(String acHolderName, float acBalance) {
        this.acHolderName = acHolderName;
        String acTempNumber = Integer.toString(100000001+(int)(Math.random()*(1000000000-100000001)));
        this.acNumber = (acTempNumber.substring(0,3)+"-"+acTempNumber.substring(3,8)+"-"+acTempNumber.substring(8));
        this.acBalance = acBalance;
        acTransactions = new ArrayList<>();
        acClosedDate = createTimeStamp();
    }

    public boolean AcIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean actionClose) {
        this.isClosed = actionClose;
        if (this.isClosed == true) {
            acClosedDate = createTimeStamp();
        } else {
            acClosedDate = null;
        }
    }

    public String setAccountClosedDate() {
        return acClosedDate;
    }

    public String setAccountCreatedDate() {
        return acCreationDate;
    }

    public String getAccountName() {
        return acHolderName;
    }

    public String getAccountNumber() {
        return acNumber;
    }

    public float getAccountBalance() {
        return acBalance;
    }

    public List<String> getTransaction() {
        return acTransactions;
    }

    public void deposit(float moneyIn) {
        if (moneyIn < 0 || isClosed) {
            throw new IllegalArgumentException();
        }
        this.acTransactions.add("Deposit $" + moneyIn + " at " + createTimeStamp());
        this.acBalance += moneyIn;
    }

    public void withdraw(float moneyOut) {
        if (moneyOut < 0 || moneyOut > this.acBalance || isClosed) {
            throw new IllegalArgumentException();
        }
        this.acTransactions.add("Withdraw $" + moneyOut + " at " + createTimeStamp());
        this.acBalance -= moneyOut;
    }

    public static void main(String[] args) {
        BankAccount accountA = new BankAccount("Tom");
        accountA.acTransactions =  new ArrayList<>();
        System.out.println("Welcome " + accountA.acHolderName + ", Your Balance is $" + accountA.acBalance);
        accountA.deposit(500);
        System.out.println(accountA.acTransactions.toString());
        System.out.println("Deposit Account " + accountA.acNumber + " Updated Balance is $" + accountA.acBalance);

        BankAccount accountB = new BankAccount("Jerry",1000);
        accountB.acTransactions =  new ArrayList<>();
        System.out.println("Welcome " + accountB.acHolderName + ", Your Balance is $" + accountB.acBalance);
        accountB.withdraw(900);
        System.out.println(accountB.acTransactions.toString());
        System.out.println("Withdraw Account " + accountB.acNumber + " Remaining Balance is $" + accountB.acBalance);
    }
}
