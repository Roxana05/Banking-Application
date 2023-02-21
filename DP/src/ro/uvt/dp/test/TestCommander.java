package ro.uvt.dp.test;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.AccountFactory;
import ro.uvt.dp.exceptions.UnacceptableOperationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCommander {
    @Test
    public void retrieveWithNegativeAmount() throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("AccNum", 30);

        Account acc = factory.getAccountRON();

        try {
            acc.retrieve(-20);
        } catch(UnacceptableOperationException e){
            Assertions.assertEquals("The sum must be positive.", e.getMessage());
        }

    }

    @Test
    public void retrieveWithPositiveAmount() throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("AccNum", 30);

        Account acc = factory.getAccountRON();

        try {
            acc.retrieve(40);
        } catch(UnacceptableOperationException e){
            Assertions.assertEquals("Not enough funds.", e.getMessage());
        }

    }

    @Test
    public void deposeWithNegativeAmount() throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("AccNum", 30);

        Account acc = factory.getAccountRON();

        try {
            acc.depose(-20);
        } catch(UnacceptableOperationException e){
            Assertions.assertEquals("The sum must be positive.", e.getMessage());
        }

    }
}