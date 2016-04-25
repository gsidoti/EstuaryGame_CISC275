package game1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import util.*;
import javax.swing.*;

/**
 * Write a description of class GameOne here.
 * 
 * @author Jakub Simacek 
 * @version 0.1
 */

public class GameOne extends JFrame implements Runnable {

    private FrameRate frameRate;
    private BufferStrategy bs;
    public boolean running;
    private Thread gameThread;
    private SimpleMouseInput mouse;
    private KeyboardInput keyboard;
    private Player player;
    private Trash[] trash = new Trash[100];
    private boolean[] trashactive=new boolean[100];
    private int maxtrash;
    private int maxvel;
    
    private long Score;
    private long Lives;
   
    public GameOne() {
        int i;
        
        frameRate = new FrameRate();
        Score=0;
        Lives=10;
        maxtrash=4;
        maxvel=1;
        for(i=0;i<100;i++)
        {
            trash[i]=new Trash(480,1);
            trashactive[i]=false;
        }
    }

    protected void createAndShowGUI() {
        player = new Player(320,240,25.0);
        Canvas canvas = new Canvas();
        canvas.setSize( 640, 480 );
        canvas.setBackground( Color.BLUE );
        canvas.setIgnoreRepaint( true );
        getContentPane().add( canvas );
        setTitle( "Game One" );
        setIgnoreRepaint( true );
        pack();
        // Add key listeners
        keyboard = new KeyboardInput();
        canvas.addKeyListener( keyboard );
        // Add mouse listeners
        mouse = new SimpleMouseInput();
        canvas.addMouseListener( mouse );
        canvas.addMouseMotionListener( mouse );
        canvas.addMouseWheelListener( mouse );
        setVisible( true );
        canvas.createBufferStrategy( 2 );
        bs = canvas.getBufferStrategy();
        canvas.requestFocus();
        player = new Player(320,240,5.0);
        gameThread = new Thread( this );
        gameThread.start();
    }

    public void run() {
        running = true;
        frameRate.initialize();
        while( running ) {
            gameLoop();
        }
    }

    private void gameLoop() {
        int i;
        
        processInput();
        player.Move();
        for(i=0;i<maxtrash;i++)
        {
            if(trashactive[i])
            {
                trash[i].Move();
            }
        }
       
        renderFrame();
        
        for(i=0;i<maxtrash;i++)
        {
            if(trashactive[i])
            {
                if(trash[i].MadeIt(640))
                {
                    trashactive[i]=false;
                    Lives--;
                    if(Lives<=0)System.exit( 0 );
                }
                else
                {
                    if(trash[i].IsCaught(player.getx(),player.gety()))
                    {
                        trashactive[i]=false;
                        Score++;
                        maxvel=1+(int)Score/10;
                        if((Score%10)==1)maxtrash=(maxtrash<99)?maxtrash+1:100;
                    }
                }
            }
        }

        for(i=0;i<maxtrash;i++)
        {
            if(!trashactive[i])
            {
                trash[i]=new Trash(480,maxvel);
                trashactive[i]=true;
                break;
            }
        }
        
        sleep( 40L );
    }

    private void renderFrame() {
        do {
            do {
                Graphics g = null;
                try {
                    g = bs.getDrawGraphics();
                    g.clearRect( 0, 0, getWidth(), getHeight() );
                    render( g );
                } finally {
                    if( g != null ) {
                        g.dispose();
                    }
                }
            } while( bs.contentsRestored() );
            bs.show();
        } while( bs.contentsLost() );
    }

    private void sleep( long sleep ) {
        try {
            Thread.sleep( sleep );
        } catch( InterruptedException ex ) { }
    }

    private void processInput() {
        keyboard.poll();
        mouse.poll();
        if( keyboard.keyDownOnce( KeyEvent.VK_SPACE ) ) {
            System.out.println("VK_SPACE");
        }
        // if button is pressed for first time,
        // start drawing lines
        if( mouse.buttonDownOnce( MouseEvent.BUTTON1 ) ) {
            player.SetDest(mouse.getPosition().x,mouse.getPosition().y);
        }
    }

    private void render( Graphics g ) {
        int i;
        
        Color color = Color.WHITE;
        g.setColor( color );
        frameRate.calculate();
        g.drawString( frameRate.getFrameRate(), 30, 30 );
        g.drawString( "Use mouse to set Destination", 30, 45 );
        g.drawString( String.format( "Score %s", Score ), 30, 60 );
        g.drawString( String.format( "Lives %s", Lives ), 30, 75 );
        g.drawString( mouse.getPosition().toString(), 30, 90 );
        for(i=0;i<maxtrash;i++)
        {
            if(trashactive[i])
            {
                trash[i].Draw(g);
            }
        }
            player.Draw(g);
    }

    protected void onWindowClosing() {
        try {
            running = false;
            gameThread.join();
        } catch( InterruptedException e ) {
            e.printStackTrace();
        }
        System.exit( 0 );
    }

    public static void main( String[] args ) {

        final GameOne app = new GameOne();

        app.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
                app.onWindowClosing();
            }
        });
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                app.createAndShowGUI();
            }
        });
    }
}