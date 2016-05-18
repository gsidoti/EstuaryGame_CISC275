package OverallGame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import Game2.Game2;
import Game2.Game2i;
import Game3.Game3;
import Game3.Game3i;
import Game4.Game4;
import Game4.Game4i;
import Menu.Menu;
//import Game1.GameOne;
import Game1.Game1;
import Game1.Game1i;

/**
 * Controller handles everything that goes on in the game and minigames. It knows what is currently being run and printed on-screen,
 * and is the mediator between the minigames' object classes (Model) and view class (View).
 * 
 * @author Team 7
 * @version 5/17
 */

public class Controller extends Canvas{

	private static final long serialVersionUID = 1L;

	private Thread thread;
	public boolean running = false;

	private Menu menu;
	private Game1 game1;
	private Game1i game1i;
	private Game2 game2;
	private Game2i game2i;
	private Game3 game3;
	private Game3i game3i;
	private Game4 game4;
	private Game4i game4i;

	public static STATE gameState = STATE.Menu;

	/**
	 * Contructor for Controller objects
	 */
	public Controller(){
		Window w = new Window("Estuary Game",this);
		menu = new Menu();
		game1 = new Game1();
		game1i = new Game1i();
		game2 = new Game2();
		game2i = new Game2i();
		game3 = new Game3();
		game3i = new Game3i();
		game4 = new Game4();
		game4i = new Game4i();
		this.start();
		this.run();
	}

	/**
	 * Creates the thread and calls it's start method, then sets running to true.
	 */
	private synchronized void start(){
		thread = new Thread(String.valueOf(this));
		thread.start();
		running = true;	
	}

	/**
	 * Joins the thread back and sets running to false.
	 */
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();	
		}
	}

	/**
	 * Constantly called to make the game run at 60fps. Calls the tick and render methods
	 */
	private void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				render();
				updates++;
				frames++;
				delta--;
			}					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}
	
	/**
	 * Removes the mouse listeners from the controller
	 */
	private void clearML(){
		for(MouseListener l:this.getMouseListeners()){
			this.removeMouseListener(l);
			System.out.println("removing ml");
		}
	}

	/**
	 * Handles what methods are called every tick.
	 * Depending on what the controller's gameState is set to, clear any mouse listeners, add a new one for the corresponding game,
	 * then set that game's running variable to true and run the game. If the gameState's value's running variable is set to true, 
	 * call the game's tick method.
	 */
	private void tick(){
		
		switch(gameState){
		case Menu:
			if(menu.running == false){
				clearML();
				this.addMouseListener(menu);
				System.out.println("setting menu to running");
				menu.running = true;
				if(menu.returning == false){
					menu.initTime = System.currentTimeMillis()+7000;
					menu.returning = true;
				}
			}else{
				menu.tick();
			}
			break;
		case Game1:
			if(game1.running == false) {
				clearML();
				this.addMouseListener(game1);
				System.out.println("setting game1 to running");
				game1.running = true;
			}else{
				game1.tick();
			}
			break;
		case Game1i:
			if (game1i.running == false) {
				clearML();
				this.addMouseListener(game1i);
				System.out.println("setting game1i to running");
				game1i.running = true;
			}else{
				game1i.tick();
			}
			break;
		case Game2:
			if(game2.running == false){
				clearML();
				this.addMouseListener(game2);
				System.out.println("setting game2 to running");
				game2.running = true;
			}else{
				game2.tick();
			}
			break;
		case Game2i:
			if (game2i.running == false) {
				clearML();
				this.addMouseListener(game2i);
				System.out.println("setting game2i to running");
				game2i.running = true;
			}else{
				game2i.tick();
			}
			break;
		case Game3:
			if(game3.running == false){
				clearML();
				this.addMouseListener(game3);
				System.out.println("setting game4 to running");
				game3.running = true;
			}else{
				game3.tick();
			}
			break;
		case Game3i:
			if (game3i.running == false) {
				clearML();
				this.addMouseListener(game3i);
				System.out.println("setting game3i to running");
				game3i.running = true;
			}else{
				game3i.tick();
			}
			break;
		case Game4:
			if(game4.running == false){
				clearML();
				this.addMouseListener(game4);
				System.out.println("setting game4 to running");
				game4.running = true;
			}else{
				game4.tick();
			}
			break;
		case Game4i:
			if (game4i.running == false) {
				clearML();
				this.addMouseListener(game4i);
				System.out.println("setting game4i to running");
				game4i.running = true;
			}else{
				game4i.tick();
			}
			break;
		default:
			break;
		}
	}

	/**
	 * Checks the gameState and depending on what it is, calls the appropriate game's render method.
	 */
	private void render(){
		//System.out.println("Render");
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();	
		switch(gameState){
		case Menu:
			menu.menuView.render(g, menu.getObjects());
			break;
		case Game1:
			game1.view.render(g, game1.getObjects());
			break;
		case Game1i:
			game1i.game1iView.render(g);
			break;
		case Game2:
			game2.view.render(g, game2.getObjects());
			break;
		case Game2i:
			game2i.game2iView.render(g);
			break;
		case Game3:
			game3.view.render(g, game3.getObjects());
			break;
		case Game3i:
			game3i.game3iView.render(g);
			break;
		case Game4:
			game4.view.render(g,game4.getObjects());
			break;
		case Game4i:
			game4i.game4iView.render(g);
			break;
			default:
				break;
		}
		g.dispose();
		bs.show();
	}

	
	public static void main(String[] args) {
		new Controller(); 
	}

}

class scale{

}
