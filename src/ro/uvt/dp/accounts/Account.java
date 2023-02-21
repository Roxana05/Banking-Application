package ro.uvt.dp.accounts;

import ro.uvt.dp.commands.Depose;
import ro.uvt.dp.commands.Retrieve;
import ro.uvt.dp.exceptions.UnacceptableOperationException;
import ro.uvt.dp.interfaces.Operations;

public abstract class Account implements Operations {

	protected String accountCode = null;
	protected double amount = 0;
	protected boolean isBlocked = false;
	protected Retrieve retrieve = new Retrieve();
	protected Depose depose = new Depose();

	public enum TYPE {
		EUR, RON
	};

	protected Account(String accountNr, double sum) throws UnacceptableOperationException {
		this.accountCode = accountNr;
		try {
			depose(sum);
		}
		catch (UnacceptableOperationException e) {
			throw new UnacceptableOperationException(e.getMessage());
		}
	}

	@Override
	public double getTotalAmount() {

		return amount + amount * getInterest();
	}

	public void depose(double sum) throws UnacceptableOperationException {
		try {
			depose.execute(this, sum);
		}
		catch (UnacceptableOperationException e) {
			throw new UnacceptableOperationException(e.getMessage());
		}
	}


	public void retrieve(double sum) throws UnacceptableOperationException {
		try {
			retrieve.execute(this, sum);
		}
		catch (UnacceptableOperationException e) {
			throw new UnacceptableOperationException(e.getMessage());
		}
	}

	public String toString() {
		return "Account: code=" + accountCode + ", amount=" + amount;
	}

	public String getAccountNumber() {
		return accountCode;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public boolean isBlocked() {
		return isBlocked;
	}
	
	public void blockAccount() {
		isBlocked = true;
	}
	
	public void unblockAccount() {
		isBlocked = false;
	}
	
	public boolean hasMoney() {
		return getTotalAmount() != 0;
	}

	public void transfer(Account acc2, double i) throws UnacceptableOperationException {
		
	}
}
