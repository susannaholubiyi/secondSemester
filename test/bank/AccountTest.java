package bank;

import bank.exceptions.InsufficientFundsException;
import bank.exceptions.InvalidAmountException;
import bank.exceptions.InvalidPinException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @Test
    public void depositMoney_moneyIsDepositedTest(){
        Account account = new Account(1, "name", "2000");
        assertEquals(0, account.checkBalance("2000"));
        account.deposit(1000);
        assertEquals(1000, account.checkBalance("2000"));

    }
    @Test
    public void depositMoneyLessThanZero_throwsInvalidAmountException(){
        Account account = new Account(1, "name", "0000");

        assertEquals(0, account.checkBalance("0000"));

        assertThrows(InvalidAmountException.class, () -> account.deposit(-10));
    }

    @Test
    public void depositMoney_withdrawWithinBalanceRange_withCorrectPin_moneyIsWithdrawnTest(){
        Account account = new Account(1, "name", "0101");

        assertEquals(0, account.checkBalance("0101"));
        account.deposit(1000);
        assertEquals(1000, account.checkBalance("0101"));
        account.withdraw(500,"0101");
        assertEquals(500, account.checkBalance("0101"));
    }

    @Test
    public void depositMoney_withdrawMoreThanBalance_throwInsufficientFundsExceptionTest(){
        Account account = new Account(1, "name", "0111");

        assertEquals(0, account.checkBalance("0111"));
        account.deposit(1000);
        assertEquals(1000, account.checkBalance("0111"));

        assertThrows(InsufficientFundsException.class, () -> account.withdraw(1500,"0111"));
    }



    @Test
    public void withdrawWithPinMoreThanFourCharactersLong_invalidPinExceptionIsThrownTest() {
        Account account = new Account(1, "name", "1222");

        account.deposit(1000);
        assertThrows(InvalidPinException.class, () -> account.withdraw(500, "12345"));
    }

    @Test
    public void withdrawWithIncorrectPin_invalidPinExceptionIsThrownTest() {
        Account account = new Account(1, "name", "1234");
        account.deposit(1000);

        assertThrows(InvalidPinException.class, () -> account.withdraw(500, "1233"));
    }

    @Test
    public void depositMoney_checkBalanceTest(){
        Account account = new Account(1, "name", "1234");

        account.deposit(1000);
        assertEquals(1000, account.checkBalance("1234"));

    }
    @Test
    public void checkBalanceWithInvalidPin_invalidPinExceptionIsThrownTest(){
        Account account = new Account(1, "name", "1232");

        account.deposit(1000);
        assertThrows(InvalidPinException.class, () -> account.checkBalance("1000"));
    }
}