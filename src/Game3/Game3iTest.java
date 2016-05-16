package Game3;

import static org.junit.Assert.*;

import org.junit.Test;

import OverallGame.Window;

public class Game3iTest {

	@Test
	public void testGame3i() {
		Window.SCALE = 1;
		Game3i test = new Game3i();
		assertFalse(test.running);
		test.stopMouseListener();
		assertFalse(test.mlActive);
	}

}
