package ro.uvt.dp.interfaces;

import ro.uvt.dp.accounts.Account;

public interface Decorator {
	void decorate(String accountNr, double sum, Account.TYPE type);

}
