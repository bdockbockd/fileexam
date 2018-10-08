package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Cashier;

class CashierTest {

	@Test
	void testCashier() {
		Cashier cashier = new Cashier();
		assertEquals(0, cashier.getGalleon());
		assertEquals(0, cashier.getSickle());
		assertEquals(0, cashier.getKnut());
	}

	@Test
	void testCashierIntIntInt() {
		
		// Normal case
		Cashier cashier = new Cashier(10, 20, 30);
		assertEquals(cashier.getGalleon(), 10);
		assertEquals(cashier.getSickle(), 20);
		assertEquals(cashier.getKnut(), 30);
		
		// If parameters < 1
		cashier = new Cashier(-1, -2, 3);
		assertEquals(cashier.getGalleon(), 0);
		assertEquals(cashier.getSickle(), 0);
		assertEquals(cashier.getKnut(), 3);
	}
	
	@Test
	void testAddCoin() {
		Cashier cashier = new Cashier(10, 10, 10);
		
		// add positive coins
		cashier.addCoin(20, 10, 0);
		assertEquals(cashier.getGalleon(), 30);
		assertEquals(cashier.getSickle(), 20);
		assertEquals(cashier.getKnut(), 10);
		
		// add negative coins
		cashier.addCoin(20, -10, 40);
		assertEquals(cashier.getGalleon(), 50);
		assertEquals(cashier.getSickle(), 20);
		assertEquals(cashier.getKnut(), 50);
	}

	@Test
	void testMakeChange() {
		
		// Normal case
		Cashier cashier = new Cashier(30, 20, 10);
		assertTrue(cashier.makeChange(10, 10, 10));
		assertEquals(cashier.getGalleon(), 20);
		assertEquals(cashier.getSickle(), 10);
		assertEquals(cashier.getKnut(), 0);
		
		// Not enough coins
		cashier = new Cashier(0, 20, 10);
		assertFalse(cashier.makeChange(10, 10, 10));
		assertEquals(cashier.getGalleon(), 0);
		assertEquals(cashier.getSickle(), 20);
		assertEquals(cashier.getKnut(), 10);
		
		// Negative coins
		assertFalse(cashier.makeChange(10, -10, 10));
		assertEquals(cashier.getGalleon(), 0);
		assertEquals(cashier.getSickle(), 20);
		assertEquals(cashier.getKnut(), 10);
	}

	@Test
	void testExchange() {
		Cashier cashier = new Cashier(100,100,100);
		cashier.exchange();
		assertEquals(cashier.getGalleon(), 106);
		assertEquals(cashier.getSickle(), 1);
		assertEquals(cashier.getKnut(), 13);
	}

	//////////////////// DO THIS FIRST ////////////////////
	@Test
	void testSteal() {
		Cashier cashier = new Cashier(100,100,100);
		assertTrue(cashier.steal());
		assertTrue(cashier.isEmpty());
		assertFalse(cashier.steal());
		//fail("DO THIS FIRST");
	}
	///////////////////////////////////////////////////////

	@Test
	void isEmpty() {
		Cashier cashier = new Cashier(0,0,0);
		assertTrue(cashier.isEmpty());
		cashier = new Cashier(1,1,0);
		assertFalse(cashier.isEmpty());
	}
	
	@Test
	void testGetGalleon() {
		Cashier cashier = new Cashier(20,0,0);
		assertEquals(cashier.getGalleon(), 20);
	}

	@Test
	void testGetSickle() {
		Cashier cashier = new Cashier(0,20,0);
		assertEquals(cashier.getSickle(), 20);
	}

	@Test
	void testGetKnut() {
		Cashier cashier = new Cashier(0,0,20);
		assertEquals(cashier.getKnut(), 20);
	}
	
}
