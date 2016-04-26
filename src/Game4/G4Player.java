package Game4;

import OverallGame.gameObject;

public class G4Player extends gameObject{
	
	int vyUp;
	int vyDown;
	boolean mousedown;
	
	public G4Player(String name, int x, int y, int velx, int vely) {
		super(name, x, y, velx, vely);
	}
	
	void moveDown(){
		y += vely;
	//	System.out.println("down "+ y+" "+ vely);
	}
	
	void moveUp(){
		y -= vely;
	//	System.out.println("up "+y+" "+ vely);
	}
	
	/*void moveLeft(){
		x -= velx;
	}
	
	void moveRight(){
		x += velx;
	}
	*/
}