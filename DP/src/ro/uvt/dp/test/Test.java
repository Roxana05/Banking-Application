package ro.uvt.dp.test;

import ro.uvt.dp.bank.Bank;
import ro.uvt.dp.client.Client;
import ro.uvt.dp.exceptions.UnacceptableOperationException;
import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.AccountRON;

public class Test {

	public static void main(String[] args) {
		/**
		 * Create BCR bank with 2 clients
		 */
		Bank bcr = new Bank("Bank BCR");
		// create client Ionescu with 2 accounts, one in EUR, one in RON
		Client cl1 = Client.builder()
				.name("Ionescu Alex")
				.address("Timisoara")
				.type(Account.TYPE.EUR)
				.accountNr("EU124")
				.sum(200.9)
				.build();
		bcr.addClient(cl1);
		cl1.addAccount(Account.TYPE.RON, "RO1234", 400);
		// create client Marinescu with an account in RON
		Client cl2 = Client.builder()
				.name("Marinescu Ion")
				.address("Timisoara")
				.type(Account.TYPE.RON)
				.accountNr("RO126")
				.sum(100)
				.build();
		bcr.addClient(cl2);
		System.out.println(bcr);

		/**
		 * Create bank CEC with one client
		 */
		Bank cec = new Bank("Bank CEC");
		Client clientCEC = Client.builder()
				.name("Petre Albert")
				.address("Cluj")
				.type(Account.TYPE.EUR)
				.accountNr("EU128")
				.sum(700)
				.build();
		cec.addClient(clientCEC);
		System.out.println(cec);

		// depose in account RON126 of client Marinescu
		Client cl = bcr.getClient("Marinescu Ion");
		if (cl != null) {
			try {
				cl.getAccount("RON126").depose(400);
				System.out.println(cl);
			}
			catch (UnacceptableOperationException e){
				System.out.println(e.getMessage());
			}
		}

		// retrieve from account RON126 of Marinescu client
		if (cl != null) {
			try {
				cl.getAccount("RON126").retrieve(32);
				System.out.println(cl);
			}
			catch (UnacceptableOperationException e){
				System.out.println(e.getMessage());
			}
		}

		// transfer between accounts RON126 and RON1234
		AccountRON c1 = (AccountRON) cl.getAccount("RON126");
		AccountRON c2 = (AccountRON) bcr.getClient("Ionescu Alex").getAccount("RON1234");
		c1.transfer(c2, 40);
		System.out.println(bcr);

	}

}
