package Game2;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoatTest {

	@Test
	public void testBoat() {
		Boat boat = new Boat("test boat", 2, 2, 1, 1, true);
		int testX = 2;
		int testY = 2;
		assertTrue(boat.IsCaught(testX, testY));
		testX = 20;
		testY = 20;
		assertFalse(boat.IsCaught(testX, testY));
		boat.Move();
		assertEquals(1, boat.getX());
		assertEquals(2, boat.getY());
		assertTrue(boat.getInfested());
		assertFalse(boat.getActive());
		boat.setActive(true);
		boat.setInfested(false);
		assertFalse(boat.getInfested());
		assertTrue(boat.getActive());
		assertFalse(boat.MadeIt(0));
		boat.Move();
		assertTrue(boat.MadeIt(0));
	}

}
