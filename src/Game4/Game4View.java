package Game4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import OverallGame.Window;
import OverallGame.gameObject;
import OverallGame.gameView;

public class Game4View extends gameView{
	G4Player player;
	
	
	public Game4View(){
		loadImages();
	}
	
	public void loadImages(){
		createImage("vessel");
		createImage("underwater2");
		createImage("watertester");
		images.put("underwater2",resizeImg(images.get("underwater2"),scaleW(Window.WIDTH),scaleH(Window.HEIGHT)));
	}
	
	public void render(Graphics g, ArrayList<gameObject> objects){
		//get player location
		player = (G4Player) objects.get(0);
		
		//draw images
		g.drawImage(images.get("underwater2"), scaleW(0), scaleH(0), null);
		g.drawImage(images.get("vessel"), scaleW(380), scaleH(13), null);
		//draw green zone
		g.setColor(new Color(0f, .5f, 0f, .5f));
		g.fillRect(0,(int)(((Window.HEIGHT/2)-50)*Window.SCALE),(int) (Window.WIDTH*Window.SCALE),(int)(100*Window.SCALE) );
		
		//draw rope
		g.setColor(Color.black);
		g.fillRect(scaleW(618),scaleH(53),scaleW(4),scaleH(player.y-20));
		
		//draw watertester
		g.drawImage(images.get("watertester"), scaleW(Window.WIDTH/2-38), scaleH(player.y-25), null);
		
		//draw score bar
		g.setColor(Color.green);
		g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		g.setColor(Color.red);
		g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
		g.setColor(Color.gray);
		g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int) (50*Window.SCALE),(int) (50*Window.SCALE),(int)((objects.get(1).getY()/10)*Window.SCALE));
		g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int)(objects.get(2).getY()/10*Window.SCALE));
	}
}