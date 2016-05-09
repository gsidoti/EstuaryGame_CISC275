package Game1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrashTest {

	@Test
	public void test() {
		Trash t = new Trash("test", 0, 20, 1, 0);
		t.setActive(true);
		assertTrue(t.getActive());
		assertEquals(0, t.getX());
		assertEquals(20, t.getY());
		assertEquals(1, t.getVelx());
		assertEquals(0, t.getVely());
		t.Move();
		assertEquals(1, t.getX());
		t.setX(20);
		assertTrue(t.IsCaught(20, 20));
		assertFalse(t.IsCaught(40, 40));
		t.setX(100);
		assertTrue(t.MadeIt(100));
		assertFalse(t.MadeIt(200));
		
	}

}
