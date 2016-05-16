package Game2;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import OverallGame.Window;
import OverallGame.gameView;

public class Game2iView extends gameView{

	
	public Game2iView(){
		loadImages();

	}
	
	public void render(Graphics g){
		g.drawImage(images.get("game2background"), 0, 0, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Clean The Boats!", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4);
		g.drawString("Shipping boats are coming to port, but some brought", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+60);
		g.drawString("invasive species along with them", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+90);
		g.drawString("Click on the dirty boats to clean them off before they dock", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+150);
		g.drawString("If you let 3 dirty boats in, it's Game Over ", (int)(Window.WIDTH*Window.SCALE)/4, (int)(Window.HEIGHT*Window.SCALE)/4+210);
		g.drawString("-> Click to begin <-", (int)(Window.WIDTH*Window.SCALE)/2-150, (int)(Window.HEIGHT*Window.SCALE)-50);
	}

	@Override
	public void loadImages() {
		createImage("game2background");
	}
}