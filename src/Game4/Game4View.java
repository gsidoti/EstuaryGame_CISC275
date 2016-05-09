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
		//fill screen
		player = (G4Player) objects.get(0);
		//g.setColor(Color.blue);
		//g.fillRect(0, 0, (int)(Window.WIDTH*Window.SCALE), (int)(Window.HEIGHT*Window.SCALE));
		
		
		g.drawImage(images.get("underwater2"), scaleW(0), scaleH(0), null);
		g.drawImage(images.get("vessel"), scaleW(400), scaleH(20), null);
		g.drawImage(images.get("vessel"), scaleW(400), scaleH(20), null);
		
		
		//draw safe zone
		g.setColor(Color.white);
		g.fillRect(0,(int)(((Window.HEIGHT/2)-50)*Window.SCALE),(int) (Window.WIDTH*Window.SCALE),(int)(100*Window.SCALE) );
		//this would be the green zone
		g.setColor(new Color(0f, .5f, 0f, .5f));
		g.fillRect(0,(int)(((Window.HEIGHT/2)-50)*Window.SCALE),(int) (Window.WIDTH*Window.SCALE),(int)(100*Window.SCALE) );
		//draw water tester
		g.setColor(Color.red);
		g.fillRect(player.x-10,player.y-25,(int)(20*Window.SCALE),(int)(50*Window.SCALE));
		

		g.setColor(Color.green);
		//g.drawRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		g.setColor(Color.red);
		//g.drawRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
		g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
		
		//draw score bar
		g.setColor(Color.gray);
		g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int) (50*Window.SCALE),(int) (50*Window.SCALE),(int)((objects.get(1).getY()/10)*Window.SCALE));
		g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int)(objects.get(2).getY()/10*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
	}
}