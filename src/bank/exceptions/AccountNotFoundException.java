package bank.exceptions;

public class AccountNotFoundException extends NullPointerException{
    public AccountNotFoundException(String message){
        super(message);
    }
}
