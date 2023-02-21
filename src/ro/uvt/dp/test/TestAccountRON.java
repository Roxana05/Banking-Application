package ro.uvt.dp.test;

import ro.uvt.dp.accounts.Account;
import ro.uvt.dp.accounts.AccountRON;
import ro.uvt.dp.exceptions.UnacceptableOperationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestAccountRON {
	
	@Test
	public void checkAccountNumber() throws UnacceptableOperationException {
		Account acc = new AccountRON("AccountNr", 30);
		assertEquals(acc.getAccountNumber(), "AccountNr", "Account number is assigned incorrectly");
	}
	
	@Test
	public void checkDepose() throws UnacceptableOperationException {
		Account acc = new AccountRON("AccountNr", 30);
		acc.depose(10.5);
		assertEquals(acc.getAmount(), 40.5, "Deposition failed");
	}
	
	@Test
	public void checkNegativeDeposition() throws UnacceptableOperationException {
		Account acc = new AccountRON("AccountNr", 30);
		assertThrows(UnacceptableOperationException.class,
				() -> {acc.depose(-1.5);}, "Negative deposition");

	}
	
	@Test
	public void checkRetrieve() throws UnacceptableOperationException {
		Account acc = new AccountRON("AccountNr", 30);
		acc.depose(10.5);
		assertEquals(acc.getAmount(), 40.5, "Deposition failed");
	}

	@Test
    public void checkRetrieveLargerSum() throws UnacceptableOperationException {
        Account acc = new AccountRON("AccountNr", 30);
        assertThrows(UnacceptableOperationException.class,
            () -> {acc.retrieve(40);}, "Retrieved sum is larger than the amount in the account");
    }
	
	@Test
    public void checkRetrieveNegative() throws UnacceptableOperationException {
        Account acc = new AccountRON("AccountNr", 30);
        assertThrows(UnacceptableOperationException.class,
            () -> {acc.retrieve(-1.5);}, "Retrieve with negative sum");
    }
	
	@Test
    public void checkIsBlocked() throws UnacceptableOperationException {
        Account acc = new AccountRON("AccountNr", 30);
        assertEquals(acc.isBlocked(), false, "isBlocked function does not work correctly");
    }
	
    @Test
    public void checkBlockAccount() throws UnacceptableOperationException {
        Account acc = new AccountRON("AccountNr", 30);
        acc.blockAccount();
        assertEquals(acc.isBlocked(), true, "blockAccount function does not work correctly");
    }
    
    @Test
    public void checkUnblockAccount() throws UnacceptableOperationException {
        Account acc = new AccountRON("AccountNr", 30);
        acc.blockAccount();
        acc.unblockAccount();
        assertEquals(acc.isBlocked(), false, "unblockAccount function does not work correctly");
    }
    
    @Test
    public void checkHasMoney() throws UnacceptableOperationException {
        Account acc = new AccountRON("AccountNr", 30);
        assertEquals(acc.hasMoney(), true,
            "hasMoney sholud return true, because the account has money");
        acc.retrieve(30);
        assertEquals(acc.hasMoney(), false,
            "hasMoney should return false, because the account does not have money");
    }
    
    @Test
    public void checkGetInterest() throws UnacceptableOperationException {
        Account acc1 = new AccountRON("AccountNr1", 30);
        Account acc2 = new AccountRON("AccountNr2", 1000);
        assertEquals(acc1.getInterest(), 0.03, "Interest is not correct");
        assertEquals(acc2.getInterest(), 0.08, "Interest is not correct");
    }
    
    @Test
    public void checkGetTotalAmount() throws UnacceptableOperationException {
    	 Account acc1 = new AccountRON("AccountNr1", 30);
         Account acc2 = new AccountRON("AccountNr2", 1000);
         assertEquals(acc1.getTotalAmount(), 30.9,
             "Total ammount does not add correctly the interest with the amount");
         assertEquals(acc2.getTotalAmount(), 1080,
             "Total ammount does not add correctly the interest with the amount");
    }
    
    @Test
    public void checkToString() throws UnacceptableOperationException {
        Account acc = new AccountRON("AccountNr", 30);
        assertEquals(acc.toString(), "Account RON [Account: code = AccountNr, amount = 30.0]",
            acc.toString());
    }
    
    @Test
    public void checkTransfer() throws UnacceptableOperationException {
        AccountRON acc1 = new AccountRON("AccountNr1", 30);
        Account acc2 = new AccountRON("AccountNr2", 30);
        acc1.transfer(acc2, 20);
        assertEquals(acc1.getAmount(), 50, "Deposition into acc1 failed during transfer");
        assertEquals(acc2.getAmount(), 10, "Retrieve from acc2 failed during transfer");
    }

}
