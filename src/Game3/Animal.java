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
     * Constructor for Animal objects
     * 
     * @param name name of the object
	 * @param x x-position of the object
	 * @param y y-position of the object
	 * @param velx x velocity of the object
	 * @param vely y velocity of the object
	 * @param dir direction of the object's movement
	 */
	public Animal(String name, int x, int y, int velx, int vely, Direction dir) {
		super(name, x, y, velx, vely);
		this.dir = dir;
		this.onScreen = true;
	}
	
	public Direction getDir() {
		return dir;
	}
	
	public void setDir(Direction d) {
		dir = d;
	}
	
	public boolean getOnScreen() {
		return onScreen;
	}
	
	public void setOnScreen(boolean value) {
		onScreen = value;
	}
	
}