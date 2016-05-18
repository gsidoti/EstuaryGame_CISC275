package OverallGame;

/**
 * gameObject is a class used as a mold for all of the gameObjects in each game.
 * A gameObject has a position, velocity, and a name.
 * 
 * @author Team 7
 * @version 5/17
 */

public class gameObject {
		public int x;
		public int y;
		protected int velx;
		protected int vely;
		public String name;
		
		/**
	     * Constructor for gameObject objects
	     * 
	     * @param name name of the object
		 * @param x x-position of the object
		 * @param y y-position of the object
		 * @param velx x velocity of the object
		 * @param vely y velocity of the object
		 */
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
