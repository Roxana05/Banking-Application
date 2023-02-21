package ro.uvt.dp.demos;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.AccountFactory;
import ro.uvt.dp.exceptions.UnacceptableOperationException;

public class MediatorDemo {
	public static void main(String[] args) throws UnacceptableOperationException {
        AccountFactory factory = new AccountFactory("RO485", 30);
        Account acc1 = factory.getAccountRON();

        factory.reset("RO61458", 40);

        Account acc2 = factory.getAccountRON();

        System.out.println(acc1.toString());
        System.out.println(acc2.toString());

        acc1.transfer(acc2, 10);

        System.out.println("-------------------------------");
        System.out.println(acc1.toString());
        System.out.println(acc2.toString());
    }
}
