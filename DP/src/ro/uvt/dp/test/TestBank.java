package ro.uvt.dp.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ro.uvt.dp.bank.Bank;
import ro.uvt.dp.client.Client;
import ro.uvt.dp.accounts.Account;

public class TestBank {
    @Test
    public void addClientTest(){
        Bank bank = new Bank("BankNum");

        Client cl1 = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(200.9)
                .build();

        bank.addClient(cl1);

        Assertions.assertEquals(bank.getClients().size(), 1);
    }

    @Test
    public void removeClientTest(){
        Bank bank = new Bank("BankNum");

        Client cl1 = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(0)
                .build();

        bank.addClient(cl1);
        bank.removeClient(cl1);

        Assertions.assertEquals(bank.getClients().size(), 0);
    }

    @Test
    public void getClientTest(){
        Bank bank = new Bank("BankNum");

        Client cl1 = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(0)
                .build();

        bank.addClient(cl1);

        Assertions.assertEquals(bank.getClient("Ionescu Alex"), cl1);
    }

    @Test
    public void getClientsTest(){
        Bank bank = new Bank("BankNum");

        Client cl1 = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(0)
                .build();

        Client cl2 = Client.builder()
                .name("Petre Albert")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR101")
                .sum(0)
                .build();

        bank.addClient(cl1);
        bank.addClient(cl2);

        Assertions.assertEquals(bank.getClients().size(), 2);
    }

    @Test
    public void toStringTest() {
        Bank bank = new Bank("BankNum");

        Client cl1 = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(0)
                .build();

        bank.addClient(cl1);

        Assertions.assertEquals(bank.toString(),
                "Bank [code=BankNum, clients=\n" +
                        "\tClient [name=Ionescu Alex, address=Timisoara, accounts=Account EUR [Account: code = EUR124, amount = 0.0]]]");
    }
}