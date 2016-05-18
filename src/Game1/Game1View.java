package Game1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Game4.G4Player;
import OverallGame.Window;
import OverallGame.gameObject;
import OverallGame.gameView;

public class Game1View extends gameView{

	private int BkgOffset=0;
	private int dBkgOffset=1;

    private int[] dx=new int[5];
    private int[] dy=new int[5];
    private int pos=0;

	public Game1View()
	{
	    loadImages();	
	}

	public void loadImages(){
		createImage("can");
		createImage("exit");
		createImage("boat2");
		createImage("sea3");
		//images.put("can");
	}


	public void render(Graphics g, ArrayList<gameObject> objects){

		double m;
		double n;
		int tx;
		int ty;
		int i,j;
		int wy,wx;
		int boatindex;
		int boatoffset;
		
		Random rand = new Random();

		//fill screen background
		Player player = (Player) objects.get(0);
		//g.setColor(new Color(0,32,64));
		//g.fillRect(0, 0, (int)(Window.WIDTH*Window.SCALE)-20, (int)(Window.HEIGHT*Window.SCALE));
		//g.setColor(new Color(192,192,0));
		//g.fillRect((int)(Window.WIDTH*Window.SCALE)-20, 0, 20, (int)(Window.HEIGHT*Window.SCALE));

		//g.setColor(new Color(32,64,128));
		//g.drawLine(pos, 0, pos,(int)(Window.HEIGHT*Window.SCALE) );
		//for(i=pos-(int)(Window.WIDTH*Window.SCALE);i<(int)(Window.WIDTH*Window.SCALE)-20;i+=100)
		//{
			//g.drawLine(i, 0, i, (int)(Window.HEIGHT*Window.SCALE) );
		//}
		
		// Background
		
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
		
		

		//draw safe zone
		//g.setColor(Color.white);
		//g.fillRect(0,(int)(((Window.HEIGHT/2)-50)*Window.SCALE),(int) (Window.WIDTH*Window.SCALE),(int)(100*Window.SCALE) );
		//g.setColor(new Color(0f, .5f, 0f, .5f));//this would be the green zone
		//g.setColor(new Color(156, 93, 2));
		//g.fillRect(0,0,(int)(100*Window.SCALE),(int)(1000*Window.SCALE));
		//draw boats
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
			    g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
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
			    //g.setColor( Color.BLACK );
				//g.fillRect(o.getX()-10,o.getY()-10,20,20);
				g.drawImage(images.get("can"),o.getX()-(int)(15*Window.SCALE),
						o.getY()-(int)(15*Window.SCALE),(int)(30*Window.SCALE),
						(int)(30*Window.SCALE),null); 
			}
			g.drawImage(images.get("exit"), scaleW(Window.WIDTH-85), scaleH(5), null);
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
        
		//g.setColor(Color.red);
        //m=Math.cos(p.getAngle());
        //n=Math.sin(p.getAngle());
        //dx[0]=tx+(int)(30.0*m);
        //dy[0]=ty+(int)(30.0*n);
        //dx[1]=tx+(int)(10.0*m-10.0*n);
        //dy[1]=ty+(int)(10.0*n+10.0*m);
        //dx[2]=tx+(int)(-20.0*m-10.0*n);
        //dy[2]=ty+(int)(-20.0*n+10.0*m);
        //dx[3]=tx+(int)(-20.0*m+10.0*n);
        //dy[3]=ty+(int)(-20.0*n-10.0*m);
        //dx[4]=tx+(int)(10.0*m+10.0*n);
        //dy[4]=ty+(int)(10.0*n-10.0*m);
        //g.fillPolygon(dx, dy, 5);
        //g.setColor(Color.YELLOW);
        //g.drawPolygon(dx,dy,5);


		//g.fillRect(objects.get(0).getX(), objects.get(0).getY(), 30, 30);

		g.setColor(Color.green);
		//g.drawRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int) (150*Window.SCALE));
		//g.setColor(Color.red);
		//g.drawRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
		//.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));

		//draw score bar
		//g.setColor(Color.gray);
		//g.fillRect((int)((Window.WIDTH-150)*Window.SCALE),(int) (50*Window.SCALE),(int) (50*Window.SCALE),(int)((objects.get(1).getY()/10)*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE),(int)(objects.get(2).getY()/10*Window.SCALE));
		//g.fillRect((int)((Window.WIDTH-75)*Window.SCALE),(int)(50*Window.SCALE),(int) (50*Window.SCALE), (int)(150*Window.SCALE));
		pos++;
		if(pos>(int)(Window.WIDTH*Window.SCALE)-20)pos=0;
	}
}
