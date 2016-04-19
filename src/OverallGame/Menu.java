package OverallGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Menu extends MouseAdapter {
	JFrame frame;
	MenuView menuView;
	STATE gameState = STATE.Menu;
	
	public Menu(JFrame frame){
		this.frame = frame;
		menuView = new MenuView(frame);
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx,my,(frame.getWidth()/10)*2,(frame.getHeight()/10)*2,200,200)){
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
