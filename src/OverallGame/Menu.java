package OverallGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {
	MenuView menuView;
	boolean running = false;
	boolean mlActive;
	//STATE gameState = STATE.Menu;
	
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
