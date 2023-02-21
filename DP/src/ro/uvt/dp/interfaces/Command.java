package ro.uvt.dp.interfaces;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.exceptions.UnacceptableOperationException;

public interface Command {
	void execute(Account account, double amount) throws UnacceptableOperationException;
}
