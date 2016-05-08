package Game2;

import static org.junit.Assert.*;

import org.junit.Test;

import OverallGame.Controller;
import OverallGame.Window;

public class Game2Test {
// Need to figure out how to create an instance of the game
// without it actually running the game or make the game close
// and print out its values or something
	@Test
	public void testGame2() {
		Window.SCALE = 1;
		Game2 game = new Game2();
		assertEquals(10, game.getLives());
		assertEquals(1, game.getMaxVel());
		assertEquals("Boat 36", game.getObjects().get(36).name);
		Boat temp = new Boat("test boat", 40, 40, 1, 0, true);
		temp.setActive(true);
		game.getObjects().set(1, temp);
		game.setMX(40);
		game.setMY(41);
		game.updateBoat(1);
		System.out.println(temp);
		assertFalse(temp.getInfested());
		temp.setX(0);
		temp.setInfested(true);
		game.getObjects().set(1, temp);
		game.tick();
		assertEquals(9, game.getLives());
		assertEquals(1, game.getCounter());
		for (int i = 0; i < 9; i++) 
			game.tick();
		assertEquals(10, game.getCounter());
		
	}

}
