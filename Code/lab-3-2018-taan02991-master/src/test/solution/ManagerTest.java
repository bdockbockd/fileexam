package test.solution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Manager;
import logic.StoreManagement;

class ManagerTest {
	
	@Test
	void testTakeTimeOff() {
		Manager m1 = new Manager("manager", 100);
		assertEquals(200, m1.getWorkHours());
		m1.takeTimeOff(10);
		assertEquals(190, m1.getWorkHours());
		m1.takeTimeOff(30);
		assertEquals(160, m1.getWorkHours());
		
		Manager m2 = new Manager("manager", 100);
		assertEquals(200, m2.getWorkHours());
		m2.takeTimeOff(250);
		assertEquals(0, m2.getWorkHours());
	}
	
	@Test
	void testCalculateBonus() {
		Manager m1 = new Manager("manager", 100);
		assertEquals(200, m1.calculateBonus(), 0.00001);
		
		m1.takeTimeOff(10);
		assertEquals(190, m1.calculateBonus(), 0.00001);
		
		m1.addSalaryPerHour(10);
		assertEquals(209, m1.calculateBonus(), 0.00001);
		
		Manager m2 = new Manager("manager 2", 500);
		assertEquals(1000, m2.calculateBonus(), 0.00001);
		
		m2.takeTimeOff(50);
		assertEquals(750, m2.calculateBonus(), 0.00001);
		
		m2.addSalaryPerHour(10);
		assertEquals(765, m2.calculateBonus(), 0.00001);
	}
	
	@Test
	void testToString() {
		Manager m1 = new Manager("manager", 100);
		assertEquals(StoreManagement.StringFormat.managerString("manager", 200, 100, 200), m1.toString());
		
		Manager m2 = new Manager("manager 2", 500);
		assertEquals(StoreManagement.StringFormat.managerString("manager 2", 200, 500, 1000), m2.toString());
	}

}
