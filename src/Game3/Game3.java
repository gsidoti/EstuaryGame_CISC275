package Game3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

/**
 * Game3 is a game where the objective is to count how many Horseshoe Crabs pass by the screen. It resembles the real life
 * scenario of a Horseshoe Crab spawning survey.
 * For each Horseshoe Crab seen, click the mouse to increase the counter.
 * After all the Animals have come and went, it will display the player's count estimate and the real count, adding score accordingly.
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game3 extends MouseAdapter {
	public boolean running = false;
	Random rand = new Random();
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game3View view;
	long timer1;
	long timer2;
	int mx,my;
	boolean init = false;
	boolean init2 = false;
	boolean start = false;
	int tick;
	public int animals = 0;
	public int actNumCrab = 0;
	public int clickNumCrab = 0;
	
	/**
	 * 
	 */
	public Game3(){
		view = new Game3View();
	}
	
	/**
	 * 
	 */
	public void mousePressed(MouseEvent e){
		clickNumCrab++;
		mx = e.getX();
		my = e.getY();
		if(mouseOver(mx,my,scaleW(5),scaleH(5),scaleW(80),scaleH(44)))
			resetGame();
	}

	/**
	 * 
	 */
	void updateAnimal(){
		Animal a;
		for(gameObject o:objects){
			a = (Animal)(o);
			a.setX(a.getX()+a.getVelx());
			a.setY(a.getY()+a.getVely());
			if(a.name == "Count")
				a.setX(clickNumCrab);
			if(a.onScreen &&( a.getX()<0 || a.getX()>Window.WIDTH*Window.SCALE || a.getY()<0 || a.getY() > Window.HEIGHT*Window.SCALE)){
				if(a.name == "HorseShoe"){
					actNumCrab++;
				}
				animals++;
				a.onScreen = false;
			}
		}
	}
	
	/**
	 * 
	 * @param Enemy
	 * @param speed
	 * @param Amount
	 */
	public void randSpawn(boolean Enemy, int speed, int Amount){
		Random rand = new Random();
		for(int i = 0;i < Amount;i++){
			switch (rand.nextInt(4)){
				case 0:
					spawnLeft(Enemy,speed);
					break;
				case 1:
					spawnRight(Enemy,speed);
					break;
				case 2:
					spawnTop(Enemy,speed);
					break;
				case 3:
					spawnBottom(Enemy,speed);
					break;
			}
		}
	}
	
	/**
	 * 
	 * @param Enemy
	 * @param speed
	 */
	public void spawnLeft(boolean Enemy, int speed){
		Random rand = new Random();
		int x = 0;
		int y = (int)((rand.nextInt(240)+240));
		int velx;
		int vely;
		Direction dir;
		String name = "HorseShoe";
		if(Enemy){
			name = "Enemy";
		}
		velx = 2*speed;
		int r = rand.nextInt(3);
		if( r== 0){
			dir = Direction.NE;
			vely = -1*speed;
		}else if(r == 1){
			dir = Direction.SE;
			vely = 1*speed;
		}else{
			vely = 0;
			dir = Direction.E;
		}
		System.out.println("SpawnLeft Created X: "+x+" Y: "+y);
		objects.add(new Animal(name,x,y,velx,vely,dir));
	}
	
	/**
	 * 
	 * @param Enemy
	 * @param speed
	 */
	public void spawnRight(boolean Enemy, int speed){
		Random rand = new Random();
		int x = (int)(Window.WIDTH);
		int y = (int)((rand.nextInt(240)+240));
		int velx;
		int vely;
		Direction dir;
		String name = "HorseShoe";
		if(Enemy){
			name = "Enemy";
		}
		velx = -2*speed;
		int r = rand.nextInt(3);
		if( r== 0){
			dir = Direction.NW;
			vely = -1*speed;
		}else if(r == 1){
			dir = Direction.SW;
			vely = 1*speed;
		}else{
			vely = 0;
			dir = Direction.W;
		}
		System.out.println("SpawnRight Created X: "+x+" Y: "+y);
		objects.add(new Animal(name,x,y,velx,vely,dir));
	}
	
	/**
	 * 
	 * @param Enemy
	 * @param speed
	 */
	public void spawnTop(boolean Enemy, int speed){
		Random rand = new Random();
		int x = (int)((rand.nextInt(425)+425));
		int y = 0;
		int velx;
		int vely;
		Direction dir;
		String name = "HorseShoe";
		if(Enemy){
			name = "Enemy";
		}
		vely = 1*speed;
		int r = rand.nextInt(3);
		if( r== 0){
			dir = Direction.SW;
			velx = -1*speed;
		}else if(r == 1){
			dir = Direction.SE;
			velx = 1*speed;
		}else{
			velx = 0;
			dir = Direction.S;
		}
		System.out.println("SpawnTop Created X: "+x+" Y: "+y);
		objects.add(new Animal(name,x,y,velx,vely,dir));
	}
	
	/**
	 * 
	 * @param Enemy
	 * @param speed
	 */
	public void spawnBottom(boolean Enemy, int speed){
		Random rand = new Random();
		int x = (int)((rand.nextInt(425)+425));
		int y = (int)(Window.HEIGHT);
		int velx;
		int vely;
		Direction dir;
		String name = "HorseShoe";
		if(Enemy){
			name = "Enemy";
		}
		vely = -1*speed;
		int r = rand.nextInt(3);
		if( r== 0){
			dir = Direction.NW;
			velx = -1*speed;
		}else if(r == 1){
			dir = Direction.NE;
			velx = 1*speed;
		}else{
			velx = 0;
			dir = Direction.N;
		}
		System.out.println("SpawnBottom Created X: "+x+" Y: "+y);
		objects.add(new Animal(name,x,y,velx,vely,dir));
	}
	
	/**
	 * 
	 */
	private void checkEndGame(){
		if(init == false){
			timer1 = System.currentTimeMillis();
			init = true;
		}
		if(System.currentTimeMillis() < timer1+15000.0){
			//System.out.println("if case");
			tick = (tick+1)%31;
			if(tick==30){
				randSpawn(rand.nextBoolean(),rand.nextInt(2)+1,rand.nextInt(2));		
			}
		}else if(init2){
			if(System.currentTimeMillis() > timer2+5000.0){
				if(actNumCrab-clickNumCrab == 0){
					Menu.Menu.SCORE += 100;
				}else if(actNumCrab-clickNumCrab == 1 || clickNumCrab-actNumCrab == 1){
					Menu.Menu.SCORE += 75;
				}else if(actNumCrab-clickNumCrab == 2 || clickNumCrab-actNumCrab == 2){
					Menu.Menu.SCORE += 50;
				}
				resetGame();
			}
		}else if(objects.size() == animals+1){
			if(init2 == false){
				timer2 = System.currentTimeMillis();
				//System.out.println("end game");
				objects.add(new Animal("EndGame",actNumCrab,clickNumCrab,0,0, null));
				init2 = true;
			}
		}
	}
	
	/**
	 * 
	 */
	public void resetGame(){
		init = false;
		init2 = false;
		running = false;
		start = false;
		animals = 0;
		actNumCrab = 0;
		clickNumCrab = 0;
		objects.clear();
		Controller.gameState = STATE.Menu;
	}

	/**
	 * 
	 */
	public void tick() {
		if(!start){
			objects.add(new Animal("Count", 0, 0, 0, 0, null));
			start = true;
		}
		checkEndGame();
		updateAnimal();
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
	public ArrayList<gameObject> getObjects(){
		return this.objects;
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
	public boolean isStart() {
		return start;
	}

	/**
	 * 
	 * @param start
	 */
	public void setStart(boolean start) {
		this.start = start;
	}

	/**
	 * 
	 * @return
	 */
	public int getTick() {
		return tick;
	}

	/**
	 * 
	 * @param tick
	 */
	public void setTick(int tick) {
		this.tick = tick;
	}

	/**
	 * 
	 * @return
	 */
	public int getAnimals() {
		return animals;
	}

	/**
	 * 
	 * @param animals
	 */
	public void setAnimals(int animals) {
		this.animals = animals;
	}

	/**
	 * 
	 * @return
	 */
	public int getActNumCrab() {
		return actNumCrab;
	}

	/**
	 * 
	 * @param actNumCrab
	 */
	public void setActNumCrab(int actNumCrab) {
		this.actNumCrab = actNumCrab;
	}

	/**
	 * 
	 * @return
	 */
	public int getClickNumCrab() {
		return clickNumCrab;
	}

	/**
	 * 
	 * @param clickNumCrab
	 */
	public void setClickNumCrab(int clickNumCrab) {
		this.clickNumCrab = clickNumCrab;
	}
	
	
}