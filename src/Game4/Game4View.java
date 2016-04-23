package Game4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import OverallGame.Window;
import OverallGame.gameObject;
import OverallGame.gameView;

public class Game4View extends gameView{

	
	public Game4View(){}
	
	
	public void render(Graphics g, ArrayList<gameObject> objects){
		
		//fill screen
		gameObject player = objects.get(0);
		g.setColor(Color.blue);
		g.fillRect(0, 0, (int)(Window.WIDTH*Window.SCALE), (int)(Window.HEIGHT*Window.SCALE));
		
		//draw safe zone
		g.setColor(Color.white);
		g.fillRect(0,(int)(((Window.HEIGHT/2)-50)*Window.SCALE),(int) (Window.WIDTH*Window.SCALE),(int)(100*Window.SCALE) );
		g.setColor(new Color(0f, .5f, 0f, .5f));//this would be the green zone
		g.fillRect(0,(int)(((Window.HEIGHT/2)-50)*Window.SCALE),(int) (Window.WIDTH*Window.SCALE),(int)(100*Window.SCALE) );
		
		g.setColor(Color.red);
		g.fillRect(player.getX(),player.getY(),100,100);
		g.setColor(Color.green);
		g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		g.setColor(Color.red);
		g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
	}
}