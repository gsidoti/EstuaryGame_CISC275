package Game2;

import static org.junit.Assert.*;
import org.junit.Test;
import OverallGame.Window;

public class Game2Test {
	@Test
	public void testGame2() {
		Window.SCALE = 1;
		Game2 game = new Game2();
		assertEquals(3, game.getLives());
		assertEquals("Boat 36", game.getObjects().get(36).name);
		Boat temp = new Boat("test boat", 40, 40, 1, 0, true);
		temp.setActive(true);
		game.getObjects().set(1, temp);
		game.setMX(40);
		game.setMY(41);
		game.updateBoat(1);
		assertFalse(temp.getInfested());
		temp.setX(0);
		temp.setInfested(true);
		game.getObjects().set(1, temp);
		game.setLives(1);
		game.tick();
		assertEquals(1, game.getLives());
		assertEquals(0, game.getCounter());
		for (int i = 0; i < 10; i++) 
			game.tick();
		assertEquals(10, game.getCounter());
	}
	
	@Test
	public void testGetterSetter() {
		Window.SCALE = 1;
		Game2 game = new Game2();
		game.setCounter(10);
		assertEquals(10, game.getCounter());
		game.setMX(5);
		game.setMY(5);
		assertEquals(5, game.getMX());
		assertEquals(5, game.getMY());
		game.setRunning(true);
		assertTrue(game.getRunning());
	}

}
