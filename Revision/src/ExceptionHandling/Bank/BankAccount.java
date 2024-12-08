package ExceptionHandling.Bank;

import java.util.Objects;

public class BankAccount {
    int AccountNumber;
    String AccountHolderName;
    float balance;
    boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public BankAccount(int AccountNumber, String AccountHolderName, float balance,boolean isAdmin){
        this.balance = balance;
        this.AccountHolderName = AccountHolderName;
        this.AccountNumber = AccountNumber;
        this.isAdmin = false;
    }
    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        AccountHolderName = accountHolderName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void deposit(float amount) throws Exception{
        try {
            HandleBankAccountErrors.isValidAmount(amount);
            balance += amount;
            System.out.println("Amount Transferred successfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void withdraw(float amount){
        try{
            HandleBankAccountErrors.haveSufficientAmount(balance,amount);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}