package OverallGame;

public class G4Player {
	int x;
	int y;
	int vyUp;
	int vyDown;
	
	public G4Player(int x, int y, int vyUp, int vyDown){
		this.x = x;
		this.y = y;
		this.vyUp = vyUp;
		this.vyDown = vyDown;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVyUp() {
		return vyUp;
	}

	public void setVyUp(int vyUp) {
		this.vyUp = vyUp;
	}

	public int getVyDown() {
		return vyDown;
	}

	public void setVyDown(int vyDown) {
		this.vyDown = vyDown;
	}
	
}