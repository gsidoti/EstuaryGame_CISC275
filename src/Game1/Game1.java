package Game1;

import java.util.*;
import Game1.Player;
import Game1.Trash;
import Menu.Menu;
import OverallGame.gameObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;

/**
 * Game1 has a player-controlled boat and trash moving across the screen.
 * The goal is to move the boat by clicking where you want to go, and collecting the trash
 * before it reaches the beach.
 *
 * @author Team 7
 * @version 5/17
 */

public class Game1 extends MouseAdapter {
	boolean mlActive;
	
    //private FrameRate frameRate;
    //private BufferStrategy bs;
    public boolean running = false;
    static boolean inst = true;
    public boolean mousedown = false;
    int mx, my;
    int counter = 0;
    int lastTrash = 1;
    //private Thread gameThread;
    //private SimpleMouseInput mouse;d
    // KeyboardInput keyboard;
    //private Player player;
    //private Trash[] trash = new Trash[100];
    //private boolean[] trashactive=new boolean[100];
    private int maxtrash;
    private int trashcount;
    private int maxvel;
    public Game1View view;

    private long Score;
    private long HiScore;
    private long Lives;

    private boolean SkipTick=true;

	ArrayList<gameObject> objects = new ArrayList<gameObject>();

	/**
	 * Constructor for Game1 objects 
	 * Sets game variables to starting values
	 */
    public Game1() {
        Lives=10;
        maxvel=2;
        maxtrash=10;
        trashcount=0;
        Score=0;
        HiScore=0;
		objects.add( new Player("Player",(int)((Window.WIDTH/2)*Window.SCALE),(int)((Window.HEIGHT/2)*Window.SCALE),20,0));
    	objects.add( new Scoreboard("Score",10,10,0,0));
    	Scoreboard sb=(Scoreboard)objects.get(1);
    	sb.setScore((int)Score);
    	sb.setLives((int)Lives);
        view = new Game1View();
    }

    /**
     * When mouse is pressed, assigns mousedown to true, acquires the mouse position on screen and check if the 
     * exit button was pressed.
     */
	public void mousePressed(MouseEvent e){
		mousedown = true;
		mx = e.getX();
		my = e.getY();
		if(inst && mouseOver(mx,my,scaleW(570),scaleH(520),scaleW(111),scaleH(52)))
			inst = false;
		else{
			Player p = (Player) (objects.get(0));
			if(mx<Window.WIDTH*Window.SCALE*0.95)p.SetDest(mx, my);
			if(mouseOver(mx,my,scaleW(Window.WIDTH-85),scaleH(5),scaleW(80),scaleH(44)))
				resetGame();
		}

	}
	

	/**
	 * When mouse button is released, sets mousedown to false
	 */
	public void mouseReleased(MouseEvent e){
		mousedown = false;
	}

	/**
	 * Updates player object by calling it's move() method
	 */
	void updatePlayer(){
		Player p = (Player) (objects.get(0));
		p.Move();
	}

	/**
	 * Updates trash object by pulling it from the ArrayList of gameObjects and making sure it is a trash object.
	 * If it is active, calls it's move method and updates score and maxtrash/trashcount accordingly if the object
	 * was caught by the player.
	 * 
	 * @param index Index of Trash object in arrayList of gameObjects
	 */
	void updateTrash(int index) {
		Player p = (Player)objects.get(0);
		gameObject o=objects.get(index);
		if(o.name == "Trash")
		{
			Trash temp = (Trash)objects.get(index);
			if (temp.getActive())
			{
				temp.Move();
				if (temp.IsCaught(p.getX(),p.getY())) {
					Score++;
					if(Score>HiScore)HiScore=Score;
					if((Score%10)==0)maxtrash++;
					temp.setActive(false);
					trashcount--;
				}
			}
		}
	}

	/**
	 * Updates player lives by pulling trash object from the ArrayList at given index and checks to see if the
	 * object made it to the beach, decrementing Lives and trashcount if so, and resetting the game if Lives is 0 or less.
	 * 
	 * @param i Index of trash object in ArrayList of gameObjects 
	 */
	void updateLives(int i){
		Trash temp = (Trash) objects.get(i);
		if (temp.MadeIt((int)(Window.WIDTH*Window.SCALE))&&temp.getActive()) {
			temp.setActive(false);
			objects.add(new Beached("Beached",temp.getX()-25,temp.getY(),0,0));
			Lives--;
			trashcount--;
			if ((Lives <= 0)) {
				resetGame();
			}
		}
	}

