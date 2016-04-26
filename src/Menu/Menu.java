package Menu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

public class Menu extends MouseAdapter {
	public MenuView menuView;
	public boolean running = false;
	boolean mlActive;
	public static int HSCORE = 0;
	public static int ESCORE = 0;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Menu(Window W){
		objects.add(new gameObject("Game1",  ((int)(Window.WIDTH*Window.SCALE)/100)*20,  ((int)(Window.HEIGHT*Window.SCALE)/100)*20, (int)(200.0*Window.SCALE),(int)(200.0*Window.SCALE) ));
		objects.add(new gameObject("Game2",  ((int)(Window.WIDTH*Window.SCALE)/100)*60,  ((int)(Window.HEIGHT*Window.SCALE)/100)*20, (int)(200.0*Window.SCALE),(int)(200.0*Window.SCALE) ));
		objects.add(new gameObject("Game3",  ((int)(Window.WIDTH*Window.SCALE)/100)*20,  ((int)(Window.HEIGHT*Window.SCALE)/100)*60, (int)(200.0*Window.SCALE),(int)(200.0*Window.SCALE) ));
		objects.add(new gameObject("Game4",  ((int)(Window.WIDTH*Window.SCALE)/100)*60,  ((int)(Window.HEIGHT*Window.SCALE)/100)*60, (int)(200.0*Window.SCALE),(int)(200.0*Window.SCALE) ));
		menuView = new MenuView(W);
	}
	
	public void stopMouseListener(){
		mlActive = false;
	}
	

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		gameObject g1 = objects.get(0);
		gameObject g2 = objects.get(1);
		gameObject g3 = objects.get(2);
		gameObject g4 = objects.get(3);
		if(mouseOver(mx,my,g1.getX(),g1.getY(),g1.getVelx(),g1.getVely())){	
			Controller.gameState = STATE.Game1;
			running = false;
			System.out.println("game1");
		}else if(mouseOver(mx,my,g2.getX(),g2.getY(),g2.getVelx(),g2.getVely())){
			Controller.gameState = STATE.Game2;
			running = false;
			System.out.println("game2");
		}else if(mouseOver(mx,my,g3.getX(),g3.getY(),g3.getVelx(),g3.getVely())){

		}else if(mouseOver(mx,my,g4.getX(),g4.getY(),g4.getVelx(),g4.getVely())){
			Controller.gameState = STATE.Game4;
			running = false;
			System.out.println("game4");
		}
	}
	//not being used
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }

	public void tick() {
		
	}

}
