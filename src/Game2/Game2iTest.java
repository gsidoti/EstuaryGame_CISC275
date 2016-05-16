package Game2;

import static org.junit.Assert.*;

import org.junit.Test;

import OverallGame.Window;

public class Game2iTest {

	@Test
	public void testGame2i() {
		Window.SCALE = 1;
		Game2i test = new Game2i();
		assertFalse(test.running);
		test.stopMouseListener();
		assertFalse(test.mlActive);
	}

}
