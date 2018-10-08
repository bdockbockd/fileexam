package test;

import org.junit.*;

import main.Pikachu;
import static org.junit.Assert.*;

public class TestPikachu
{	
	private static final double EPSILON = 1e-15;
	private double distance;
	
	@Test public void testConstructor() {
		Pikachu pikachu = new Pikachu();
		assertEquals("obstructedDuratiob must be 0", 0, pikachu.getObstructedDuration());
	}
	
	@Test public void testStart() {
		Pikachu pikachu = new Pikachu();
		pikachu.start();
		assertEquals("Pikachu start distance must be 0", 0, pikachu.getDistance(), EPSILON);
		assertEquals("Pikachu speed must be 4", 4, pikachu.getSpeed(), EPSILON);
	}
	
	@Test
	public void testRun() {
		Pikachu pikachu = new Pikachu();
		pikachu.start();
		pikachu.run();
		assertEquals("Pikachu distance must be 4", 4, pikachu.getDistance(), EPSILON);
		pikachu.run();
		assertEquals("Pikachu distance must be 8", 8, pikachu.getDistance(), EPSILON);
		
	}
}
