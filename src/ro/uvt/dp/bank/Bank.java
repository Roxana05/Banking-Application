package ro.uvt.dp.bank;

import java.util.List;
import java.util.ArrayList;

import ro.uvt.dp.client.Client;

public class Bank {

	private final List<Client> clients;
	private final String bankCode;

	public Bank(String bankCode) {
		this.bankCode = bankCode;
		clients = new ArrayList<>();
	}

	public void addClient(Client c) {
		clients.add(c);
	}

	public void removeClient(Client c) {
		if (c.hasLoadedAccount()) {
			System.out.println("The client is still active\n");
			return;
		}
		clients.remove(c);
	}
	
	public Client getClient(String name) {
		for (Client client: clients) {
			if (client.getName().equals(name)) {
				return client;
			}
		}
		return null;
	}
	@Override
	public String toString() {
		return "Bank [code=" + bankCode + ", clients=" + clients.toString() + "]";
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public String getBankCode() {
		return bankCode;
	}

}
