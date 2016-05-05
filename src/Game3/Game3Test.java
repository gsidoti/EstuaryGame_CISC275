package Game3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Game3Test {

	@Test
	public void test() {
		Game3 game = new Game3();
		game.getObjects().add(new Animal("HorseShoe", 0, 0, 1, -1, Direction.SE));
		assertEquals(0, game.getObjects().get(0).getX());
		assertEquals(0, game.getObjects().get(0).getY());
		assertEquals(1, game.getObjects().get(0).getVelx());
		assertEquals(-1, game.getObjects().get(0).getVely());
		game.updateAnimal();
		assertEquals(1, game.getObjects().get(0).getX());
		assertEquals(-1, game.getObjects().get(0).getY());
		assertEquals(1, game.getObjects().get(0).getVelx());
		assertEquals(-1, game.getObjects().get(0).getVely());
		assertEquals(1, game.getActNumCrab());
		game.spawnLeft(false, 1);
		assertEquals(0, game.getObjects().get(1).getX());
		assertEquals(1, game.getObjects().get(1).getVelx());
		
	}

}
