package Game1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

import Game1.Player;
import Game1.Trash;
import Game2.Boat;
import Game4.G4Player;
import OverallGame.gameObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;

/**
 * Write a description of class GameOne here.
 * 
 * @author Jakub Simacek 
 * @version 0.1
 */

public class Game1 extends MouseAdapter {

    //private FrameRate frameRate;
    //private BufferStrategy bs;
    public boolean running = false;
    public boolean mousedown = false;
    int mx, my;
    int counter = 0;
    int lastTrash = 1;
    //private Thread gameThread;
    //private SimpleMouseInput mouse;
    // KeyboardInput keyboard;
    private Player player;
    //private Trash[] trash = new Trash[100];
    //private boolean[] trashactive=new boolean[100];
    private int maxtrash;
    private int maxvel;
    public Game1View view;
    
    private long Score;
    private long Lives;
    
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
   
    public Game1() {
    	int i;        
        Lives=10;
        maxvel=1;
        Random rand = new Random();
		objects.add( new Player("Player",(int)((Window.WIDTH/2)*Window.SCALE),(int)((Window.HEIGHT/2)*Window.SCALE),2,5));
        for(i=1;i<100;i++)
        	objects.add(new Trash("Trash "+i, 0, rand.nextInt((int)(Window.HEIGHT*Window.SCALE)), 20, 20));
        view = new Game1View();
    }
    
	public void mousePressed(MouseEvent e){
		mousedown = true;
		mx = e.getX();
		my = e.getY();
	}
	
	public void mouseReleased(MouseEvent e){
		mousedown = false;
	}
	
	private void updatePlayer(){
		Player p = (Player) (objects.get(0));
		if(mousedown)
			p.SetDest(mx, my);
		p.Move();
	}
	
	private void updateTrash(int index) {
		Player p = (Player)objects.get(0);
		Trash temp = (Trash)objects.get(index);
		if (temp.getActive())
			temp.Move();
		if (mouseOver(p.getX(),p.getY(),temp.getX(),temp.getY(),20,20)) {
				 temp.setActive(false);
		}
	}
	
	private void updateLives(){
		for (int i = 1; i < objects.size(); i++) {
			Trash temp = (Trash) objects.get(i);
			if (temp.MadeIt((int)(Window.WIDTH*Window.SCALE))&&temp.getActive()) {
				temp.setActive(false);
				Lives--;
				if (Lives <= 0) {
					resetGame();
				}
			}
		}
	}

	
	public void tick() {
		counter++;
		if (counter%10 == 0) {
			Trash temp = (Trash)objects.get(lastTrash);
			temp.setActive(true);
			objects.set(lastTrash, temp);
			if (lastTrash < 99)
				lastTrash++;
		}
		updatePlayer();
		for (int i = 1; i < objects.size(); i++) {
			updateTrash(i);
			updateLives();
			System.out.println("Trash: " + objects.size() + " Lives: " + Lives);
		}
	}
	
	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}
	
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
    
    private void resetGame() {
    	Random rand = new Random();
    	Lives = 10;
    	lastTrash = 1;
    	counter = 0;
    	for(int i=1;i<100;i++)
        	objects.set(i, new Trash(("Trash"+i), (int)(0 * Window.SCALE), 
        			(rand.nextInt((int)(Window.HEIGHT*Window.SCALE))), 2, 0));
    	running = false;
    	Controller.gameState = STATE.Menu;
    }

//    protected void createAndShowGUI() {
//        player = new Player(320,240,25.0);
//        Canvas canvas = new Canvas();
//        canvas.setSize( 640, 480 );
//        canvas.setBackground( Color.BLUE );
//        canvas.setIgnoreRepaint( true );
//        getContentPane().add( canvas );
//        setTitle( "Game One" );
//        setIgnoreRepaint( true );
//        pack();
//        // Add key listeners
//        keyboard = new KeyboardInput();
//        canvas.addKeyListener( keyboard );
//        // Add mouse listeners
//        mouse = new SimpleMouseInput();
//        canvas.addMouseListener( mouse );
//        canvas.addMouseMotionListener( mouse );
//        canvas.addMouseWheelListener( mouse );
//        setVisible( true );
//        canvas.createBufferStrategy( 2 );
//        bs = canvas.getBufferStrategy();
//        canvas.requestFocus();
//        player = new Player(320,240,5.0);
//        gameThread = new Thread( this );
//        gameThread.start();
//    }

