package Game4;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import OverallGame.Window;
import OverallGame.gameView;

public class Game4iView extends gameView{
	
	public Game4iView(){
		loadImages();
	}
	
	public void render(Graphics g){
		//g.setColor(Color.pink);
		//g.fillRect(0, 0,(int)(w*wS), (int)(h*hS));
		g.drawImage(images.get("underwater2"), scaleW(0), scaleH(0), null);

		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Insert Game 4 Instructions Here", (int)(Window.WIDTH*Window.SCALE)/2, (int)(Window.HEIGHT*Window.SCALE)/2);
	}

	@Override
	public void loadImages() {
		createImage("smallButton");
		createImage("underwater2");

		createImage("menuBG");
		images.put("menuBG",resizeImg(images.get("menuBG"),scaleW(Window.WIDTH),scaleH(Window.HEIGHT)));
		images.put("underwater2",resizeImg(images.get("underwater2"),scaleW(Window.WIDTH),scaleH(Window.HEIGHT)));

	}
	
	
}