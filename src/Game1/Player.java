package Game1;

import OverallGame.Window;
import OverallGame.gameObject;

/**
 * Player is the object that the user controls in Game1.
 * 
 * @author Team 7
 * @version 5/17
 */

public class Player extends gameObject
{
    // instance variables - replace the example below with your own
    private boolean ChangeDestination = false;
    private int xd;
    private int yd;
    private double velocity; // pixels per tick
    private double Angle;

    /**
     * Constructor for Player objects
     * 
     * @param name name of the object
	 * @param x x-position of the object
	 * @param y y-position of the object
	 * @param velx x velocity of the object
	 * @param vely y velocity of the object
	 */
    public Player(String name, int x, int y, int velx, int vely)
    {
        // initialize instance variables
        super(name, x, y, 0, 0);
        velocity=Math.sqrt(velx*velx+vely*vely);
        Angle=0.0;
    }

    /**
     * Sets the destination for the player to move to
     * 
     * @param xn the x-position of the destination
     * @param yn the y-position of the destination
     */
    public void SetDest(int xn,int yn)
    {
        double StepsNeeded;
        xd=xn;
        yd=yn;
        setVelx(xd-x);
        setVely(yd-y);
        StepsNeeded=Math.sqrt((getVelx()*getVelx()+getVely()*getVely()))/(velocity*Window.SCALE);
        if(StepsNeeded<0.5)
        {
            setVelx(0);
            setVely(0);
            return;
        }
        setVelx((int)(getVelx()/StepsNeeded));
        setVely((int)(getVely()/StepsNeeded));
        Angle=Math.atan2(getVely(),getVelx());
    }

    /**
     * Moves the player to the destination set by SetDest
     */
    public void Move()
    {
    	double dnow;

        if((Math.abs(getVelx())==0.0)&&(Math.abs(getVely())==0.0))return;
        dnow=Math.abs(x-xd)+Math.abs(y-yd);
        if((Math.abs(x+getVelx()-xd)+Math.abs(y+getVely()-yd))>dnow)
        {
            setVelx(0);
            setVely(0);
        }
        else
        {
        	x+=getVelx();
            y+=getVely();
        }
        return;
    }

    public boolean getChangeDestination() {
    	return ChangeDestination;
    }

    public void setChangeDestination(boolean value) {
    	ChangeDestination = value;
    }

    public int getxd() {
    	return xd;
    }

    public void setxd(int value) {
    	xd = value;
    }

    public int getyd() {
    	return yd;
    }

    public void setyd(int value) {
    	yd = value;
    }
    public double getAngle(){return Angle;}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
    
    
}
