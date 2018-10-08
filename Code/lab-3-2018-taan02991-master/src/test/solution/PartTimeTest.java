package test.solution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.PartTime;
import logic.StoreManagement;

class PartTimeTest {
	
	@Test
	void testAddTips() {
		PartTime p1 = new PartTime("parttime", 100);
		assertEquals(0, p1.getAccumulatedTips());
		p1.addTips(100);
		assertEquals(100, p1.getAccumulatedTips());
		p1.addTips(200);
		assertEquals(300, p1.getAccumulatedTips());
	}

	@Test
	void testOnDuty() {
		PartTime p1 = new PartTime("parttime", 100);
		assertEquals(0, p1.getWorkHours());
		p1.onDuty(100);
		assertEquals(100, p1.getWorkHours());
		p1.onDuty(0);
		assertEquals(100, p1.getWorkHours());
		p1.onDuty(-1);
		assertEquals(100, p1.getWorkHours());
	}
	
	@Test
	void testCalculateBonus() {
		PartTime p1 = new PartTime("parttime", 100);
		assertEquals(0, p1.calculateBonus(), 0.00001);
		p1.addTips(1000);
		assertEquals(500, p1.calculateBonus(), 0.00001);
		
		PartTime p2 = new PartTime("parttime 2", 500);
		assertEquals(0, p2.calculateBonus(), 0.00001);
		p2.addTips(100);
		assertEquals(50, p2.calculateBonus(), 0.00001);
	}
	
	@Test
	void testToString() {
		PartTime p1 = new PartTime("parttime", 100);
		assertEquals(StoreManagement.StringFormat.partTimeString("parttime", 0, 100, 0), p1.toString());
		
		PartTime p2 = new PartTime("parttime 2", 500);
		assertEquals(StoreManagement.StringFormat.partTimeString("parttime 2", 0, 500, 0), p2.toString());
	}
	
	@Test
	void testEquals() {
		PartTime p1 = new PartTime("parttime", 100);
		PartTime p2 = new PartTime("parttime", 100);
		PartTime p3 = new PartTime("parttime", 200);
		PartTime p4 = new PartTime("new parttime", 200);
		assertTrue(p2.equals(p1));
		p1.addTips(100);
		assertFalse(p2.equals(p1));
		assertFalse(p2.equals(p3));
		assertFalse(p3.equals(p4));
	}
	
	@Test
	void testClone() {
		PartTime p1 = new PartTime("parttime", 100);
		PartTime p2 = (PartTime) p1.clone();
		assertTrue(p1.equals(p2));
		
	}

}
