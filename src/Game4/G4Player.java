package Game4;

import OverallGame.gameObject;

/**
 * G4Player is the object that the user controls while playing Game4.
 * G4Player moves down when the mouse button is clicked and held, and up when the user is not pressing the mouse button
 * 
 * @author Team 7
 * @version 5/17
 */

public class G4Player extends gameObject{
	
	int vyUp;
	int vyDown;
	boolean mousedown;
	
	/**
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @param velx
	 * @param vely
	 */
	public G4Player(String name, int x, int y, int velx, int vely) {
		super(name, x, y, velx, vely);
	}
	
	/**
	 * 
	 */
	void moveDown(){
		y += vely;
	}
	
	/**
	 * 
	 */
	void moveUp(){
		y -= vely;
	}
}