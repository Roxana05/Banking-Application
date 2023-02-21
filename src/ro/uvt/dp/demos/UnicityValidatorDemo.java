package ro.uvt.dp.demos;

import ro.uvt.dp.accounts.Account.TYPE;
import ro.uvt.dp.bank.Bank;
import ro.uvt.dp.client.Client;
import ro.uvt.dp.singleton.UnicityValidator;

public class UnicityValidatorDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("BCR");

        UnicityValidator validator = UnicityValidator.getInstance();

        Client cl1 = Client.builder()
                .name("Alex Bungau")
                .address("Cluj")
                .type(TYPE.EUR)
                .accountNr("EU128")
                .sum(630)
                .build();

        Client cl2 = Client.builder()
                .name("Albert Petre")
                .address("Timisoara")
                .type(TYPE.RON)
                .accountNr("RO126")
                .sum(7610)
                .build();

        bank.addClient(cl1);
        bank.addClient(cl2);

        if(validator.isUnique("Alex Bungau", bank)) {
            System.out.println("This client is new to this bank.");
        }
        else {
            System.out.println("The name of the client already exists within this bank.");
        }

        if(validator.isUnique("Roxana Ciucioiu", bank)) {
            System.out.println("This client is new to this bank.");
        }
        else {
            System.out.println("The name of the client already exists within this bank.");
        }
    }
}