package ro.uvt.dp.client;

import java.util.List;
import java.util.ArrayList;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.Account.TYPE;
import ro.uvt.dp.builder.*;
import ro.uvt.dp.accounts.AccountFactory;
import ro.uvt.dp.exceptions.UnacceptableOperationException;
import ro.uvt.dp.interfaces.Decorator;
import ro.uvt.dp.accounts.AccountDecorated;



public class Client implements Decorator {

	private String name;
	private String address;
	private final List<Account> accounts;
	
	private Client(Builder builder) {
		this.name = builder.name;
		this.address = builder.address;
		accounts = new ArrayList<>();
		addAccount(builder.type, builder.accountNr, builder.sum);
	}
	
	public static Name builder() {
		return new Builder();
	}

	@Override
	public void decorate(String accountNr, double sum, TYPE type) {
		AccountFactory factoryAcc = new AccountFactory(accountNr, sum);
		
		try {
			
			AccountDecorated acc = factoryAcc.getAccountDecorated(type);
			accounts.add(acc);
		}
		catch (UnacceptableOperationException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static class Builder implements Build, Name, Address, Type, AccountNr, Sum {

		private String name;
		private String address;
		private TYPE type;
		private String accountNr;
		private double sum;
		
		@Override
		public Build sum(double sum) {
			this.sum = sum;
			return this;
		}

		@Override
		public Sum accountNr(String accounrNr) {
			this.accountNr = accountNr;
			return this;
		}

		@Override
		public AccountNr type(TYPE type) {
			this.type = type;
			return this;
		}

		@Override
		public Type address(String address) {
			this.address = address;
			return this;
		}

		@Override
		public Address name(String name) {
			this.name = name;
			return this;
		}

		@Override
		public Client build() {
			return new Client(this);
		}
		
	}
	
	public void addAccount(Account.TYPE type, String accountNr, double sum) {
		
		AccountFactory factoryAccount = new AccountFactory(accountNr, sum);
		
		try {
			
			Account c = factoryAccount.getAccount(type);
			accounts.add(c);	
		}
		catch (UnacceptableOperationException e) {
			System.out.println(e.getMessage());
		}
	}

	public Account getAccount(String accountCode) {
		
		for (Account account: accounts) {
			if (account.getAccountNumber().equals(accountCode) && !account.isBlocked()) {
				return account;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		
		String result = "\n\tClient [name=" + name + ", address=" + address + ", accounts=";
		for (Account acc: accounts)
			result += acc.toString() + ", ";
		result += "\b\b]";
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void changeAddress(String address) {
		this.address = address;
	}
	
	public void blockAccount(String accountCode) {
		for (Account account: accounts) {
			if (account.getAccountNumber().equals(accountCode)) {
				account.blockAccount();
				System.out.println("Account number " + accountCode + " has been blocked.\n");
				return;
			}
		}
		
		System.out.println("Account number " + accountCode + " does not exist.\n");
	}
	
	public void closeAccount(String accountCode) throws UnacceptableOperationException {
		for (Account account: accounts) {
			if (account.getAccountNumber().equals(accountCode)) {
				if (!account.hasMoney()) {
					accounts.remove(account);
					System.out.println("Account number " + accountCode + " has been closed\n");
					return;
				}
				else {
					throw new UnacceptableOperationException("Account number " + accountCode + " still has funds. Cannot execute action.\n");
				}
			}
		}
		
		throw new UnacceptableOperationException("Account number " + accountCode + "does not exits.\n");
	}
	
	public boolean hasLoadedAccount() {
		for (Account account: accounts) {
			if (account.hasMoney())
				return true;
		}
		return false;
	}

}
