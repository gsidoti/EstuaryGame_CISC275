package OverallGame;

public class G4Player {
	int x;
	int y;
	int vx;
	int vy;
	
	public G4Player(int x, int y, int vx, int vy){
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}
	
	public void moveUp(){
		y-=2;
	}
	public void moveDown(){
		y+=2;
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
}
