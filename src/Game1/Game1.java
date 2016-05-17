package Game1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

import Game1.Player;
import Game1.Trash;
import Game2.Boat;
import Game4.G4Player;
import OverallGame.gameObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;

/**
 * Game1 is a game where the object is to move your player boat to collect the trash that is moving by before
 * they reach the beach, as the trash will disturb and harm the surrounding wildlife
 *
 * @author Team 7
 * @version 5/17
 */

public class Game1 extends MouseAdapter {

    //private FrameRate frameRate;
    //private BufferStrategy bs;
    public boolean running = false;
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
	 * 
	 */
    public Game1() {
    	int i;
        Lives=10;
        maxvel=2;
        maxtrash=10;
        trashcount=0;
        Score=0;
        HiScore=0;
        Random rand = new Random();
		objects.add( new Player("Player",(int)((Window.WIDTH/2)*Window.SCALE),(int)((Window.HEIGHT/2)*Window.SCALE),20,0));
    	objects.add( new Scoreboard("Score",10,10,0,0));
    	Scoreboard sb=(Scoreboard)objects.get(1);
    	sb.setScore((int)Score);
    	sb.setLives((int)Lives);

       //for(i=1;i<100;i++)
        	//objects.add(i, new Trash(("Trash"), (int)(0 * Window.SCALE),
        		//	(rand.nextInt((int)(Window.HEIGHT*Window.SCALE))),
        			//1+maxvel*rand.nextInt((int)(Score)+1), 0));
        view = new Game1View();
    }

    /**
     * 
     */
	public void mousePressed(MouseEvent e){
		mousedown = true;
		Player p = (Player) (objects.get(0));
		mx = e.getX();
		my = e.getY();
		p.SetDest(mx, my);
		if(mouseOver(mx,my,scaleW(Window.WIDTH-85),scaleH(5),scaleW(80),scaleH(44)))
			resetGame();
}

	/**
	 * 
	 */
	public void mouseReleased(MouseEvent e){
		mousedown = false;
	}

	/**
	 * 
	 */
	void updatePlayer(){
		Player p = (Player) (objects.get(0));
		p.Move();
	}

	/**
	 * 
	 * @param index
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
	 * 
	 * @param i
	 */
	void updateLives(int i){
		Trash temp = (Trash) objects.get(i);
		if (temp.MadeIt((int)(Window.WIDTH*Window.SCALE))&&temp.getActive()) {
			temp.setActive(false);
			objects.add(new Beached("Beached",temp.getX()-10,temp.getY(),0,0));
			Lives--;
			trashcount--;
			if (Lives <= 0) {
				resetGame();
			}
		}
	}

	/**
	 * 
	 */
	public void tick() {
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
	        			(rand.nextInt((int)(Window.HEIGHT*Window.SCALE))),
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
		//System.out.println("Trash: " + objects.size() + " Lives: " + Lives);

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
	 */
    private void resetGame() {

    	Random rand = new Random();
    	objects.set(0, new Player("Player",(int)((Window.WIDTH/2)*Window.SCALE),(int)((Window.HEIGHT/2)*Window.SCALE),20,0));
    	Scoreboard SB=new Scoreboard("Score",10,10,0,0);
    	SB.setHi((int)HiScore);
    	objects.set(1, SB);
        maxvel=2;
        maxtrash=10;
        trashcount=0;
        Score=0;
    	Lives = 10;
    	counter = 0;
    	running = false;
		for (int i = objects.size()-1;i>1; i--) {
			objects.remove(i);
		}

    	Controller.gameState = STATE.Menu;
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
	public boolean isRunning() {
		return running;
	}

	/**
	 * 
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isMousedown() {
		return mousedown;
	}

	/**
	 * 
	 * @param mousedown
	 */
	public void setMousedown(boolean mousedown) {
		this.mousedown = mousedown;
	}

	/**
	 * 
	 * @return
	 */
	public int getMx() {
		return mx;
	}

	/**
	 * 
	 * @param mx
	 */
	public void setMx(int mx) {
		this.mx = mx;
	}

	/**
	 * 
	 * @return
	 */
	public int getMy() {
		return my;
	}

	/**
	 * 
	 * @param my
	 */
	public void setMy(int my) {
		this.my = my;
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
	 * @param counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * 
	 * @return
	 */
	public int getLastTrash() {
		return lastTrash;
	}

	/**
	 * 
	 * @param lastTrash
	 */
	public void setLastTrash(int lastTrash) {
		this.lastTrash = lastTrash;
	}

	/**
	 * 
	 * @return
	 */
	public int getMaxtrash() {
		return maxtrash;
	}

	/**
	 * 
	 * @param maxtrash
	 */
	public void setMaxtrash(int maxtrash) {
		this.maxtrash = maxtrash;
	}

	/**
	 * 
	 * @return
	 */
	public int getTrashcount() {
		return trashcount;
	}

	/**
	 * 
	 * @param trashcount
	 */
	public void setTrashcount(int trashcount) {
		this.trashcount = trashcount;
	}

	/**
	 * 
	 * @return
	 */
	public int getMaxvel() {
		return maxvel;
	}

	/**
	 * 
	 * @param maxvel
	 */
	public void setMaxvel(int maxvel) {
		this.maxvel = maxvel;
	}

	/**
	 * 
	 * @return
	 */
	public long getScore() {
		return Score;
	}

	/**
	 * 
	 * @param score
	 */
	public void setScore(long score) {
		Score = score;
	}

	/**
	 * 
	 * @return
	 */
	public long getHiScore() {
		return HiScore;
	}

	/**
	 * 
	 * @param hiScore
	 */
	public void setHiScore(long hiScore) {
		HiScore = hiScore;
	}

	/**
	 * 
	 * @return
	 */
	public long getLives() {
		return Lives;
	}

	/**
	 * 
	 * @param lives
	 */
	public void setLives(long lives) {
		Lives = lives;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isSkipTick() {
		return SkipTick;
	}

	/**
	 * 
	 * @param skipTick
	 */
	public void setSkipTick(boolean skipTick) {
		SkipTick = skipTick;
	}

	/**
	 * 
	 * @param objects
	 */
	public void setObjects(ArrayList<gameObject> objects) {
		this.objects = objects;
	}
    
    
}