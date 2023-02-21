package ro.uvt.dp.accounts;

import ro.uvt.dp.exceptions.UnacceptableOperationException;

public abstract class AccountDecorated extends Account{
	public AccountDecorated(String accountNr, double sum) throws UnacceptableOperationException {
        super("Economy " + accountNr, sum);
    }

    @Override
    public String toString() {
        return "Economy Account: code = " + accountCode + ", amount = " + amount;
    }
}
