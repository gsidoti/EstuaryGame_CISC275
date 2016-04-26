package Game2;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

import Game2.Boat;
import Game2.Game2View;
import Game4.G4Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import OverallGame.Controller;
import OverallGame.STATE;
import OverallGame.Window;
import OverallGame.gameObject;

/**
 * Write a description of class Game2 here.
 * 
 * @author Cody Fox
 * @version 0.1
 */

public class Game2 extends MouseAdapter {

    //private FrameRate frameRate;
    //private BufferStrategy bs;
    //public boolean running;
    //private Thread gameThread;
    //private SimpleMouseInput mouse;
    //private KeyboardInput keyboard;
    //private Player player;
    private int maxBoat;
    private int maxvel;
    private int mx, my;
	public boolean running = false;
	ArrayList<gameObject> objects = new ArrayList<gameObject>();
	
	public Game2View view;
	boolean mousedown = false;
    private long Score;
    private long Lives;
   
    public Game2() {
        int i;
        
        Score=0;
        Lives=10;
        maxBoat=4;
        maxvel=1;
        for(i=0;i<100;i++)
        	objects.add(new Boat(("Boat"+i), (int)(Window.WIDTH * Window.SCALE), (int)(Math.random()%Window.HEIGHT), 0, 0));
        view = new Game2View();
    }
    
	public void mousePressed(MouseEvent e){
		mousedown = true;
		mx = e.getX();
		my = e.getY();
	}
	
	public void mouseReleased(MouseEvent e){
		mousedown = false;
	}
	
	private void updateBoat(int index) {
		Boat b = (Boat)objects.get(index);
		if (mousedown) {
			if (b.IsCaught(mx, my)) {
				b.setInfested(false);
			}
		}
	}
	
	private void updateLives(){
		for (int i = 0; i < objects.size(); i++) {
			Boat b = (Boat) objects.get(i);
			if (b.getX() < Window.WIDTH) {
				b.setActive(false);
				Lives--;
			}
		}
	}
	
	public void tick() {
		for (int i = 0; i < objects.size(); i++)
			updateBoat(i);
		updateLives();
		System.out.println("Boats: " + objects.size() + " Lives: " + Lives);
	}
	
	public ArrayList<gameObject> getObjects(){
		return this.objects;
	}
}
//	
//	protected void createAndShowGUI() {
//  //      player = new Player(320,240,25.0);
//        Canvas canvas = new Canvas();
//        canvas.setSize( 640, 480 );
//        canvas.setBackground( Color.BLUE );
//        canvas.setIgnoreRepaint( true );
//        getContentPane().add( canvas );
//        setTitle( "Game 2" );
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
//        //player = new Player(320,240,5.0);
//        gameThread = new Thread( this );
//        gameThread.start();
//    }
//
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
////        player.Move();
//        for(i=0;i<maxBoat;i++)
//        {
//            if(Boatactive[i])
//            {
//                Boat[i].Move();
//            }
//        }
//       
//        renderFrame();
//        
//        for(i=0;i<maxBoat;i++)
//        {
//            if(Boatactive[i])
//            {
//                if(Boat[i].MadeIt(640))
//                {
//                    Boatactive[i]=false;
//                    Lives--;
//                    if(Lives<=0)System.exit( 0 );
//                }
//                else
//                {
////                    if(Boat[i].IsCaught(player.getx(),player.gety()))
//                    {
//                        Boatactive[i]=false;
//                        Score++;
//                        maxvel=1+(int)Score/10;
//                        if((Score%10)==1)maxBoat=(maxBoat<99)?maxBoat+1:100;
//                    }
//                }
//            }
//        }
//
//        for(i=0;i<maxBoat;i++)
//        {
//            if(!Boatactive[i])
//            {
//                Boat[i]=new Boat(480,maxvel);
//                Boatactive[i]=true;
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
//            //player.SetDest(mouse.getPosition().x,mouse.getPosition().y);
//        	// Need to add methods that check for collision with dirty Boat and sets to clean
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
//        for(i=0;i<maxBoat;i++)
//        {
//            if(Boatactive[i])
//            {
//                Boat[i].Draw(g);
//            }
//        }
//           // player.Draw(g);
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
//        final Game2 app = new Game2();
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
//}
