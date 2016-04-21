package OverallGame;

public abstract class gameObject {
		int x;
		int y;
		int velx;
		int vely;
		String name;
		
		public gameObject(int x, int y, int velx, int vely){
			this.x = x;
			this.y = y;
			this.velx = velx;
			this.vely = vely;
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

		public int getVelx() {
			return velx;
		}

		public void setVelx(int velx) {
			this.velx = velx;
		}

		public int getVely() {
			return vely;
		}

		public void setVely(int vely) {
			this.vely = vely;
		}
		
}
