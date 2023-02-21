package ro.uvt.dp.test;

import org.junit.jupiter.api.Test;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.AccountDecoratedRON;
import ro.uvt.dp.accounts.AccountEUR;
import ro.uvt.dp.accounts.AccountFactory;
import ro.uvt.dp.exceptions.UnacceptableOperationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestAccountFactory {
    @Test
    public void compareAccEURWithAccEURFactory() throws UnacceptableOperationException {
        Account acc1 = new AccountEUR("AccNum", 65);

        AccountFactory accFact = new AccountFactory("AccNum", 65);
        Account acc2 = accFact.getAccount(Account.TYPE.EUR);

        assertEquals(acc1.toString(), acc2.toString(), "acc1 and acc2 should be equal");
    }

    @Test
    public void compareAccDecoRONWithAccDecoFactory() throws UnacceptableOperationException {
        Account acc1 = new AccountDecoratedRON("AccNum", 65);

        AccountFactory accFact = new AccountFactory("AccNum", 65);
        Account acc2 = accFact.getAccountDecorated(Account.TYPE.RON);

        assertEquals(acc1.toString(), acc2.toString(), "acc1 and acc2 should be equal");
    }

    @Test
    public void getAccountEURCheck() throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("AccNum", 65);

        Account acc1 = factory.getAccountEUR();
        Account acc2 = factory.getAccountEUR();

        assertEquals(acc1.toString(), acc2.toString());
    }

    @Test
    public void getAccountRONCheck() throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("AccNum", 65);

        Account acc1 = factory.getAccountRON();
        Account acc2 = factory.getAccountRON();

        assertEquals(acc1.toString(), acc2.toString());
    }

    @Test
    public void getAccountDecoratedEUR() throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("AccNum", 65);

        Account acc1 = factory.getAccountDecoratedEUR();
        Account acc2 = factory.getAccountDecoratedEUR();

        assertEquals(acc1.toString(), acc2.toString());
    }

    @Test
    public void getAccountDecoratedRON() throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("AccNum", 65);

        Account acc1 = factory.getAccountDecoratedRON();
        Account acc2 = factory.getAccountDecoratedRON();

        assertEquals(acc1.toString(), acc2.toString());
    }

    @Test
    public void accountResetFunctionality() throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("AccNum", 65);

        Account acc1 = factory.getAccountRON();
        factory.reset("AccNum2", 21);

        Account acc2 = factory.getAccountRON();

        assertNotEquals(acc1.toString(), acc2.toString());
    }
}