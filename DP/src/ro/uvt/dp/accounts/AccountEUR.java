package ro.uvt.dp.accounts;

import ro.uvt.dp.exceptions.UnacceptableOperationException;
import ro.uvt.dp.interfaces.MoneyTransfer;
import ro.uvt.dp.mediator.Transfer;

public class AccountEUR extends Account implements MoneyTransfer {

	private final Transfer transfer = new Transfer();
	
	public AccountEUR(String accountNr, double sum) throws UnacceptableOperationException{
		super(accountNr, sum);
	}

	public double getInterest() {
		return 0.01;

	}

	@Override
	public String toString() {
		return "Account EUR [" + super.toString() + "]";
	}

	@Override
	public void transfer(Account c, double s) {
		try{
			transfer.execute(this, c, s);
		}
		catch (UnacceptableOperationException e) {
			System.out.println(e.getMessage());
		}
	}
}
