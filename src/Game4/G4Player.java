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
     * Constructor for G4Player objects
     * 
     * @param name name of the object
	 * @param x x-position of the object
	 * @param y y-position of the object
	 * @param velx x velocity of the object
	 * @param vely y velocity of the object
	 */
	public G4Player(String name, int x, int y, int velx, int vely) {
		super(name, x, y, velx, vely);
	}
	
	/**
	 * Moves the player down
	 */
	void moveDown(){
		y += vely;
	}
	
	/**
	 * Moves the player up
	 */
	void moveUp(){
		y -= vely;
	}
}