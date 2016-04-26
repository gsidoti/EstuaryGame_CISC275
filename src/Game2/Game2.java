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
        for(i=0;i<100;i++)
        	objects.add(new Boat(("Boat"+i), (int)(Window.WIDTH * Window.SCALE), (int)(Math.random()%Window.HEIGHT), 0, 0));
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
		b.Move();
		if (b.IsCaught(mx, my)) {
				b.setInfested(false);
			}
		}
	
	private void updateLives(){
		for (int i = 0; i < objects.size(); i++) {
			Boat b = (Boat) objects.get(i);
			if (b.MadeIt(0)) {
				b.setActive(false);
				Lives--;
			}
		}
	}
	
	public void tick() {
		for (int i = 0; i < objects.size(); i++)
			updateBoat(i);
		updateLives();
		System.out.println("Boats: " + objects.size() + " Lives: " + Lives);
	}
	
	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}
}
