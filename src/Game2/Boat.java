package Game2;

import OverallGame.gameObject;

/**
 * Boats are either clean or dirty
 * If a clean boat makes it to the end of the screen, you earn points
 * If a dirty boat makes it to the end of the screen, you lose a life
 * 
 * @author Team 7 
 * @version 5/17
 */

public class Boat extends gameObject
{
    /* 
     * Instance variables - isInfested holds whether the boat object is clean or dirty
     * 					  - isActive holds whether the boat object is active in the game
     */
    private boolean isInfested;
    private boolean isActive = true;
    
	/**
     * Constructor for Boat objects
     * 
     * @param name name of the object
	 * @param x x-position of the object
	 * @param y y-position of the object
	 * @param velx x velocity of the object
	 * @param vely y velocity of the object
	 * @param infested whether the object is dirty or clean
	 */
    public Boat(String name, int x, int y, int velx, int vely, boolean infested) {
		super(name, x, y, velx, vely);
		this.isInfested = infested;
	}

    /**
     * Checks to see if a boat has made it to the given x-position
     * 
     * @param to the x-position being checked
     * @return Returns true if the boat is at the x-position, false otherwise
     */
    public boolean MadeIt(int to)
    {
        if(x<=to)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Checks to see if a boat has been clicked on
     * 
     * @param px the mouse x-position
     * @param py the mouse y-position
     * @return Returns true if the boat was clicked on, false otherwise
     */
    public boolean IsClicked(int px,int py)
    {
        if((Math.abs(px-getX())+Math.abs(py-getY()))<10)return true;
        return false;
    }
    
    public boolean getInfested() {
    	return isInfested;
    }
    
    public void setInfested(boolean value) {
    	isInfested = value;
    }
    
    public boolean getActive() {
    	return isActive;
    }
    
    public void setActive(boolean value) {
    	isActive = value;
    }
    
    /**
     * Moves the boat towards the left side of the screen
     */
    void Move(){
		this.setX(this.getX()-this.getVelx());
	//	System.out.println("left "+ x + " " + velx);
	}
    
    public String toString() {
    	return "Name: " + name + " X " + x + " Y " + y + " velX " + velx + " velY " + vely + " Active " + isActive + " Infested " + isInfested;
    }
}

