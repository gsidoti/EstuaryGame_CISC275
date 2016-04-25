package Menu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;

public class Menu extends MouseAdapter {
	public MenuView menuView;
	public boolean running = false;
	boolean mlActive;
	public static int HSCORE = 0;
	public static int ESCORE = 0;
	
	public Menu(Window W){
		menuView = new MenuView(W);
	}
	
	public void stopMouseListener(){
		mlActive = false;
	}
	
	public void exitMenu(){
		running = false;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx,my,(1280/100)*60,(720/100)*60,200,200)){
			System.out.println("click");
			Controller.gameState = STATE.Game4;
			exitMenu();
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
