package Game4;

import static org.junit.Assert.*;

import org.junit.Test;

import OverallGame.Controller;
import OverallGame.Window;

public class Game4Test {

	@Test
	public void test() {
		Window.SCALE = 1;
		Game4 game = new Game4();
		assertEquals(1500, game.getGreenScore());
		assertEquals(1500, game.getRedScore());
		assertFalse(game.isMousedown());
		int py = game.getObjects().get(0).getY();
		game.updatePlayer();
		assertEquals(py+5, game.getObjects().get(0).getY());
		game.setMousedown(true);
		game.updatePlayer();
		game.updatePlayer();
		assertEquals(py-5, game.getObjects().get(0).getY());
		game.getObjects().get(0).setY(Window.HEIGHT/2);
		game.updateScore();
		assertEquals(1499, game.getGreenScore());
		game.setGreenScore(1);
		game.updateScore();
		assertEquals(1500, game.getGreenScore());
		assertEquals(1500, game.getRedScore());
		assertFalse(game.isRunning());
		game.getObjects().get(0).setY(Window.HEIGHT/2-75);
		game.setRunning(true);
		game.updateScore();
		assertEquals(1499, game.getRedScore());
		game.setRedScore(1);
		game.updateScore();
		assertEquals(1500, game.getGreenScore());
		assertEquals(1500, game.getRedScore());
		assertFalse(game.isRunning());
		game.tick();
		
		
	}

}
