package bank;

import bank.exceptions.InsufficientFundsException;
import bank.exceptions.InvalidAmountException;
import bank.exceptions.InvalidPinException;

public class Account {
    private int balance;
    private final String pin;
    private String name;
    private final int number;


    public Account(int accountNumber, String name, String pin){
        if(pin.length() != 4){
            throw new InvalidPinException("Pin should be four digits");
        }
        this.pin = pin;
        this.name = name;
        this.balance = 0;
        this.number = accountNumber;

    }

    public int getAccountNumber(){
        return number;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString(){
        return this.name;
    }
    public void deposit(int amount) {
        if(amount < 0) {
            throw new InvalidAmountException("Cannot deposit invalid amount");
        }
            balance += amount;
    }
    public int checkBalance(String pin) {
       validate(pin);
       return balance;
    }

    public void withdraw(int amount, String pin) {
        validate(pin);
        if(amount > balance){
            throw new InsufficientFundsException("Insufficient balance, would you like to deposit?");
        }
        balance -= amount;
    }

    public void validate(String pin) {
        if(!this.pin.equals(pin)){
            throw new InvalidPinException("Incorrect pin!");
        }
    }

    public boolean verifyPin(String pin) {
        return this.pin.equals(pin);
    }

}
