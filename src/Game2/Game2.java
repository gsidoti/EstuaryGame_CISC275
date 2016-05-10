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


public class Game2 extends MouseAdapter {

    private int speed = 1;
    private int boatspeed = 200;
    private int counter = 0;
    private int lastBoat = 0;//dont need
    private int mx, my;
	public boolean running = false;
	public static int[] docks = new int[6];
	
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game2View view;
	Random rand = new Random();
	boolean mousedown = false;//dont need
    private int Lives = 3000;
   
    public Game2() {
        view = new Game2View();
    }
    
	public void mousePressed(MouseEvent e){
		mousedown = true;//dont need
		mx = e.getX();
		my = e.getY();
		System.out.println("X: "+mx+" Y: "+my);
	}
	
	public void mouseReleased(MouseEvent e){//dont need
		mousedown = false;
	}
	
	void updateBoat(int index) {
		Boat b = (Boat)objects.get(index);
		if (b.getActive())
			b.Move();
		if (mouseOver(mx,my,scaleW(b.getX()-5),scaleH(b.getY()-5),scaleW(130),scaleH(65))&&b.getActive()) {
				 b.setInfested(false);
		}
	}
	
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
	
	public void addBoat(){
		int r = rand.nextInt(6),y = 0;
		if(objects.size()!=35){
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
			//System.out.println(boatcount++);
		}else{
			resetGame();
		}
	}

	
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
	
	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}
	
    boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
    
    void resetGame() {
    	Lives = 3;
    	counter = 0;
        speed = 1;
        boatspeed = 200;
    	objects.clear();
    	Arrays.fill(docks, 0);
    	running = false;
    	Controller.gameState = STATE.Menu;
    }
    
	public int scaleW(double x){
		return (int)(Window.SCALE*x);
	}
	
	public int scaleH(double x){
		return (int)(Window.SCALE*x);
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
    
    public int getLastBoat() {
    	return lastBoat;
    }
    
    public void setLastBoat(int num) {
    	lastBoat = num;
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
    
    public boolean getMousedown() {
    	return mousedown;
    }
    
    public void setMousedown(boolean value) {
    	mousedown = value;
    }
}
