package ro.uvt.dp.demos;

import ro.uvt.dp.accounts.Account.TYPE;
import ro.uvt.dp.client.Client;

public class DecoratorDemo {
    public static void main(String args[]) {
        Client cl = Client.builder()
        		.name("Alex")
        		.address("Cluj")
        		.type(TYPE.EUR)
        		.accountNr("EU539")
        		.sum(53)
        		.build();
        
        System.out.println(cl.toString());
        
        cl.decorate("RO539", 50, TYPE.EUR);
        
        System.out.println(cl.toString());
    }
}
