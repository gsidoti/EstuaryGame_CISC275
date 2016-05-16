package Game4;

import static org.junit.Assert.*;

import org.junit.Test;

import OverallGame.Window;

public class Game4iTest {

	@Test
	public void testGame4i() {
		Window.SCALE = 1;
		Game4i test = new Game4i();
		assertFalse(test.running);
		test.stopMouseListener();
		assertFalse(test.mlActive);
	}

}
