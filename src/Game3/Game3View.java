package Game3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import OverallGame.Window;
import OverallGame.gameObject;
import OverallGame.gameView;

public class Game3View extends gameView{

	
	public Game3View(){}
	
	
	public void render(Graphics g, ArrayList<gameObject> objects){
		
		//fill screen and draw brown box
		g.setColor(new Color(102,51,0));
		g.fillRect(0, 0, (int)(Window.WIDTH*Window.SCALE), (int)(Window.HEIGHT*Window.SCALE));
		g.setColor(new Color(244,164,96));
		g.fillRect((int)(100*Window.SCALE), (int)(100*Window.SCALE), (int)((Window.WIDTH-200)*Window.SCALE), (int)((Window.HEIGHT-200)*Window.SCALE));
		
		for(gameObject o: objects){
			Animal a = (Animal)(o);
			if(o.name == "HorseShoe"){
				g.setColor(Color.green);
				g.fillOval(a.getX(),a.getY(), (int)(100*Window.SCALE),(int)(100*Window.SCALE));
			}else if(o.name == "Enemy"){
				g.setColor(Color.red);
				g.fillOval(a.getX(),a.getY(), (int)(100*Window.SCALE),(int)(100*Window.SCALE));
			}
		}

		//draw score bar
		//g.setColor(Color.gray);
		//g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int) (50*Window.SCALE),(int) (50*Window.SCALE),(int)((objects.get(1).getY()/10)*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int)(objects.get(2).getY()/10*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
	}
}