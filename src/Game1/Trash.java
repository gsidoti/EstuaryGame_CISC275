package Game1;

import OverallGame.gameObject;
import OverallGame.Window;

/**
 * Trash are the objects that move from left to right on the screen, that the player needs to collect before they
 * reach the right side.
 * 
 * @author Team 7
 * @version 5/17
 */

public class Trash extends gameObject
{
	boolean isActive = false;

	/**
     * Constructor for Trash objects
     * 
     * @param name name of the object
	 * @param x x-position of the object
	 * @param y y-position of the object
	 * @param velx x velocity of the object
	 * @param vely y velocity of the object
	 */
    public Trash(String name,int x, int y, int velx, int vely)
    {
    	super(name,0,y,velx,0);
        // initialize instance variables
    }

    /**
     * Checks to see if a Trash object has made it to a given x-position
     * 
     * @param to the x-position being checked for whether the trash made it
     * @return Returns true if the trash made it, false otherwise
     */
    public boolean MadeIt(int to)
    {
        if(x>=to)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Checks to see if a Trash object has been caught by the player
     * 
     * @param px Player's x-position
     * @param py Player's y-position
     * @return Returns true if the trash is caught, false otherwise
     */
    public boolean IsCaught(int px,int py)
    {
        if((Math.abs(px-x)+Math.abs(py-y))<(int)(35*Window.SCALE))return true;
        return false;
    }

    /**
     * Moves the trash object from the left side to the right side of the screen
     */
    public void Move()
    {
        x+=(int)(Math.ceil(velx*Window.SCALE));
        return;
    }

    public boolean getActive() {
    	return isActive;
    }

    public void setActive(boolean value) {
    	isActive = value;
    }
}
