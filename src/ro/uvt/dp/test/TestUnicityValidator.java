package ro.uvt.dp.test;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.bank.Bank;
import ro.uvt.dp.client.Client;
import org.junit.jupiter.api.Test;
import ro.uvt.dp.singleton.UnicityValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUnicityValidator {

    @Test
    public void uniqueCase(){
        Bank bank = new Bank("BCR");

        UnicityValidator validator = UnicityValidator.getInstance();

        Client c11 = Client.builder()
                .name("Ionescu Alex")
                .address("Brasov")
                .type(Account.TYPE.EUR)
                .accountNr("EUR128")
                .sum(700)
                .build();

        Client c12 = Client.builder()
                .name("Pop Maria")
                .address("Timisoara")
                .type(Account.TYPE.RON)
                .accountNr("RON126")
                .sum(100)
                .build();

        bank.addClient(c11);
        bank.addClient(c12);

        assertTrue(validator.isUnique("Ciucioiu Roxana", bank));
    }

    @Test
    public void duplicateCase(){
        Bank bank = new Bank("BCR");

        UnicityValidator validator = UnicityValidator.getInstance();

        Client c11 = Client.builder()
                .name("Petre Albert")
                .address("Brasov")
                .type(Account.TYPE.EUR)
                .accountNr("EUR128")
                .sum(700)
                .build();

        Client c12 = Client.builder()
                .name("Pop Maria")
                .address("Timisoara")
                .type(Account.TYPE.RON)
                .accountNr("RON126")
                .sum(100)
                .build();

        bank.addClient(c11);
        bank.addClient(c12);

        assertFalse(validator.isUnique("Pop Maria", bank));
    }
}