package ro.uvt.dp.interfaces;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.exceptions.UnacceptableOperationException;

public interface Mediator {
    void execute(Account acc1, Account acc2, double sum) throws UnacceptableOperationException;
}
