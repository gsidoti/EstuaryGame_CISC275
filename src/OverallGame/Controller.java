package OverallGame;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import Game4.Game4;
import Menu.Menu;
//import Game1.GameOne;
import Game2.Game2;



public class Controller extends Canvas{

	private static final long serialVersionUID = 1L;

	private Thread thread;
	private boolean running = false;
	
	private Menu menu;
	private Game4 game4;
//	private GameOne game1;
	private Game2 game2;
	private Window window;
	
	public static STATE gameState = STATE.Menu;

	private Controller(){
		window = new Window("Estuary Game",this);
		menu = new Menu(window);
//		game1 = new GameOne();
		game2 = new Game2();
		//game3 = new Game3();
		game4 = new Game4(WIDTH,HEIGHT);
		//this.addMouseListener(new MouseAdapter(){
		//	@Override
		//	public void mouseClicked
		//}
		this.start();
		this.run();
	}
	

	
	private synchronized void start(){
		thread = new Thread(String.valueOf(this));
		thread.start();
		running = true;	
	}
	
	private synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();	
		}
	}
	
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
	private void clearML(){
		for(MouseListener l:this.getMouseListeners()){
			this.removeMouseListener(l);
			 System.out.println("removing ml");
		}
	}
	
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
//		case Game1:
//			if(game1.running == false) {
	//			clearML();
//				System.out.println("setting game1 to running");
	//			game1.running = true;
//			}
//			break;
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
		}
	}
	
	
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
			menu.menuView.render(g);
			break;
		case Game1:
			break;
		case Game2:
			game2.view.render(g, game2.getObjects());
			break;
		case Game3:
			break;
		case Game4:
			game4.view.render(g,game4.getObjects());
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
