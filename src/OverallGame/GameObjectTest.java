package OverallGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameObjectTest {

	@Test
	public void test() {
		gameObject obj = new gameObject("test", 20, 20, 1, 1);
		assertEquals(20, obj.getX());
		assertEquals(20, obj.getY());
		assertEquals(1, obj.getVelx());
		assertEquals(1, obj.getVely());
		obj.setX(40);
		obj.setY(40);
		obj.setVelx(2);
		obj.setVely(2);
		assertEquals(40, obj.getX());
		assertEquals(40, obj.getY());
		assertEquals(2, obj.getVelx());
		assertEquals(2, obj.getVely());
		
	}

}
