package Game2;

import java.util.*;

import Game2.Boat;
import Game2.Game2View;
import java.awt.event.MouseEvent;
import OverallGame.Controller;
import OverallGame.MiniGame;
import OverallGame.STATE;
import OverallGame.Window;

/**
 * Game2 is a game where the goal is to clean the shipping boats before they reach the docks,
 * as dirty boats reaching port will bring along invasive species that will upset the natural balance
 * of the surrounding estuary
 * 
 * @author Team 7
 * @version 5/17
 */
public class Game2 extends MiniGame {

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
    private int speed = 3;
    private int madeIt = 0;
    private boolean spawnBoats = true;
    private int counter = 0;
    static boolean inst = true;
    private int mx, my;
	int[] docks = new int[6];
	static int boatsLeft = 36;
	
	public Game2View view;
	Random rand = new Random();
    private int Lives = 3;
   
    /**
     * Constructor for Game2 objects
     */
    public Game2() {
        view = new Game2View();
    }
    
    /**
     * When the mouse button is pressed, sets mousedown to true and sets mx/my to the mouse's x and y position.
     * If the mouse was over the quit button when pressed, reset the game.
     */
	public void mousePressed(MouseEvent e){
		mx = e.getX();
		my = e.getY();
		if(inst && mouseOver(mx,my,scaleW(570),scaleH(520),scaleW(111),scaleH(52)))
			inst = false;
		if(mouseOver(mx,my,scaleW(5),scaleH(5),scaleW(80),scaleH(44)))
			resetGame();
		for (int i = 0; i < objects.size(); i++) {
			Boat b = (Boat) objects.get(i);
			if (mouseOver(mx,my,scaleW(b.getX()-5),scaleH(b.getY()-5),scaleW(130),scaleH(65))&&b.getActive()) {
				b.setInfested(false);
			}
		}	
	}
	
	/**
	 * Updates a boat from the ArrayList of gameObjects.
	 * If boat is active, call move method.
	 * If boat is clicked on, set isInfested to false
	 * 
	 * @param index the index of the object in the ArrayList
	 */
	void updateBoat(int index) {
		Boat b = (Boat)objects.get(index);
		if (b.getActive())
			b.Move();
		if (mouseOver(mx,my,scaleW(b.getX()-5),scaleH(b.getY()-5),scaleW(130),scaleH(65))&&b.getActive()) {
				 b.setInfested(false);
		}
	}
	
	/**
	 * Iterates through the array of GameObjects, pulling each boat.
	 * If the boat made it to the left side of the screen and is active, print y velocity and set isActive to false.
	 * If the boat is also infested, subtract 1 from Lives.
	 * If lives is 0, reset the game.
	 * If the boat didn't make it but is active, checks to see if mouse was clicked over boat position, if so set isInfested
	 * to false, then calls the move method.
	 */
	void updateBoats(){
		Boat b;
		for (int i = 0; i < objects.size(); i++) {
			b = (Boat) objects.get(i);
			if (b.MadeIt(scaleW(90+(b.getVely()*30)))&&b.getActive()) {
				System.out.println("VEl: "+ b.getVely());
				b.setActive(false);
				madeIt++;
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
	
	/**
	 * Takes a random number (0-6) and assigns r to it and y to 0.
	 * if there are less than 35 objects in the array of GameObjects, r equals another random integer (0-6) and, depending 
	 * of the fullness of each dock, assigns the y value of the new boat to line up with the specified dock.
	 * Makes the new boat with all of the variables and adds it to the array of GameObjects.
	 * If objects is equal to 35, call the resetGame method
	 */
	public void addBoat(){
		int r,y = 0;
		if(boatsLeft > 0){
			do {
				r = rand.nextInt(6);
				System.out.println("R: "+r);
			}while(docks[r]>7);
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
			int odds = rand.nextInt(7);
			boolean bool = true;
			if(odds == 0){
				bool = false;
			}	
			Boat b = new Boat("Boat",Window.WIDTH,y,rand.nextInt(speed)+2,docks[r]-1,bool);
			objects.add(b);
			boatsLeft--;
		}
		System.out.println(madeIt);
		if(boatsLeft <= 0){
			if(spawnBoats == true){
				spawnBoats = false;
			}else if(madeIt == 36){
				Menu.Menu.SCORE += 100;
				resetGame();
			}
		}
	}

	/**
	 * Handles the methods called every tick of the game.
	 * Increments the counter and adds a new boat, increases the speed, or decreases the boatspeed and sets mx/my to 0,
	 * depending on the value of the counter.
	 */
	public void tick() {
		if(!inst){
			counter++;
			if (counter%40 == 0) {
				mx = 0;
				my = 0;
				if(rand.nextBoolean())
					addBoat();
			}
			if(counter%1000 == 0){
				speed++;
			}
			updateBoats();
		}
	}
    
	/**
	 * Resets Game2 by setting game values back to starting values, clearing the ArrayList, and setting gameState back to Menu.
	 */
    void resetGame() {
    	boatsLeft=36;
    	spawnBoats =true;
    	inst = true;
    	Lives = 3;
    	counter = 0;
        speed = 1;
        madeIt= 0;
    	objects.clear();
    	Arrays.fill(docks, 0);
    	running = false;
    	Controller.gameState = STATE.Menu;
    }
    

    public int getLives() {
    	return Lives;
    }
    
    public void setLives(int num) {
    	Lives = num;
    }

    public int getCounter() {
    	return counter;
    }
    
    public void setCounter(int num) {
    	counter = num;
    }
 
    public int getMX() {
    	return mx;
    }
    
    public void setMX(int num) {
    	mx = num;
    }
    
    public int getMY() {
    	return my;
    }
    
    public void setMY(int num) {
    	my = num;
    }
    
    public boolean getRunning() {
    	return running;
    }
    
    public void setRunning(boolean value) {
    	running = value;
    }

	int getSpeed() {
		return speed;
	}

	void setSpeed(int speed) {
		this.speed = speed;
	}

	int getMadeIt() {
		return madeIt;
	}

	void setMadeIt(int madeIt) {
		this.madeIt = madeIt;
	}

	boolean isSpawnBoats() {
		return spawnBoats;
	}

	void setSpawnBoats(boolean spawnBoats) {
		this.spawnBoats = spawnBoats;
	}

	static boolean isInst() {
		return inst;
	}

	static void setInst(boolean inst) {
		Game2.inst = inst;
	}

	int getMx() {
		return mx;
	}

	void setMx(int mx) {
		this.mx = mx;
	}

	int getMy() {
		return my;
	}

	void setMy(int my) {
		this.my = my;
	}

	int[] getDocks() {
		return docks;
	}

	void setDocks(int[] docks) {
		this.docks = docks;
	}

	static int getBoatsLeft() {
		return boatsLeft;
	}

	static void setBoatsLeft(int boatsLeft) {
		Game2.boatsLeft = boatsLeft;
	}

	Game2View getView() {
		return view;
	}

	void setView(Game2View view) {
		this.view = view;
	}

	Random getRand() {
		return rand;
	}

	void setRand(Random rand) {
		this.rand = rand;
	}
}
