package Game1;

import OverallGame.gameObject;

/**
 * Beached is the object that represents trash on the beach in Game1
 * 
 * @author Team 7
 * @version 5/17
 */

public class Beached extends gameObject{
	
	/**
	 * Constructor for Beached objects
	 * 
	 * @param name name of the object
	 * @param x x-position of the object
	 * @param y y-position of the object
	 * @param velx x velocity of the object
	 * @param vely y velocity of the object
	 */
	public Beached(String name,int x, int y, int velx, int vely)
    {
    	super(name,x,y,0,0);
        // initialize instance variables
    }
}
