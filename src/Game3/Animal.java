package Game3;

import OverallGame.gameObject;

public class Animal extends gameObject{

	Direction dir;
	boolean onScreen;
	
	public Animal(String name, int x, int y, int velx, int vely, Direction dir) {
		super(name, x, y, velx, vely);
		this.dir = dir;
		this.onScreen = true;
	}
	
	
}