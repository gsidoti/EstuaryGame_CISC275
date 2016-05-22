package Game4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
	int []waterTop;
	
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
		createImage("sky");
		createImage("underwater2");
		createImage("watertester");
		createImage("game4_bgTile");
		createImage("g4_sand");
		images.put("underwater2",resizeImg(images.get("underwater2"),scaleW(Window.WIDTH),scaleH(Window.HEIGHT)));
		createImage("exit");
		BufferedImage img = images.get("game4_bgTile");
		int w = images.get("game4_bgTile").getWidth();
		System.out.println(w);
		waterTop = new int[scaleW(288)];
		for(int i = 0; i<scaleW(288);i++){
			int y = 0;
			while((img.getRGB(i,y)>>24) == 0x00){
				y++;
				System.out.println("y++");
			}
			waterTop[i] = y;
		}
		for(int i = 0; i<scaleW(288);i++){
			System.out.print(waterTop[i]/Window.SCALE+", ");
		}
	}
	
	/**
	 * Handles drawing all of the objects on screen at every tick.
	 * 
	 * @param g The graphics for the game
	 * @param objects The ArrayList of gameObjects in the game
	 */
	public void render(Graphics g, ArrayList<gameObject> objects){
		//make the water move
		g.drawImage(images.get("sky"), scaleW(0), scaleH(0), null);
		for(int i=-1;i<10;i++){
			g.drawImage(images.get("game4_bgTile"), scaleW(objects.get(3).x+(i*288)), scaleH(0), null);
		}
		objects.get(3).x = (objects.get(3).x+1)%288;
		g.drawImage(images.get("g4_sand"), scaleW(0), scaleH(Window.HEIGHT-82), null);

		
		//get player location
		player = (G4Player) objects.get(0);
		//draw images
		g.drawImage(images.get("vessel"), scaleW(380), scaleH(13+objects.get(3).x/10), null);
	
		//draw rope
		g.setColor(Color.black);
		g.fillRect(scaleW(618),scaleH(53),scaleW(2),scaleH(player.y-20));
		
		//draw watertester
		g.drawImage(images.get("watertester"), scaleW(Window.WIDTH/2-30), scaleH(player.y-10), null);
		
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