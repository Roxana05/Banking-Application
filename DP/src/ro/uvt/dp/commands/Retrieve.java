package ro.uvt.dp.commands;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.exceptions.UnacceptableOperationException;
import ro.uvt.dp.interfaces.Command;

public class Retrieve implements Command {

	@Override
	public void execute(Account account, double amount) throws UnacceptableOperationException {
		if (amount > account.getAmount()) {
			throw new UnacceptableOperationException("Not enough funds.");
		}
		else if (amount < 0) {
			throw new UnacceptableOperationException("The sum must be positive.");
		}
		
		account.setAmount(account.getAmount() - amount);
		
	}
	

}
