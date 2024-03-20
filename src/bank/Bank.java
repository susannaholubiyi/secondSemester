package bank;

import bank.exceptions.InvalidPinException;

import java.util.ArrayList;

public class Bank {

    public Account registerCustomer(String firstName, String lastName, String pin) {
        String name = firstName +" " + lastName;
        Account account = new Account(accountNumber, name, pin);
        account.validate(pin);
        accounts.add(account);
        accountNumber++;
        return account;
    }
    public int getNumberOfCustomer() {
       return accounts.size();
    }

    public Account findAccount(int accountNumber) {
        for(Account account : accounts){
            if(account.getAccountNumber() == accountNumber){
                return account;}
        }
        throw new bank.exceptions.AccountNotFoundException("Account does not exist");
    }

    public void removeAccount(int accountNumber, String pin) {
        Account foundAccount = findAccount(accountNumber);
        if (!foundAccount.verifyPin(pin)) throw new InvalidPinException("Incorrect pin!");

        accounts.remove(foundAccount);
    }
    public void deposit(int amount, int accountNumber) {
        Account foundAccount = findAccount(accountNumber);
        foundAccount.deposit(amount);
    }
    public int checkBalance(int accountNumber, String pin) {
        Account foundAccount = findAccount(accountNumber);

        return foundAccount.checkBalance(pin);
    }
    public void withdraw(int accountNumber, int amount, String pin) {
        Account foundAccount = findAccount(accountNumber);
        foundAccount.withdraw(amount,pin);
    }
    public void transfer(int senderAccountNumber, int receiverAccountNumber, int amount, String pin) {
        Account senderAccount = findAccount(senderAccountNumber);
        Account receiverAccount = findAccount(receiverAccountNumber);
        senderAccount.withdraw(amount,pin);
        receiverAccount.deposit(amount);
    }


    private int accountNumber = 1;
    private final ArrayList<Account> accounts = new ArrayList<>();



}
