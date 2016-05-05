package Game3;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalTest {

	@Test
	public void testAnimal() {
		Animal a = new Animal("Horseshoe Crab", 20, 20, 1, -1, Direction.SE);
		assertEquals(Direction.SE, a.getDir());
		assertEquals(true, a.getOnScreen());
		a.setDir(Direction.N);
		a.setOnScreen(false);
		assertEquals(Direction.N, a.getDir());
		assertEquals(false, a.getOnScreen());
		
	}

}
