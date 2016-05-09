package Game4;

import static org.junit.Assert.*;

import org.junit.Test;

public class G4PlayerTest {

	@Test
	public void test() {
		G4Player p = new G4Player("test", 20, 20, 1, 1);
		p.moveDown();
		assertEquals(21, p.getY());
		p.moveUp();
		p.moveUp();
		assertEquals(19, p.getY());
	}

}
