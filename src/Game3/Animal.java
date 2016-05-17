package Game3;

/**
 * Animal is the objects that are moving around the screen in Game3. Every creature in Game3 is an Animal, but are 
 * represented differently depending on what Animal is created
 * 
 * @author Team 7
 * @version 5/17
 */

import OverallGame.gameObject;

public class Animal extends gameObject{

	Direction dir;
	boolean onScreen;
	
	/**
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @param velx
	 * @param vely
	 * @param dir
	 */
	public Animal(String name, int x, int y, int velx, int vely, Direction dir) {
		super(name, x, y, velx, vely);
		this.dir = dir;
		this.onScreen = true;
	}
	
	/**
	 * 
	 * @return
	 */
	public Direction getDir() {
		return dir;
	}
	
	/**
	 * 
	 * @param d
	 */
	public void setDir(Direction d) {
		dir = d;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getOnScreen() {
		return onScreen;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setOnScreen(boolean value) {
		onScreen = value;
	}
	
}