package ro.uvt.dp.commands;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.exceptions.UnacceptableOperationException;
import ro.uvt.dp.interfaces.Command;

public class Depose implements Command {

	@Override
	public void execute(Account account, double amount) throws UnacceptableOperationException {
		if (amount <0 ) {
			throw new UnacceptableOperationException("The sum must be positive.");
		}
		
		account.setAmount(account.getAmount() + amount);
		
	}
	

}
