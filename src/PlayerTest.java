package Game1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void test() {
		Player p = new Player("test", 20, 20, 1, 1);
		assertEquals(Math.sqrt(2.0), p.getVelocity(), .01);
		assertEquals(0.0, p.getAngle(), .01);
		p.SetDest(40, 40);
		assertEquals(40, p.getxd());
		assertEquals(40, p.getyd());
		assertEquals((int)((20/(Math.sqrt(800.0)/p.getVelocity()))), p.getVelx());
		assertEquals((int)((20/(Math.sqrt(800.0)/p.getVelocity()))), p.getVely());
		p.SetDest(20, 20);
		assertEquals(20, p.getxd());
		assertEquals(20, p.getyd());
		assertEquals(0, p.getVelx());
		assertEquals(0, p.getVely());
		p.Move();
		p.setVelx(1);
		p.setVely(1);
		p.Move();
		assertEquals(0, p.getVelx());
		assertEquals(0, p.getVely());
		p.setxd(40);
		p.setyd(40);
		p.setVelx(1);
		p.setVely(1);
		p.Move();
		assertEquals(21, p.getX());
		assertEquals(21, p.getY());
		p.setChangeDestination(true);
		assertTrue(p.getChangeDestination());
		p.setVelocity(1.0);
		assertEquals(1.0, p.getVelocity(), .01);
	}

}
