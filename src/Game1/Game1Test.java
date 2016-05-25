package Game1;

import static org.junit.Assert.*;

import org.junit.Test;

import OverallGame.Window;

public class Game1Test {

	@Test
	public void test() {
		Game1 game = new Game1();
		Window.SCALE = 1;
		assertFalse(game.isRunning());
		assertEquals(0, game.getCounter());
		assertEquals(1, game.getLastTrash());
		assertTrue(game.isSkipTick());
		assertEquals(10, game.getLives());
		assertEquals(2, game.getMaxvel());
		assertEquals(10, game.getMaxtrash());
		assertEquals(0, game.getTrashcount());
		assertEquals(0, game.getScore());
		assertEquals(0, game.getHiScore());
		game.updatePlayer();
		Trash temp = new Trash("Trash", 20, 20, 1, 1);
		temp.setActive(true);
		game.getObjects().add(temp);
		game.setTrashcount(1);
		Player p = (Player)game.getObjects().get(0);
		p.setX(19);
		p.setY(20);
		game.updateTrash(2);
		assertEquals(1, game.getScore());
		assertEquals(1, game.getHiScore());
		temp = (Trash)game.getObjects().get(2);
		assertFalse(temp.getActive());
		assertEquals(0, game.getTrashcount());
		temp.setActive(true);
		game.setTrashcount(1);
		temp.setX(Window.WIDTH);
		game.getObjects().set(2, temp);
		game.updateLives(2);
		temp = (Trash)game.getObjects().get(2);
		assertFalse(temp.getActive());
		assertNotNull(game.getObjects().get(3));
		assertEquals(9, game.getLives());
		assertEquals(0, game.getTrashcount());
		game.tick();
		game.setCounter(9);
		game.tick();
		assertTrue(game.isSkipTick());
		assertEquals(0, game.getCounter());
		game.setLives(1);
		temp = new Trash("Trash", Window.WIDTH, 20, 1, 1);
		temp.setX(Window.WIDTH);
		temp.setActive(true);
		game.getObjects().set(3,temp);
		game.updateLives(3);
		System.out.println(game.getLives());
		assertEquals(2, game.getMaxvel());
		assertEquals(10, game.getMaxtrash());
		assertEquals(0, game.getTrashcount());
		assertEquals(0, game.getScore());
		assertEquals(10, game.getLives());
		assertEquals(0, game.getCounter());
		assertFalse(game.isRunning());
		assertEquals(2, game.getObjects().size());
		game.setRunning(false);
		assertFalse(game.isRunning());
		game.setMx(20);
		game.setMy(20);
		assertEquals(20, game.getMx());
		assertEquals(20, game.getMy());
		game.setLastTrash(1);
		game.setMaxtrash(20);
		game.setMaxvel(20);
		assertEquals(1, game.getLastTrash());
		assertEquals(20, game.getMaxtrash());
		assertEquals(20, game.getMaxvel());
		game.setScore(100);
		game.setHiScore(100);
		game.setSkipTick(true);
		game.setObjects(null);
		assertEquals(100, game.getScore());
		assertEquals(100, game.getHiScore());
		assertTrue(game.isSkipTick());
		assertNull(game.getObjects());
	}

}
