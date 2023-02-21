package ro.uvt.dp.mediator;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.exceptions.UnacceptableOperationException;
import ro.uvt.dp.interfaces.Mediator;

public class Transfer implements Mediator {

    private double EURToRON(double sum) {
        return sum * 4.89;
    }

    private double RONToEUR(double sum) {
        return sum / 4.89;
    }

    private String getSuperClassName(Account acc) {
        return acc.getClass().getSuperclass().getName();
    }

    private String getClassName(Account acc) {
        return acc.getClass().getName();
    }

    @Override
    public void execute(Account acc1, Account acc2, double sum) throws UnacceptableOperationException {
        if (getSuperClassName(acc1).contains("AccountDecorated")
                && getSuperClassName(acc1).contains("AccountDecorated"))
            throw new UnacceptableOperationException("Transfer cannot be done between two Economy accounts");

        try {
            acc1.retrieve(sum);
            if (getClassName(acc1).contains("EUR") && !getClassName(acc2).contains("EUR"))
                sum = EURToRON(sum);
            else if (getClassName(acc1).contains("RON") && !getClassName(acc2).contains("RON"))
                sum = RONToEUR(sum);
            acc2.depose(sum);
        }
        catch (UnacceptableOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
