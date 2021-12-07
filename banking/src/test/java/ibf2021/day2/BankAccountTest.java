package ibf2021.day2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BankAccountTest {

    @Test
    public void testGetBalance() {
        BankAccount account = new BankAccount("Tom", 4000.50f);
        assertTrue(account.getAccountBalance() == 4000.50f);
        System.out.println("testGetBalance Passed!");
    }

    @Test
    public void testGetBalanceForFixedAcc() {
        BankAccount fixedAccount = new FixedDepositAccount("Tom", 100f, 4.0f);
        assertTrue(fixedAccount.getAccountBalance() == 104.0f);
        System.out.println("testGetBalanceForFixedAcc Passed!");
    }

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("Tom", 4000.50f);
        account.deposit(5.50f);
        assertTrue(account.getAccountBalance() == 4006.00f);
        System.out.println("testDeposit Passed!");
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("Tom", 4000.50f);
        account.withdraw(5.50f);
        assertTrue(account.getAccountBalance() == 3995.00f);
        System.out.println("testWithdraw Passed!");
    }

    @Test
    public void testGetTransaction() {
        BankAccount account = new BankAccount("Tom", 4000.50f);
        account.withdraw(5.50f);
        account.deposit(10.00f);
        assertTrue(account.getTransaction().size() == 2);
        System.out.println("testGetTransaction Passed!");
    }

    @Test
    public void testGetAccountNumber() {
        BankAccount acct1 = new BankAccount("Tom", 4000.50f);
        BankAccount acct2 = new BankAccount("Jerry");
        assertTrue(!acct1.getAccountNumber().equals(acct2.getAccountNumber()));
        System.out.println("testGetAccountNumber Passed!");
    }

}
