package ro.uvt.dp.demos;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.AccountFactory;
import ro.uvt.dp.exceptions.UnacceptableOperationException;

public class CommandDemo {
	public static void main(String[] args) throws UnacceptableOperationException {
        AccountFactory accountFactory = new AccountFactory("RO974", 40);
        Account account = accountFactory.getAccountRON();

        System.out.println(account.toString());
        account.depose(10);
        System.out.println(account.toString());
        account.retrieve(15);
        System.out.println(account.toString());
	}
}