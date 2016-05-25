package Menu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MenuTest {

	@Test
	public void test() {
		Menu menu = new Menu();
		assertEquals(0, Menu.SCORE);
		Menu.SCORE += 100;
		assertEquals(0, Menu.SCORE);
		for(int i = 0;i<menu.ftTemp;i++)
			menu.fallingTrash();
		assertEquals(100, Menu.SCORE);
	}

}
