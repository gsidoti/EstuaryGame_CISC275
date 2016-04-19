package OverallGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {
	int WIDTH, HEIGHT;
	MenuView menuView;
	boolean running;
	STATE gameState = STATE.Menu;
	
	public Menu(int w, int h){
		this.WIDTH = w;
		this.HEIGHT =h;

		menuView = new MenuView(w,h);
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx,my,(WIDTH/100)*60,(HEIGHT/100)*60,200,200)){
			System.out.println("click");
			gameState = STATE.Game4;
		}
	}
	
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }

	public STATE tick() {
		return gameState;
	}
	
	

}