//    public void run() {
//        running = true;
//        frameRate.initialize();
//        while( running ) {
//            gameLoop();
//        }
//    }
//
//    private void gameLoop() {
//        int i;
//        
//        processInput();
//        player.Move();
//        for(i=0;i<maxtrash;i++)
//        {
//            if(trashactive[i])
//            {
//                trash[i].Move();
//            }
//        }
//       
//        renderFrame();
//        
//        for(i=0;i<maxtrash;i++)
//        {
//            if(trashactive[i])
//            {
//                if(trash[i].MadeIt(640))
//                {
//                    trashactive[i]=false;
//                    Lives--;
//                    if(Lives<=0)System.exit( 0 );
//                }
//                else
//                {
//                    if(trash[i].IsCaught(player.getx(),player.gety()))
//                    {
//                        trashactive[i]=false;
//                        Score++;
//                        maxvel=1+(int)Score/10;
//                        if((Score%10)==1)maxtrash=(maxtrash<99)?maxtrash+1:100;
//                    }
//                }
//            }
//        }
//
//        for(i=0;i<maxtrash;i++)
//        {
//            if(!trashactive[i])
//            {
//                trash[i]=new Trash(480,maxvel);
//                trashactive[i]=true;
//                break;
//            }
//        }
//        
//        sleep( 40L );
//    }
//
//    private void renderFrame() {
//        do {
//            do {
//                Graphics g = null;
//                try {
//                    g = bs.getDrawGraphics();
//                    g.clearRect( 0, 0, getWidth(), getHeight() );
//                    render( g );
//                } finally {
//                    if( g != null ) {
//                        g.dispose();
//                    }
//                }
//            } while( bs.contentsRestored() );
//            bs.show();
//        } while( bs.contentsLost() );
//    }
//
//    private void sleep( long sleep ) {
//        try {
//            Thread.sleep( sleep );
//        } catch( InterruptedException ex ) { }
//    }
//
//    private void processInput() {
//        keyboard.poll();
//        mouse.poll();
//        if( keyboard.keyDownOnce( KeyEvent.VK_SPACE ) ) {
//            System.out.println("VK_SPACE");
//        }
//        // if button is pressed for first time,
//        // start drawing lines
//        if( mouse.buttonDownOnce( MouseEvent.BUTTON1 ) ) {
//            player.SetDest(mouse.getPosition().x,mouse.getPosition().y);
//        }
//    }
//
//    private void render( Graphics g ) {
//        int i;
//        
//        Color color = Color.WHITE;
//        g.setColor( color );
//        frameRate.calculate();
//        g.drawString( frameRate.getFrameRate(), 30, 30 );
//        g.drawString( "Use mouse to set Destination", 30, 45 );
//        g.drawString( String.format( "Score %s", Score ), 30, 60 );
//        g.drawString( String.format( "Lives %s", Lives ), 30, 75 );
//        g.drawString( mouse.getPosition().toString(), 30, 90 );
//        for(i=0;i<maxtrash;i++)
//        {
//            if(trashactive[i])
//            {
//                trash[i].Draw(g);
//            }
//        }
//            player.Draw(g);
//    }
//
//    protected void onWindowClosing() {
//        try {
//            running = false;
//            gameThread.join();
//        } catch( InterruptedException e ) {
//            e.printStackTrace();
//        }
//        System.exit( 0 );
//    }
//
//    public static void main( String[] args ) {
//
//        final GameOne app = new GameOne();
//
//        app.addWindowListener( new WindowAdapter() {
//            public void windowClosing( WindowEvent e ) {
//                app.onWindowClosing();
//            }
//        });
//        SwingUtilities.invokeLater( new Runnable() {
//            public void run() {
//                app.createAndShowGUI();
//            }
//        });
//    }
}