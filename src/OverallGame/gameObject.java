package OverallGame;

public class gameObject {
		public int x;
		public int y;
		protected int velx;
		protected int vely;
		protected String name;
		
		public gameObject(String name, int x, int y, int velx, int vely){
			this.name = name;
			this.x = x;
			this.y = y;
			this.vely = vely;
			this.velx = velx;
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
