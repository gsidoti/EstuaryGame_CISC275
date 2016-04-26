package Game2;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

import Game2.Boat;
import Game2.Game2View;
import Game4.G4Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

/**
 * Write a description of class Game2 here.
 * 
 * @author Cody Fox
 * @version 0.1
 */

public class Game2 extends MouseAdapter {

    //private FrameRate frameRate;
    //private BufferStrategy bs;
    //public boolean running;
    //private Thread gameThread;
    //private SimpleMouseInput mouse;
    //private KeyboardInput keyboard;
    //private Player player;
    private int maxvel;
    private int counter = 0;
    private int lastBoat = 0;
    private int mx, my;
	public boolean running = false;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game2View view;
	boolean mousedown = false;
    private long Lives;
   
    public Game2() {
        int i;
        
        Lives=10;
        maxvel=1;
        Random rand = new Random();
        for(i=0;i<100;i++)
        	objects.add(new Boat(("Boat"+i), (int)(Window.WIDTH * Window.SCALE), (rand.nextInt((int)(Window.HEIGHT*Window.SCALE))), 2, 0, rand.nextBoolean()));
        view = new Game2View();
    }
    
	public void mousePressed(MouseEvent e){
		mousedown = true;
		mx = e.getX();
		my = e.getY();
	}
	
	public void mouseReleased(MouseEvent e){
		mousedown = false;
	}
	
	private void updateBoat(int index) {
		Boat b = (Boat)objects.get(index);
		if (b.getActive())
			b.Move();
		if (mouseOver(mx,my,b.getX(),b.getY(),25,50)) {
				 b.setInfested(false);
		}
	}
	
	private void updateLives(){
		for (int i = 0; i < objects.size(); i++) {
			Boat b = (Boat) objects.get(i);
			if (b.MadeIt((int)(100*Window.SCALE))&&b.getActive()) {
				b.setActive(false);
				if (b.getInfested()) {
					Lives--;
					if (Lives <= 0) {
						resetGame();
					}
				}
			}
		}
	}

	
	public void tick() {
		counter++;
		if (counter%10 == 0) {
			Boat temp = (Boat)objects.get(lastBoat);
			temp.setActive(true);
			objects.set(lastBoat, temp);
			if (lastBoat < 99)
				lastBoat++;
		}
		for (int i = 0; i < objects.size(); i++) {
			updateBoat(i);
			updateLives();
			System.out.println("Boats: " + objects.size() + " Lives: " + Lives);
		}
	}
	
	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}
	
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
    
    private void resetGame() {
    	Random rand = new Random();
    	Lives = 10;
    	lastBoat = 0;
    	counter = 0;
    	for(int i=0;i<100;i++)
        	objects.set(i, new Boat(("Boat"+i), (int)(Window.WIDTH * Window.SCALE), 
        			(rand.nextInt((int)(Window.HEIGHT*Window.SCALE))), 2, 0, rand.nextBoolean()));
    	running = false;
    	Controller.gameState = STATE.Menu;
    }
}
