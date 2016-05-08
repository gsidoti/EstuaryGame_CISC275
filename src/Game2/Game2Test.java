package Game2;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.event.MouseEvent;

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
		assertFalse(temp.getInfested());
		temp.setX(0);
		temp.setInfested(true);
		game.getObjects().set(1, temp);
		game.setLives(1);
		game.tick();
		assertEquals(10, game.getLives());
		assertEquals(0, game.getCounter());
		for (int i = 0; i < 10; i++) 
			game.tick();
		assertEquals(10, game.getCounter());
	}
	
	@Test
	public void testGetterSetter() {
		Window.SCALE = 1;
		Game2 game = new Game2();
		game.setMaxVel(5);
		assertEquals(5, game.getMaxVel());
		game.setCounter(10);
		assertEquals(10, game.getCounter());
		game.setLastBoat(20);
		assertEquals(20, game.getLastBoat());
		game.setMX(5);
		game.setMY(5);
		assertEquals(5, game.getMX());
		assertEquals(5, game.getMY());
		game.setRunning(true);
		game.setMousedown(false);
		assertTrue(game.getRunning());
		assertFalse(game.getMousedown());
	}
	/*
	@Test
	public  void testMouse() {
		Window.SCALE = 1;
		Game2 game = new Game2();
		MouseEvent e = new MouseEvent(null, 1, 1, 1, 1, 1, 1, false);
		game.mousePressed(e);
		assertEquals(1, game.getMX());
		assertEquals(1, game.getMY());
		assertTrue(game.getMousedown());
		game.mouseReleased(e);
		assertFalse(game.getMousedown());
	}
	*/

}
