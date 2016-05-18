package Game4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import OverallGame.Window;
import OverallGame.gameObject;
import OverallGame.gameView;

/**
 * Game4View is the view of Game4 and it handles drawing all of the images and text on screen at every tick
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game4View extends gameView{
	G4Player player;
	
	/**
	 * Constructor for Game4View objects
	 */
	public Game4View(){
		loadImages();
	}
	
	/**
	 * Loads the needed images for the game
	 */
	public void loadImages(){
		createImage("vessel");
		createImage("underwater2");
		createImage("watertester");

		System.out.println(	images.get("watertester").getWidth()+" "+		images.get("watertester").getHeight());
		images.put("underwater2",resizeImg(images.get("underwater2"),scaleW(Window.WIDTH),scaleH(Window.HEIGHT)));
		createImage("exit");
	}
	
	/**
	 * Handles drawing all of the objects on screen at every tick.
	 * 
	 * @param g The graphics for the game
	 * @param objects The ArrayList of gameObjects in the game
	 */
	public void render(Graphics g, ArrayList<gameObject> objects){
		//get player location
		player = (G4Player) objects.get(0);
		
		//draw images
		g.drawImage(images.get("underwater2"), scaleW(0), scaleH(0), null);
		g.drawImage(images.get("vessel"), scaleW(380), scaleH(13), null);
		//draw green zone
		g.setColor(new Color(0f, .5f, 0f, .5f));
		g.fillRect(0,scaleH(Window.HEIGHT/2-50),scaleW(Window.WIDTH),scaleH(100));
		
		//draw rope
		g.setColor(Color.black);
		g.fillRect(scaleW(618),scaleH(53),scaleW(4),scaleH(player.y-20));
		
		//draw watertester
		g.drawImage(images.get("watertester"), scaleW(Window.WIDTH/2-37), scaleH(player.y-25), null);
		
		//draw score bar
		g.setColor(Color.green);
		g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		g.setColor(Color.red);
		g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
		g.setColor(Color.gray);
		g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int) (50*Window.SCALE),(int) (50*Window.SCALE),(int)((objects.get(1).getY()/10)*Window.SCALE));
		g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int)(objects.get(2).getY()/10*Window.SCALE));
		g.drawImage(images.get("exit"), scaleW(5), scaleH(5), null);
	}
}