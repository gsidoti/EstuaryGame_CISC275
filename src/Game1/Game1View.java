package Game1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import OverallGame.Window;
import OverallGame.gameObject;
import OverallGame.gameView;

/**
 * Game1View is the view of Game1 and it handles drawing all of the images and text on screen at every tick
 * 
 * @author Team 7
 * @version 5/17
 */

public class Game1View extends gameView{

	private int BkgOffset=0;
	private int dBkgOffset=1;
	int tick;
	double m;
	int tx;
	int ty;
	int i,j;
	int boatindex;
	int boatoffset;
    private int pos=0;

    /**
     * Constructor for Game1View objects
     */
	public Game1View()
	{
	    loadImages();	
	}

	/**
	 * Loads the needed images for the game
	 */
	public void loadImages(){
		createImage("can");
		createImage("exit");
		createImage("boat2");
		createImage("sea3");
		createImage("game1i");
	}

	/**
	 * Handles drawing all of the objects on screen at every tick.
	 * 
	 * @param g The graphics for the game
	 * @param objects The ArrayList of gameObjects in the game
	 */
	public void render(Graphics g, ArrayList<gameObject> objects){
		if(tick++%3 == 0)
			BkgOffset+=dBkgOffset;
		if(BkgOffset>10)
		{
			BkgOffset=10;
			dBkgOffset=-1;
		}
		if(BkgOffset<0)
		{
			BkgOffset=0;
			dBkgOffset=1;
		}
		g.drawImage(images.get("sea3"),0,0,(int)(Window.WIDTH*Window.SCALE),
				(int)(Window.HEIGHT*Window.SCALE),(int)(BkgOffset*Window.SCALE),
				0,(int)((1360.0+BkgOffset)*Window.SCALE),
				(int)(720*Window.SCALE),null); 
		if(!Game1.inst){
			for (i = 1; i < objects.size(); i++)
			{
				gameObject o =objects.get(i);
				if(o.name=="Trash")
				{
					g.setColor(Color.green);
					Trash temp = (Trash)(objects.get(i));
					if (temp.getActive()) {
						System.out.println(objects.get(i).name+"X: "+objects.get(i).getX()+" Y: "+ objects.get(i).getY()+objects.get(i).getVelx()+" "+ objects.get(i).getVely());
						//g.fillRect(objects.get(i).getX()-10,objects.get(i).getY()-10,20,20);
						g.drawImage(images.get("can"),objects.get(i).getX()-(int)(15*Window.SCALE),
								objects.get(i).getY()-(int)(15*Window.SCALE),(int)(30*Window.SCALE),
								(int)(30*Window.SCALE),null); 
					}
				}
				else if(o.name=="Score")
				{
				    Scoreboard tmp = (Scoreboard)(objects.get(i));
				    g.setColor( Color.RED );
				    g.setFont(new Font("TimesRoman", Font.PLAIN, scaleW(30)));
			        g.drawString( String.format( "High Score %s", tmp.getHi() ), (int)(30*Window.SCALE), (int)(30*Window.SCALE) );
				    g.setColor( Color.WHITE );
			        g.drawString( String.format( "Score %s", tmp.getScore() ), (int)(30*Window.SCALE), (int)(60*Window.SCALE) );
			        g.drawString( String.format( "Lives:"), (int)(30*Window.SCALE), (int)(90*Window.SCALE) );
			        for(j=0;j<tmp.getLives();j++)
			        {
			    		g.drawImage(images.get("boat2"),(int)((140+20*j)*Window.SCALE),(int)(65*Window.SCALE),
			    				(int)((170+20*j)*Window.SCALE),(int)(95*Window.SCALE),
			    				(int)(2700*Window.SCALE),0,(int)(2800*Window.SCALE),(int)(110*Window.SCALE),null); 		        	
			        }
				}
				else if(o.name=="Beached")
				{
					g.drawImage(images.get("can"),o.getX()-(int)(15*Window.SCALE),
							o.getY()-(int)(15*Window.SCALE),(int)(30*Window.SCALE),
							(int)(30*Window.SCALE),null); 
				}
			}
			// Now Player
			Player p = (Player)(objects.get(0));
	        tx=(int)p.getX();
	        ty=(int)p.getY();
	        m=p.getAngle();
	        m*=180.0/3.14159265359;
	        if(m<0)m+=360;
	        boatindex=(int)(m/10);
	        boatoffset=(int)(boatindex*100*Window.SCALE);
			g.drawImage(images.get("boat2"),tx-(int)(40*Window.SCALE),
					ty-(int)(40*Window.SCALE),tx+(int)(40*Window.SCALE),
					ty+(int)(40*Window.SCALE),(int)(boatoffset),0,
					(int)((boatoffset+100.0*Window.SCALE)),(int)(110*Window.SCALE),null); 
			g.setColor(Color.green);
			pos++;
			if(pos>(int)(Window.WIDTH*Window.SCALE)-20)pos=0;
		}else
			g.drawImage(images.get("game1i"), 0, 0, null);
		g.drawImage(images.get("exit"), scaleW(Window.WIDTH-85), scaleH(5), null);
	}
}
