package OverallGame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;



public abstract class gameView {
	protected Map<String,BufferedImage> images=  new HashMap<String, BufferedImage>();
	
	public abstract void loadImages();
	
    protected boolean createImage(String imgName){ 	
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("images/"+imgName+".png"));
    		images.put(imgName,resizeImg(bufferedImage,(int)(bufferedImage.getWidth()*Window.SCALE),(int)(bufferedImage.getHeight()*Window.SCALE)));
    		return true; 
    	} catch (IOException e) {
    		System.out.println("Error at Image: "+imgName);
    		return false;
    		//e.printStackTrace();
    	}
    }
    
    
    public static BufferedImage resizeImg(BufferedImage img, int newW, int newH){
    int w = img.getWidth();
    int h = img.getHeight();
    BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
    Graphics2D g = dimg.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
    g.dispose();
    return dimg;      
   }
    
	public int scaleW(double x){
		return (int)(Window.SCALE*x);
	}
	
	public int scaleH(double x){
		return (int)(Window.SCALE*x);
	}
}
