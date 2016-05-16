package Game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import OverallGame.Controller;
import OverallGame.Window;
import OverallGame.gameObject;
import OverallGame.gameView;

public class Game2View extends gameView{

	
	public Game2View(){
		loadImages();
	}
	
	
	public void render(Graphics g, ArrayList<gameObject> objects){
		
		//fill screen
		//g.setColor(Color.blue);
		//g.fillRect(0, 0, (int)(Window.WIDTH*Window.SCALE), (int)(Window.HEIGHT*Window.SCALE));
		
		//draw safe zone
		//g.setColor(Color.white);
		//g.fillRect(0,(int)(((Window.HEIGHT/2)-50)*Window.SCALE),(int) (Window.WIDTH*Window.SCALE),(int)(100*Window.SCALE) );
		//g.setColor(new Color(0f, .5f, 0f, .5f));//this would be the green zone
		//g.setColor(new Color(156, 93, 2));
		//g.fillRect(0,0,(int)(100*Window.SCALE),(int)(1000*Window.SCALE));
		//draw boats
		//g.setColor(Color.green);
		g.drawImage(images.get("game2background"), 0, 0, null);
		
		for (int i = 0; i < objects.size(); i++){
			Boat temp = (Boat)(objects.get(i));
			if (temp.getInfested()){
				if(temp.getActive()){
					g.drawImage(images.get("dirtyvessel"), scaleW(temp.getX()), scaleH(temp.getY()), null);
				}else{
					g.drawImage(images.get("dirtyvessel"), scaleW(50-20+(30*temp.getVely())), scaleH(temp.getY()), null);
				}
			}else if(!temp.getInfested()){
				if(temp.getActive()){
					g.drawImage(images.get("cleanvessel"), scaleW(temp.getX()), scaleH(temp.getY()), null);
				}else{
					g.drawImage(images.get("cleanvessel"), scaleW(50-(10*temp.getVelx())+(30*temp.getVely())), scaleH(temp.getY()), null);
				}
			}
					//g.setColor(Color.red);
			//if (temp.getActive()) {
			//	System.out.println(objects.get(i).name+"X: "+objects.get(i).getX()+" Y: "+ objects.get(i).getY()+objects.get(i).getVelx()+" "+ objects.get(i).getVely());
			//	g.fillRect(objects.get(i).getX(),objects.get(i).getY(),25,50);
			//}
		}

		//g.setColor(Color.green);
		//g.drawRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		//g.setColor(Color.red);
		//g.drawRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
		//.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
		
		//draw score bar
		//g.setColor(Color.gray);
		//g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int) (50*Window.SCALE),(int) (50*Window.SCALE),(int)((objects.get(1).getY()/10)*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int)(objects.get(2).getY()/10*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
	}


	@Override
	public void loadImages() {
		createImage("cleanvessel");
		createImage("dirtyvessel");
		createImage("game2background");
		BufferedImage temp = images.get("cleanvessel");
		System.out.println(temp.getWidth()+" "+temp.getHeight());
		images.put("cleanvessel",resizeImg(temp,scaleW(temp.getWidth()/2),scaleH(temp.getHeight()/2)));
		System.out.println(temp.getWidth()+" "+temp.getHeight());
		temp = images.get("dirtyvessel");
		System.out.println(temp.getWidth()+" "+temp.getHeight());
		images.put("dirtyvessel",resizeImg(temp,scaleW(temp.getWidth()/2),scaleH(temp.getHeight()/2)));
		System.out.println(temp.getWidth()+" "+temp.getHeight());
	}
}
