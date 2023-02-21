package ro.uvt.dp.test;


import org.junit.jupiter.api.Test;

import ro.uvt.dp.client.Client;
import ro.uvt.dp.exceptions.UnacceptableOperationException;
import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.Account.TYPE;
import ro.uvt.dp.accounts.AccountFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestClient {
    @Test
    public void builderInitTest(){
        Client client = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(200.9)
                .build();

        assertEquals(client.getName(), "Ionescu Alex");
    }

    @Test
    public void decorateTest(){
        List<Account> accountList = new ArrayList<>();

        Client client = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(200.9)
                .build();

        accountList.add(client.getAccount("EUR124"));
        client.decorate("AccNum", 20, Account.TYPE.EUR);
        accountList.add(client.getAccount("Economy AccNum"));

        System.out.println(accountList.get(1));
        assertEquals(accountList.size(), 2, "List size should be two");
        assertEquals(accountList.get(1).toString(), "Account EUR [Economy Account: code = Economy AccNum, amount = 20.0]");
    }

    @Test
    public void addAccountAndgetAccountTest() throws UnacceptableOperationException {
        Client client = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(200.9)
                .build();

        client.addAccount(TYPE.RON, "AccNum", 30);
        AccountFactory factory = new AccountFactory("AccNum", 30);
        Account acc = factory.getAccount(TYPE.RON);
        assertEquals(client.getAccount("AccNum").toString(), acc.toString());
    }

    @Test
    public void getNameTest() {
        Client client = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(200.9)
                .build();

        assertEquals(client.getName(), "Ionescu Alex");
    }

    @Test
    public void setNameTest() {
        Client client = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(200.9)
                .build();

        client.setName("Alex");

        assertEquals(client.getName(), "Alex");
    }

    @Test
    public void changeAddressTest() {
        Client client = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(200.9)
                .build();

        client.changeAddress("Brasov");

        assertEquals(client.getAddress(), "Brasov");
    }

    @Test
    public void hasAccountWithMoneyTest() {
        Client client = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(200.9)
                .build();

        assertTrue(client.hasLoadedAccount());
    }

    @Test
    public void blockAccountTest() {
        Client client = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(200.9)
                .build();

        client.blockAccount("EUR124");

        assertNull(client.getAccount("EUR124"));
    }

    @Test
    public void removeAccountTest() throws UnacceptableOperationException {
        Client client = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(0)
                .build();

        client.closeAccount("EUR124");
        assertNull(client.getAccount("EUR124"));

        try {
            client.closeAccount("EUR124");
        }
        catch (UnacceptableOperationException e) {
            assertEquals(e.getMessage(), "Account EUR124 does not exist.");
        }

        client.addAccount(TYPE.EUR, "EUR126", 20);
        try {
            client.closeAccount("EUR126");
        }
        catch (UnacceptableOperationException e) {
            assertEquals(e.getMessage(), "Account EUR126 cannot be removed, because it still has money.");
        }
    }

    @Test
    public void toStringTest() {
        Client client = Client.builder()
                .name("Ionescu Alex")
                .address("Timisoara")
                .type(Account.TYPE.EUR)
                .accountNr("EUR124")
                .sum(200.9)
                .build();

        assertEquals(client.toString(), "\n\tClient [name=Ionescu Alex, address=Timisoara, accounts=Account EUR [Account: code = EUR124, amount = 200.9]]",
                client.toString() + "\n\nClient [name=Ionescu Alex, address=Timisoara, accounts=Account EUR [Account: code = EUR124, amount = 200.9]]");
    }
}