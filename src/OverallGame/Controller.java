package OverallGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import Game2.Game2;
import Game3.Game3;
import Game4.Game4;
import Menu.Menu;
import Game1.Game1;

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
	private Game2 game2;
	private Game3 game3;
	private Game4 game4;
	private Window window;

	public static STATE gameState = STATE.Menu;

	/**
	 * Constructor for Controller objects
	 */
	public Controller(){
		window = new Window("Estuary Game",this);
		menu = new Menu();
		game1 = new Game1();
		game2 = new Game2();
		game3 = new Game3();
		game4 = new Game4();
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
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				render();
				delta--;
			}					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
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
		case Game3:
			if(game3.running == false){
				clearML();
				this.addMouseListener(game3);
				System.out.println("setting game3 to running");
				game3.initialize();
			}else{
				game3.tick();
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
		default:
			break;
		}
	}
	

	/**
	 * Checks the gameState and depending on what it is, calls the appropriate game's render method.
	 */
	private void render(){
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
		case Game2:
			game2.view.render(g, game2.getObjects());
			break;
		case Game3:
			game3.view.render(g, game3.getObjects());
			break;
		case Game4:
			game4.view.render(g,game4.getObjects());
			break;
		default:
			break;
		}
		g.setColor(Color.black);
		g.fillRect(0,(int)(Window.HEIGHT*Window.SCALE),window.screenDimension.width,window.screenDimension.height-(int)(Window.HEIGHT*Window.SCALE));
		g.dispose();
		bs.show();
	}

	
	public static void main(String[] args) {
		new Controller(); 
	}

}

class scale{

}
