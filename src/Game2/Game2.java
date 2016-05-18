package Game2;

import java.util.*;

import Game2.Boat;
import Game2.Game2View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

/**
 * Game2 is a game where the goal is to clean the shipping boats before they reach the docks,
 * as dirty boats reaching port will bring along invasive species that will upset the natural balance
 * of the surrounding estuary
 * 
 * @author Team 7
 * @version 5/17
 */
public class Game2 extends MouseAdapter {

	/* 
	 * Instance variables - speed holds the X-velocity the boats will be created with
	 * 					  - boatspeed holds the rate of boats being spawned in over time
	 * 					  - counter holds the tick counter
	 * 					  - mx/my hold the mouse-x/mouse-y position when a click occurs
	 * 					  - running is used to check whether the game is currently running or not
	 * 					  - docks are **
	 * 					  - mousedown is used to check whether the mouse button is down or not
	 * 					  - Lives holds the amount of lives the player has left, 0 means game over
	 */
    private int speed = 1;
    private int boatspeed = 200;
    private boolean spawnBoats = true;
    private int counter = 0;
    private long endTime;
    private int mx, my;
	public boolean running = false;
	public int[] docks = new int[6];
	public static int boatsLeft = 36;
	
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game2View view;
	Random rand = new Random();
	boolean mousedown = false;//dont need
    private int Lives = 10;
   
    /**
     * 
     */
    public Game2() {
        view = new Game2View();
    }
    
    /**
     * 
     */
	public void mousePressed(MouseEvent e){
		mousedown = true;//dont need
		mx = e.getX();
		my = e.getY();
		System.out.println("X: "+mx+" Y: "+my);
		if(mouseOver(mx,my,scaleW(5),scaleH(5),scaleW(80),scaleH(44)))
			resetGame();
	}

	/**
	 * 
	 */
	public void mouseReleased(MouseEvent e){//dont need
		mousedown = false;
	}
	
	/**
	 * 
	 * @param index
	 */
	void updateBoat(int index) {
		Boat b = (Boat)objects.get(index);
		if (b.getActive())
			b.Move();
		if (mouseOver(mx,my,scaleW(b.getX()-5),scaleH(b.getY()-5),scaleW(130),scaleH(65))&&b.getActive()) {
				 b.setInfested(false);
		}
	}
	
	/*
	 * Iterates through the array of GameObjects, pulling each boat.
	 * If the boat made it to the left side of the screen and is active, print y velocity and set isActive to false.
	 * If the boat is also infested, subtract 1 from Lives.
	 * If lives is 0, reset the game.
	 * If the boat didn't make it but is active, checks to see if mouse was clicked over boat position, if so set isInfested
	 * to false, then calls the move method.
	 */
	/**
	 * 
	 */
	void updateBoats(){
		Boat b;
		for (int i = 0; i < objects.size(); i++) {
			b = (Boat) objects.get(i);
			if (b.MadeIt(scaleW(90+(b.getVely()*30)))&&b.getActive()) {
				System.out.println(b.getVely());
				b.setActive(false);
				if (b.getInfested()) {
					Lives--;
					if (Lives <= 0) {
						resetGame();
					}
				}
			}else if(b.getActive()){
				if (mouseOver(mx,my,scaleW(b.getX()-5),scaleH(b.getY()-5),scaleW(130),scaleH(65)))
					 b.setInfested(false);
				b.Move();
			}
		}
	}
	
	/* Takes a random number (0-6) and assigns r to it and y to 0.
	 * if there are less than 35 objects in the array of GameObjects, r equals another random integer (0-6) and, depending 
	 * of the fullness of each dock, assigns the y value of the new boat to line up with the specified dock.
	 * Makes the new boat with all of the variables and adds it to the array of GameObjects.
	 * If objects is equal to 35, call the resetGame method
	 */
	/**
	 * 
	 */
	public void addBoat(){
		int r = rand.nextInt(6),y = 0;
		if(boatsLeft >= 0){
			do {
				r = rand.nextInt(6);
				//System.out.println("R: "+r);
			}while(docks[r]>5);
			switch(r){
			case 0:
				y = 55;
				docks[0]++;
				break;
			case 1:
				y = 170;
				docks[1]++;
				break;
			case 2:
				y = 253;
				docks[2]++;
				break;
			case 3:
				y = 367;
				docks[3]++;
				break;
			case 4:
				y = 453;
				docks[4]++;
				break;
			case 5:
				y = 600;
				docks[5]++;
				break;
			}
			boolean bool = rand.nextBoolean();
			if(bool == false){
				bool = rand.nextBoolean();
			}	
			Boat b = new Boat("Boat",Window.WIDTH,y,speed,docks[r]-1,bool);
			objects.add(b);
			boatsLeft--;
			//System.out.println(boatcount++);
		}
		if(boatsLeft == 0){
			if(spawnBoats == true){
				spawnBoats = false;
				endTime = System.currentTimeMillis();
			}
			if(endTime<System.currentTimeMillis()+5000){
				Menu.Menu.SCORE += 100;
				resetGame();
			}
		}
	}

	/**
	 * 
	 */
	public void tick() {
		counter++;
		if (counter%boatspeed == 0) {
			addBoat();
		}
		if(counter%1000 == 0){
			speed++;
		}
		if(counter%50 == 0){
			boatspeed--;
			mx = 0;
			my = 0;
		}
			updateBoats();
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}
	
	/**
	 * 
	 * @param mx
	 * @param my
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
    boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
    
    /**
     * 
     */
    void resetGame() {
    	boatsLeft=36;
    	spawnBoats =true;
    	Lives = 3;
    	counter = 0;
        speed = 1;
        boatspeed = 200;
    	objects.clear();
    	Arrays.fill(docks, 0);
    	running = false;
    	Controller.gameState = STATE.Menu;
    }
    
    /**
     * 
     * @param x
     * @return
     */
	public int scaleW(double x){
		return (int)(Window.SCALE*x);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	public int scaleH(double x){
		return (int)(Window.SCALE*x);
	}
    
	/**
	 * 
	 * @return
	 */
    public int getLives() {
    	return Lives;
    }
    
    /**
     * 
     * @param num
     */
    public void setLives(int num) {
    	Lives = num;
    }
    /**
     * 
     * @return
     */
    public int getCounter() {
    	return counter;
    }
    
    /**
     * 
     * @param num
     */
    public void setCounter(int num) {
    	counter = num;
    }
 
    /**
     * 
     * @return
     */
    public int getMX() {
    	return mx;
    }
    
    /**
     * 
     * @param num
     */
    public void setMX(int num) {
    	mx = num;
    }
    
    /**
     * 
     * @return
     */
    public int getMY() {
    	return my;
    }
    
    /**
     * 
     * @param num
     */
    public void setMY(int num) {
    	my = num;
    }
    
    /**
     * 
     * @return
     */
    public boolean getRunning() {
    	return running;
    }
    
    /**
     * 
     * @param value
     */
    public void setRunning(boolean value) {
    	running = value;
    }
    
    /**
     * 
     * @return
     */
    public boolean getMousedown() {
    	return mousedown;
    }
    
    /**
     * 
     * @param value
     */
    public void setMousedown(boolean value) {
    	mousedown = value;
    }
}
