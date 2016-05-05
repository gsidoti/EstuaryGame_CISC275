package Game3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

public class Game3 extends MouseAdapter {
	public boolean running = false;
	Random rand = new Random();
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game3View view;
	long timer1;
	long timer2;
	boolean init = false;
	boolean init2 = false;
	boolean start = false;
	int tick;
	public static int animals = 0;
	public int actNumCrab = 0;
	public int clickNumCrab = 0;
	
	public Game3(){
		view = new Game3View();
	}
	
	public void mousePressed(MouseEvent e){
		clickNumCrab++;
	}


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
	
	public void spawnLeft(boolean Enemy, int speed){
		Random rand = new Random();
		int x = 0;
		int y = (int)((rand.nextInt(240)+240)*Window.SCALE);
		int velx;
		int vely;
		Direction dir;
		String name = "HorseShoe";
		if(Enemy){
			name = "Enemy";
		}
		velx = 1*speed;
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
	
	public void spawnRight(boolean Enemy, int speed){
		Random rand = new Random();
		int x = (int)(Window.WIDTH*Window.SCALE);
		int y = (int)((rand.nextInt(240)+240)*Window.SCALE);
		int velx;
		int vely;
		Direction dir;
		String name = "HorseShoe";
		if(Enemy){
			name = "Enemy";
		}
		velx = -1*speed;
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
	
	public void spawnTop(boolean Enemy, int speed){
		Random rand = new Random();
		int x = (int)((rand.nextInt(425)+425)*Window.SCALE);
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
	
	public void spawnBottom(boolean Enemy, int speed){
		Random rand = new Random();
		int x = (int)((rand.nextInt(425)+425)*Window.SCALE);
		int y = (int)(Window.HEIGHT*Window.SCALE);
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
				//System.out.println("else case");
				init = false;
				init2 = false;
				running = false;
				start = false;
				actNumCrab = 0;
				clickNumCrab = 0;
				objects.removeAll(objects);
				Controller.gameState = STATE.Menu;
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

	

	public void tick() {
		if(!start){
			objects.add(new Animal("Count", 0, 0, 0, 0, null));
			start = true;
		}
		checkEndGame();
		updateAnimal();
	}

	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public int getTick() {
		return tick;
	}

	public void setTick(int tick) {
		this.tick = tick;
	}

	public static int getAnimals() {
		return animals;
	}

	public static void setAnimals(int animals) {
		Game3.animals = animals;
	}

	public int getActNumCrab() {
		return actNumCrab;
	}

	public void setActNumCrab(int actNumCrab) {
		this.actNumCrab = actNumCrab;
	}

	public int getClickNumCrab() {
		return clickNumCrab;
	}

	public void setClickNumCrab(int clickNumCrab) {
		this.clickNumCrab = clickNumCrab;
	}
	
	
}