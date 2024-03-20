package bank;

import bank.exceptions.AccountNotFoundException;
import bank.exceptions.InsufficientFundsException;
import bank.exceptions.InvalidAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BankTest {
    private final Bank myBank = new Bank();
    @BeforeEach
    public void bankInitializer(){
    }
   @Test
   public void bankRegistersCustomer_numberOfCustomersIncreasesToOneTest() {
       assertNotNull(myBank.registerCustomer("firstName", "lastName", "0000"));
       assertEquals(1, myBank.getNumberOfCustomer());

   }
   @Test
   public void registerCustomer_findAccount_accountIsReturnedTest(){
        Account account1 = myBank.registerCustomer("firstName", "lastName", "0000");
        assertEquals(account1, myBank.findAccount(1));
   }
   @Test
    public void findAccountThatDoesNotExist_accountNotFoundExceptionIsThrownTest(){
     assertThrows(AccountNotFoundException.class,()-> myBank.findAccount(1));
   }
   @Test
    public void registerCustomer_removeAccount_listOfAccountsIsZeroTest(){
       myBank.registerCustomer("firstName", "lastName", "0000");
       myBank.removeAccount(1,"0000");
       assertEquals(0,myBank.getNumberOfCustomer());
   }
    @Test
    public void registerTwoCustomers_removeSecondCustomer_firstCustomerIsPresentTest(){
        Account account1 = myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "0000");

       myBank.removeAccount(2,"0000");
        assertEquals(account1, myBank.findAccount(1));
        assertEquals(1,myBank.getNumberOfCustomer());
    }
    @Test
    public void registerTwoCustomers_removeFirstCustomer_secondCustomerIsPresentTest(){
        myBank.registerCustomer("firstName", "lastName", "0000");
        Account account1 = myBank.registerCustomer("firstName2", "lastName2", "0001");
        myBank.removeAccount(1,"0000");
        assertEquals(account1, myBank.findAccount(2));
       assertEquals(1,myBank.getNumberOfCustomer());
    }

    @Test
    public void registerThreeCustomers_removeSecondCustomer_checkFirstCustomerAndThirdCustomerTest(){
        Account account1 = myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "0000");
       Account account3 = myBank.registerCustomer("firstName", "lastName", "0000");

        myBank.removeAccount(2,"0000");
        assertEquals(account1, myBank.findAccount(1));
        assertEquals(account3, myBank.findAccount(3));
        assertEquals(2,myBank.getNumberOfCustomer());
    }
    @Test
    public void registerThreeCustomers_removeSecondCustomer__addFourthCustomer_removeThirdCustomer_checkFirstAndFourthCustomerTest(){
        Account account1 = myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.removeAccount(2,"0000");
        Account account4 =myBank.registerCustomer("firstName", "lastName", "0000");
        assertEquals(3,myBank.getNumberOfCustomer());
        myBank.removeAccount(3,"0000");
        assertEquals(2,myBank.getNumberOfCustomer());
        assertEquals(account1, myBank.findAccount(1));
        assertEquals(account4, myBank.findAccount(4));

    }
    @Test
    public void registerThreeAccounts_RemoveFirstAccount_firstAccountDoesNotExistTest(){
        myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "0000");
        assertEquals(3,myBank.getNumberOfCustomer());
        myBank.removeAccount(1,"0000");
        assertEquals(2,myBank.getNumberOfCustomer());
        assertThrows(AccountNotFoundException.class, () ->myBank.findAccount(1));
    }
    @Test
    public void deposit2kIntoAccount1_balanceIs2kTest(){
        Account firstCustomer =myBank.registerCustomer("firstName", "lastName", "0000");
        assertEquals(firstCustomer, myBank.findAccount(1));
        myBank.deposit(2_000,1);
        assertEquals(2_000,myBank.checkBalance(1,"0000"));
    }
    @Test
    public void depositNegativeAmountIntoAccount1_throwsInvalidAmountExceptionTest(){
        Account firstCustomer =myBank.registerCustomer("firstName", "lastName", "0000");
        assertEquals(firstCustomer, myBank.findAccount(1));
        assertThrows(InvalidAmountException.class, () ->myBank.deposit(-2_000,1));
    }
    @Test
    public void registerTwoCustomers_Deposit2kIntoSecondCustomerAccount_secondCustomerBalanceIs2kTest(){
        myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "0001");
        assertEquals(2,myBank.getNumberOfCustomer());
        assertEquals(0,myBank.checkBalance(1,"0000"));
        myBank.deposit(2_000,2);
        assertEquals(0,myBank.checkBalance(1,"0000"));
        assertEquals(2_000,myBank.checkBalance(2,"0001"));
    }
    @Test
    public void registerTwoCustomers_Deposit2kIntoSecondCustomerAccount_withdraw1k_secondCustomerBalanceIs1kTest(){
        myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "0001");
        assertEquals(2,myBank.getNumberOfCustomer());
        assertEquals(0,myBank.checkBalance(1,"0000"));
        myBank.deposit(2_000,2);
        myBank.withdraw(2,1_000,"0001");
        assertEquals(0,myBank.checkBalance(1,"0000"));
        assertEquals(1_000,myBank.checkBalance(2,"0001"));
    }
    @Test
    public void registerOneCustomer_withdraw1kWithoutDepositing_insufficientFundsExceptionTest(){
        myBank.registerCustomer("firstName", "lastName", "0000");
        assertEquals(0,myBank.checkBalance(1,"0000"));
        assertThrows(InsufficientFundsException.class, () -> myBank.withdraw(1,1_000,"0000"));
    }
    @Test
    public void deposit5kIntoAccount1_transfer2kToAccount2_account1BalanceIs2k_account2BalanceIs3kTest(){
        myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "1111");
        myBank.deposit(5_000,1);
        myBank.transfer(1,2,3_000,"0000");
        assertEquals(2_000,myBank.checkBalance(1,"0000"));
        assertEquals(3_000,myBank.checkBalance(2,"1111"));
    }
    @Test
    public void deposit5kIntoAccount1_transfer6kToAccount2_insufficientBalanceExceptionIsThrownTest(){
        myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "1111");
        myBank.deposit(5_000,1);
        assertThrows(InsufficientFundsException.class, () -> myBank.transfer(1,2,6_000,"0000"));
    }
    @Test
    public void deposit2kIntoAccount2_transfer2kToAccount1_account1BalanceIs2k_account2BalanceIsZeroTest(){
        myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "1111");
        myBank.deposit(2_000,2);
        myBank.transfer(2,1,2_000,"1111");
        assertEquals(2_000,myBank.checkBalance(1,"0000"));
        assertEquals(0,myBank.checkBalance(2,"1111"));
    }
    @Test
    public void registerTwoAccount_deleteAccount1_depositIntoAccountTwoAndTransferToAccount1_accountNotFoundExceptionIsThrownTest(){
        myBank.registerCustomer("firstName", "lastName", "0000");
        myBank.registerCustomer("firstName", "lastName", "1111");
        myBank.removeAccount(1,"0000");
        myBank.deposit(2_000,2);
        assertThrows(AccountNotFoundException.class,()->myBank.transfer(2,1,2_000,"1111"));
    }

}
