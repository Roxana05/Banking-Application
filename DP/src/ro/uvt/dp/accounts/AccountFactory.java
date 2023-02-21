package ro.uvt.dp.accounts;

import ro.uvt.dp.accounts.Account.TYPE;
import ro.uvt.dp.exceptions.UnacceptableOperationException;
import ro.uvt.dp.interfaces.Factory;

public class AccountFactory implements Factory{
	
	private String accountNr;
	private double sum;
	
	public AccountFactory(String accountNr, double sum) {
		this.accountNr = accountNr;
		this.sum = sum;
	}
	
	@Override
	public Account getAccount(Account.TYPE type) throws UnacceptableOperationException {
		if (type == Account.TYPE.RON)
			return new AccountRON(accountNr, sum);
		else
			return new AccountEUR(accountNr, sum);
	}

	@Override
	public Account getAccountRON() throws UnacceptableOperationException {
		return new AccountRON(accountNr, sum);
	}

	@Override
	public Account getAccountEUR() throws UnacceptableOperationException {
		return new AccountEUR(accountNr, sum);
	}

	@Override
	public AccountDecorated getAccountDecorated(Account.TYPE type) throws UnacceptableOperationException {
		if (type == Account.TYPE.RON)
			return new AccountDecoratedRON(accountNr, sum);
		else
			return new AccountDecoratedEUR(accountNr, sum);
	}

	@Override
	public AccountDecorated getAccountDecoratedRON() throws UnacceptableOperationException {
		return new AccountDecoratedRON(accountNr, sum);
	}

	@Override
	public AccountDecorated getAccountDecoratedEUR() throws UnacceptableOperationException {
		return new AccountDecoratedEUR(accountNr, sum);
	}
	
	public void reset(String accountNr, double sum) {
		this.accountNr = accountNr;
		this.sum = sum;
	}

}
