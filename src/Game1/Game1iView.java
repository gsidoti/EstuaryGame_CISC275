package Game1;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import OverallGame.Window;
import OverallGame.gameView;

public class Game1iView extends gameView{

	   private int[] dx=new int[5];
	    private int[] dy=new int[5];
	    private int pos=0;
	    private int i;
	
	public Game1iView(){
		loadImages();
	}
	
	public void render(Graphics g){
		//g.setColor(Color.pink);
		//g.fillRect(0, 0,(int)(w*wS), (int)(h*hS));
		g.setColor(new Color(0,32,64));
		g.fillRect(0, 0, (int)(Window.WIDTH*Window.SCALE)-20, (int)(Window.HEIGHT*Window.SCALE));
		g.setColor(new Color(192,192,0));
		g.fillRect((int)(Window.WIDTH*Window.SCALE)-20, 0, 20, (int)(Window.HEIGHT*Window.SCALE));

		g.setColor(new Color(32,64,128));
		//g.drawLine(pos, 0, pos,(int)(Window.HEIGHT*Window.SCALE) );
		for(i=pos-(int)(Window.WIDTH*Window.SCALE);i<(int)(Window.WIDTH*Window.SCALE)-20;i+=100)
		{
			g.drawLine(i, 0, i, (int)(Window.HEIGHT*Window.SCALE) );
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		pos++;
		if(pos>(int)(Window.WIDTH*Window.SCALE)-20)pos=0;
		g.drawString("Insert Game 1 Instructions Here", (int)(Window.WIDTH*Window.SCALE)/2, (int)(Window.HEIGHT*Window.SCALE)/2);
	}

	@Override
	public void loadImages() {
		createImage("smallButton");
		createImage("menuBG");
		images.put("menuBG",resizeImg(images.get("menuBG"),scaleW(Window.WIDTH),scaleH(Window.HEIGHT)));
	}
	
	
}
