package Game3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import Game2.Boat;
import Game4.G4Player;
import Game4.Game4View;
import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

public class Game3 extends MouseAdapter {
	public boolean running = false;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game3View view;

	public int actNumCrab = 0;
	public int clickNumCrab = 0;
	
	public Game3(){
		
		view = new Game3View();
	}
	
	public void mousePressed(MouseEvent e){
		clickNumCrab++;
	}


	private void updateAnimal(){
		for(gameObject o:objects){
			o.setX(o.getX()+o.getVelx());
			o.setY(o.getY()+o.getVely());
			checkOffScreen(o);
		}
	}
	
	public void checkOffScreen(gameObject o){
		Animal a = (Animal)(o);
		if(a.getX()<0 || a.getX()>Window.WIDTH*Window.SCALE || a.getY()<0 || a.getY() > Window.HEIGHT*Window.SCALE){
			actNumCrab++;
			a.onScreen = false;
		}
	}
	
	public void randSpawn(boolean Enemy, int speed){
		Random rand = new Random();
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
	
	public void spawnLeft(boolean Enemy, int speed){
		Random rand = new Random();
		int x = 0;
		int y = rand.nextInt(Window.HEIGHT-200+1)+200;
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
		objects.add(new Animal(name,x,y,velx,vely,dir));
	}
	
	public void spawnRight(boolean Enemy, int speed){
		Random rand = new Random();
		int x = (int)(Window.WIDTH*Window.SCALE);
		int y = rand.nextInt(Window.HEIGHT-200+1)+200;
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
		objects.add(new Animal(name,x,y,velx,vely,dir));
	}
	
	public void spawnTop(boolean Enemy, int speed){
		Random rand = new Random();
		int x = rand.nextInt(Window.WIDTH-200+1)+200;
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
		objects.add(new Animal(name,x,y,velx,vely,dir));
	}
	
	public void spawnBottom(boolean Enemy, int speed){
		Random rand = new Random();
		int x = rand.nextInt(Window.HEIGHT-200+1)+200;
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
		objects.add(new Animal(name,x,y,velx,vely,dir));
	}

	

	public void tick() {
		updateAnimal();
		//System.out.println();
	}

	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}
}