
package ro.uvt.dp.demos;

import ro.uvt.dp.accounts.AccountFactory;
import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.AccountDecorated;
import ro.uvt.dp.exceptions.UnacceptableOperationException;

public class AccountFactoryDemo {
	public static void main(String[] args) {
        AccountFactory accF = new AccountFactory("RO974", 570);
        try {
            Account acc = accF.getAccount(Account.TYPE.RON);
            System.out.println(acc.toString());
            
            accF.reset("Acc1", 360);
            
            AccountDecorated accountDec = accF.getAccountDecorated(Account.TYPE.EUR);
            System.out.println(accountDec.toString());
            
            accF.reset("Acc2", 830);
            Account acc1 = accF.getAccountEUR();
            System.out.println(acc1.toString());
        }
        catch (UnacceptableOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
