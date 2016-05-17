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
		 * 
		 * @param name
		 * @param x
		 * @param y
		 * @param velx
		 * @param vely
		 */
		public gameObject(String name, int x, int y, int velx, int vely){
			this.name = name;
			this.x = x;
			this.y = y;
			this.vely = vely;
			this.velx = velx;
		}

		/**
		 * 
		 * @return
		 */
		public int getX() {
			return x;
		}

		/**
		 * 
		 * @param x
		 */
		public void setX(int x) {
			this.x = x;
		}

		/**
		 * 
		 * @return
		 */
		public int getY() {
			return y;
		}

		/**
		 * 
		 * @param y
		 */
		public void setY(int y) {
			this.y = y;
		}

		/**
		 * 
		 * @return
		 */
		public int getVelx() {
			return velx;
		}

		/**
		 * 
		 * @param velx
		 */
		public void setVelx(int velx) {
			this.velx = velx;
		}

		/**
		 * 
		 * @return
		 */
		public int getVely() {
			return vely;
		}

		/**
		 * 
		 * @param vely
		 */
		public void setVely(int vely) {
			this.vely = vely;
		}
		
}
