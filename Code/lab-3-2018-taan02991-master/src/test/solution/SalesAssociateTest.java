package test.solution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.StoreManagement;
import logic.SalesAssociate;

class SalesAssociateTest {

	@Test
	void testTakeTimeOff() {
		SalesAssociate s1 = new SalesAssociate("sale", 100, 0.5);
		assertEquals(200, s1.getWorkHours());
		s1.takeTimeOff(10);
		assertEquals(190, s1.getWorkHours());
		s1.takeTimeOff(30);
		assertEquals(160, s1.getWorkHours());
		
		SalesAssociate s2 = new SalesAssociate("sale", 100, 0.5);
		assertEquals(200, s2.getWorkHours());
		s2.takeTimeOff(250);
		assertEquals(0, s2.getWorkHours());
	}
	
	@Test
	void testCalculateBonus() {
		SalesAssociate s1 = new SalesAssociate("sale", 100, 0.1);
		assertEquals(200, s1.calculateBonus(), 0.00001);
		
		s1.takeTimeOff(10);
		assertEquals(190, s1.calculateBonus(), 0.00001);
		
		s1.addSalaryPerHour(10);
		assertEquals(209, s1.calculateBonus(), 0.00001);
		
		SalesAssociate s2 = new SalesAssociate("sale 2", 500, 0.5);
		assertEquals(30000, s2.calculateBonus(), 0.00001);
		
		s2.takeTimeOff(50);
		assertEquals(22500, s2.calculateBonus(), 0.00001);
		
		s2.addSalaryPerHour(10);
		assertEquals(22950, s2.calculateBonus(), 0.00001);
	}
	
	@Test
	void testToString() {
		SalesAssociate s1 = new SalesAssociate("sale", 100, 0.1);
		assertEquals(StoreManagement.StringFormat.salesAssociateString("sale", 200, 100, 10, 200), s1.toString());
		
		SalesAssociate s2 = new SalesAssociate("sale 2", 500, 0.5);
		assertEquals(StoreManagement.StringFormat.salesAssociateString("sale 2", 200, 500, 50, 30000), s2.toString());
	}

}
