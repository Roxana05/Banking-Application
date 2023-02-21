package ro.uvt.dp.test;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.AccountFactory;
import ro.uvt.dp.exceptions.UnacceptableOperationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMediator {

    @Test
    public void transferBetweenSameTypeOfAccounts() throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("AccNum1", 30);
        Account acc1 = factory.getAccountRON();
        factory.reset("AccNum2", 30);
        Account acc2 = factory.getAccountRON();

        acc1.transfer(acc2, 20);

        assertEquals(acc1.getAmount(), 10);
        assertEquals(acc2.getAmount(), 50);
    }

    @Test
    public void transferBetweenDifferentTypeOfAccounts() throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("AccNum1", 30);
        Account acc1 = factory.getAccountRON();
        factory.reset("AccNum2", 30);
        Account acc2 = factory.getAccountEUR();

        acc1.transfer(acc2, 4.89);

        assertEquals(acc1.getAmount(), 25.11);
        assertEquals(acc2.getAmount(), 31);
    }

    @Test
    public void transferBetweenTwoEconomyAccounts() throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("AccNum1", 30);
        Account acc1 = factory.getAccountDecoratedRON();
        factory.reset("AccNum2", 30);
        Account acc2 = factory.getAccountDecoratedRON();

        try {
            acc1.transfer(acc2, 20);
        } catch(UnacceptableOperationException e){
            assertEquals("Transfer cannot be done between two Economy accounts", e.getMessage());
        }
    }
}
