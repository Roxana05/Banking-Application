package ro.uvt.dp.accounts;

import ro.uvt.dp.exceptions.UnacceptableOperationException;
import ro.uvt.dp.interfaces.MoneyTransfer;
import ro.uvt.dp.mediator.Transfer;

public class AccountDecoratedEUR extends AccountDecorated implements MoneyTransfer {
    
	private final Transfer transfer = new Transfer();
    
	public AccountDecoratedEUR(String accountNr, double sum) throws UnacceptableOperationException {
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
    public void transfer(Account c, double s) throws UnacceptableOperationException {
        try {
            transfer.execute(this, c, s);
        }
        catch (UnacceptableOperationException e) {
            throw new UnacceptableOperationException(e.getMessage());
        }
    }
}
