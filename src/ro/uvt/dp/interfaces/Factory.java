package ro.uvt.dp.interfaces;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.AccountDecorated;
import ro.uvt.dp.exceptions.UnacceptableOperationException;

public interface Factory {
	Account getAccount(Account.TYPE type) throws UnacceptableOperationException;
    Account getAccountRON() throws UnacceptableOperationException;
    Account getAccountEUR() throws UnacceptableOperationException;
    AccountDecorated getAccountDecorated(Account.TYPE type) throws UnacceptableOperationException;
    AccountDecorated getAccountDecoratedRON() throws UnacceptableOperationException;
    AccountDecorated getAccountDecoratedEUR() throws UnacceptableOperationException;
}