package ro.uvt.dp.demos;

import ro.uvt.dp.client.Client;
import ro.uvt.dp.accounts.Account;

public class ClientBuilderDemo {
    public static void main(String[] args) {

        Client cl1 = Client.builder()
        		.name("Alex")
        		.address("Cluj")
        		.type(Account.TYPE.RON)
        		.accountNr("RO539")
        		.sum(530)
        		.build();

        Client cl2 = Client.builder()
        		.name("Albert")
        		.address("Timisoara")
        		.type(Account.TYPE.EUR)
        		.accountNr("EU261")
        		.sum(5329)
        		.build();

        
        System.out.println(cl1.toString());
        System.out.println(cl2.toString());
    }
}
