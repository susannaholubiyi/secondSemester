package bank;

import javax.swing.*;

public class BankApp {
    private static final String smiley = "\uD83D\uDE00";
    private static final Bank myBankApp = new Bank();

    private static void print(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    private static String input(String prompt){
        return JOptionPane.showInputDialog(prompt + " ");

    }
    private static void mainMenu(){
        String menu = """
                **************** Welcome to SBBank ****************
                
                Enter any of the following numbers to carry out an action
                1-> Open an account
                2-> Deposit
                3-> Withdraw
                4-> Transfer
                5-> Check account balance
                6-> Find account
                7-> Close account
                8-> Exit App
                
                <><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
                """;
        String choice = input(menu);

        switch (choice){
            case "1" :
                String firstName = input("Enter your first name:");
                String lastName = input("Enter your last name:");
                String pin = input("Chose your desired four digit pin:");
                try {
                    Account account = myBankApp.registerCustomer(firstName,lastName,pin);
                    String barbecue = "\uD83C\uDF56";
                    print("Account has been successfully opened! Here's a Barbieque for you " + barbecue);
                    print("Your account number is " + account.getAccountNumber());

                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {

                    mainMenu();
                }
                break;
            case  "2":
                String amount = input("Enter the amount you want to deposit:");
                String accountNumber = input("Enter your accountNumber:");
                try {
                    myBankApp.deposit(Integer.parseInt(amount), Integer.parseInt(accountNumber));
                    print(amount +" deposited successfully " + smiley);

                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {
                    mainMenu();
                }
            case "3":
                accountNumber = input("Enter your accountNumber:");
                amount = input("Enter the amount you want to withdraw:");
                pin = input("Enter your pin: ");
                try {
                    myBankApp.withdraw(Integer.parseInt(accountNumber),Integer.parseInt(amount),pin);
                    print(amount+ " withdrawn successfully " + smiley);
                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {
                    mainMenu();
                }
            case "4":
                String senderAccount = input("Enter your accountNumber:");
                String receiverAccount = input("Enter the accountNumber you want to send to:");
                amount = input("Enter the amount you want to deposit:");
                pin = input("Enter your pin:");

                try {
                    myBankApp.transfer(Integer.parseInt(senderAccount),Integer.parseInt(receiverAccount),
                            Integer.parseInt(amount),pin);
                    print("Transfer successfully done" + smiley);
                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {
                    mainMenu();
                }
            case "5":
                accountNumber = input("Enter your accountNumber:");
                pin = input("Enter your pin");
                try {
                    int balance = myBankApp.checkBalance(Integer.parseInt(accountNumber), pin);
                    print("Your balance is: " + balance);
                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {
                    mainMenu();
                }
            case "6":{
                accountNumber = input("Enter your accountNumber:");
                try {
                    var bank = myBankApp.findAccount(Integer.parseInt(accountNumber));
                    print(String.valueOf(bank));
                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {
                    mainMenu();
                }
            }
            case "7":
                accountNumber = input("Enter your accountNumber:");
                pin = input("Enter your pin");
                try {
                    myBankApp.removeAccount(Integer.parseInt(accountNumber), pin);
                }
                catch (Exception e){
                    print(e.getMessage());
                }
                finally {
                    mainMenu();
                }
            case "8":
                System.exit(69);
                break;
            default:mainMenu();
        }
    }
    public static void main(String[] args) {
        mainMenu();

    }
}
