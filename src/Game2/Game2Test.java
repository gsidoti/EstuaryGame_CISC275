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
		Window window = new Window("Test Window", new Controller());
		Game2 game = new Game2();
		assertEquals(10, game.getLives());
		assertEquals(1, game.getMaxVel());
		assertEquals("Boat 36", game.getObjects().get(36).name);
		assertEquals(new Game2View(), game.view);
	}

}