	/**
	 * Skips every other tick. If an 'on' tick, adds to counter and adds new trash if certain amount of ticks have gone by.
	 * Updates player, trash, and score objects.
	 */
	public void tick() {
		if(!inst){
			if(SkipTick)
			{
				SkipTick=false;
				return;
			}
			else
			{
				SkipTick=true;
			}
	        Random rand = new Random();
			counter++;
			if (counter%10 == 0) {
				counter=0;
				if(trashcount<maxtrash)
				{
					Trash temp = new Trash("Trash", (int)(0 * Window.SCALE),
		        			(int)(150+rand.nextInt((int)((Window.HEIGHT-180)))*Window.SCALE),
		        			1+maxvel*rand.nextInt((int)(Score/10)+1), 0);
					temp.setActive(true);
					objects.add(temp);
					trashcount++;
				}
			}
			updatePlayer();
			// Clear dead trash
			for (int i = objects.size()-1;i>1; i--) {
				gameObject o=objects.get(i);
				if (o.name=="Trash")
				{
					if(!(((Trash)objects.get(i)).getActive()))objects.remove(i);
				}
			}
			for (int i = 2;i<objects.size(); i++) {
				gameObject o=objects.get(i);
				if (o.name=="Trash")
				{
					updateTrash(i);
					updateLives(i);
				}
		    	Scoreboard sb=(Scoreboard)objects.get(1);
		    	sb.setScore((int)Score);
		    	sb.setLives((int)Lives);
		    	sb.setHi((int)HiScore);
	
			}
		}

	}

	/**
	 * Returns ArrayList of gameObjects in Game1
	 * 
	 * @return Returns ArrayList of gameObjects
	 */
	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}

	/**
	 * Resets Game1 by setting game values back to starting values, clearing the ArrayList, and setting gameState back to Menu.
	 */
    private void resetGame() {
    	objects.clear();
    	objects.add(new Player("Player",(int)((Window.WIDTH/2)*Window.SCALE),(int)((Window.HEIGHT/2)*Window.SCALE),20,0));
    	Scoreboard SB=new Scoreboard("Score",10,10,0,0);
    	SB.setHi((int)HiScore);
    	objects.add(SB);
		Menu.SCORE += Score*2;
		inst = true;
        maxvel=2;
        maxtrash=10;
        trashcount=0;
        Score=0;
    	Lives = 10;
    	counter = 0;
    	running = false;
    	Controller.gameState = STATE.Menu;
    }
    
    /**
     * Checks to see if the mouse is over given coordinates on the screen.
     * 
     * @param mx Mouse x-position
     * @param my Mouse y-position
     * @param x x-position of image being checked against mouse x-position
     * @param y y-position of image being checked against mouse y-position
     * @param width Width of image being checked for mouse over
     * @param height Height of image being checked for mouse over 
     * @return Returns true if mouse is over given image position, false if otherwise
     */
    boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
	
    /**
     * Takes the width of an image and scales it to the appropriate size for the current screen
     * 
     * @param x Width of image that needs to be scaled
     * @return Returns scaled width for image
     */
	public int scaleW(double x){
		return (int)(Window.SCALE*x);
	}
	
	/**
	 * Takes the height of an image and scales it to the appropriate size for the current screen
	 * 
	 * @param x Height of image that needs to be scaled
	 * @return Returns scaled height for image
	 */
	public int scaleH(double x){
		return (int)(Window.SCALE*x);
	}

	/**
	 * Checks to see whether the game is running or not
	 * 
	 * @return Returns boolean value of running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Sets running variable to given value
	 * 
	 * @param running New value for running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * Checks to see if the mouse is currently clicked or not
	 * 
	 * @return Returns boolean value of mousedown
	 */
	public boolean isMousedown() {
		return mousedown;
	}

	/**
	 * Sets mousedown to new boolean value
	 * 
	 * @param mousedown New boolean value for mousedown
	 */
	public void setMousedown(boolean mousedown) {
		this.mousedown = mousedown;
	}

	/**
	 * Gets mouse x-position on screen from last click
	 * 
	 * @return Returns mouse x-position
	 */
	public int getMx() {
		return mx;
	}

	public void setMx(int mx) {
		this.mx = mx;
	}

	public int getMy() {
		return my;
	}

	public void setMy(int my) {
		this.my = my;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getLastTrash() {
		return lastTrash;
	}

	public void setLastTrash(int lastTrash) {
		this.lastTrash = lastTrash;
	}

	public int getMaxtrash() {
		return maxtrash;
	}

	public void setMaxtrash(int maxtrash) {
		this.maxtrash = maxtrash;
	}

	public int getTrashcount() {
		return trashcount;
	}

	public void setTrashcount(int trashcount) {
		this.trashcount = trashcount;
	}

	public int getMaxvel() {
		return maxvel;
	}

	public void setMaxvel(int maxvel) {
		this.maxvel = maxvel;
	}

	public long getScore() {
		return Score;
	}

	public void setScore(long score) {
		Score = score;
	}

	public long getHiScore() {
		return HiScore;
	}

	public void setHiScore(long hiScore) {
		HiScore = hiScore;
	}

	public long getLives() {
		return Lives;
	}

	public void setLives(long lives) {
		Lives = lives;
	}

	public boolean isSkipTick() {
		return SkipTick;
	}

	public void setSkipTick(boolean skipTick) {
		SkipTick = skipTick;
	}

	public void setObjects(ArrayList<gameObject> objects) {
		this.objects = objects;
	}
	public void stopMouseListener(){
		mlActive = false;
	}
    
    
}