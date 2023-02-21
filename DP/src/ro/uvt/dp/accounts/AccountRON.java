package ro.uvt.dp.accounts;

import ro.uvt.dp.exceptions.UnacceptableOperationException;
import ro.uvt.dp.interfaces.MoneyTransfer;
import ro.uvt.dp.mediator.Transfer;

public class AccountRON extends Account implements MoneyTransfer {

	private final Transfer transfer = new Transfer();
	
	public AccountRON(String accountNr, double sum) throws UnacceptableOperationException {
		super(accountNr, sum);
	}

	public double getInterest() {
		if (amount < 500)
			return 0.03;
		return 0.08;

	}

	@Override
	public String toString() {
		return "Account RON [" + super.toString() + "]";
	}

	@Override
	public void transfer(Account c, double s) {
		try {
			transfer.execute(this, c, s);
		}
		catch (UnacceptableOperationException e) {
			System.out.println(e.getMessage());
		}
	}
}
