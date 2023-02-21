package ro.uvt.dp.singleton;

import ro.uvt.dp.bank.Bank;
import ro.uvt.dp.client.Client;

public class UnicityValidator {
	
	private static UnicityValidator singleInstance = null;
	
	private UnicityValidator() {
		
	}
	
	public static UnicityValidator getInstance() {
		
		if (singleInstance == null)
			singleInstance = new UnicityValidator();
		
		return singleInstance;
	}
	
	public boolean isUnique(String name, Bank bank) {
		
		for(Client client:bank.getClients()) {
			if (client.getName().equals(name)) {
				return false;
			}
		}
		
		return true;
	}

}
