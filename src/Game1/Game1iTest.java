package Game1;

import static org.junit.Assert.*;

import org.junit.Test;

import OverallGame.Window;

public class Game1iTest {

	@Test
	public void testGame1i() {
		Window.SCALE = 1;
		Game1i test = new Game1i();
		assertFalse(test.running);
		test.stopMouseListener();
		assertFalse(test.mlActive);
		
	}

}
