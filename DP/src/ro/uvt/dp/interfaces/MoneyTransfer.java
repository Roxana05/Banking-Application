package ro.uvt.dp.interfaces;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.exceptions.UnacceptableOperationException;

public interface MoneyTransfer {
	void transfer(Account c, double s) throws UnacceptableOperationException;
}
