package OverallGame;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * gameView is an abstract class used as a mold for the view of each game
 * 
 * @author Team 7
 * @version 5/17
 */

public abstract class gameView {
	public Map<String,BufferedImage> images=  new HashMap<String, BufferedImage>();
	
	/**
	 * Loads the needed images for the game
	 */
	public abstract void loadImages();
	
	/**
	 * Reads in the filename of an image, pulls the image and resizes it with correct scaling, then adds it to the HashMap of images
	 * 
	 * @param imgName name of the image wanting to be loaded in
	 * @return Returns true if loading the image was successful, returns false if an exception was caught
	 */
    protected boolean createImage(String imgName){ 	
    	BufferedImage bufferedImage;
    	try {
    		if(new File("images/"+imgName+".png").exists())
        		bufferedImage = ImageIO.read(new File("images/"+imgName+".png"));
    		else	//this file path is used when a .jar is created
        		bufferedImage = ImageIO.read(new File(imgName+".png"));
    		images.put(imgName,resizeImg(bufferedImage,(int)Math.ceil((bufferedImage.getWidth()*Window.SCALE)),(int)Math.ceil((bufferedImage.getHeight()*Window.SCALE))));
    		return true; 
    	} catch (IOException e) {
    		System.out.println("Error at Image: "+imgName);
    		return false;
    		//e.printStackTrace();
    	}
    }
    
    /**
     * Resizes the image to the appropriate width and height using the scaling of the game window
     * 
     * @param img image being resized
     * @param newW width of image wanted
     * @param newH height of image wanted
     * @return Returns the image with new dimensions
     */
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
    
    /**
     * Takes the width of an image and scales it to the appropriate size for the current screen
     * 
     * @param x Width of image that needs to be scaled
     * @return Returns scaled width for image
     */
	public int scaleW(double x){
		return (int)(Window.SCALE*x);
	}
	
	/**
	 * Takes the height of an image and scales it to the appropriate size for the current screen
	 * 
	 * @param x Height of image that needs to be scaled
	 * @return Returns scaled height for image
	 */
	public int scaleH(double x){
		return (int)(Window.SCALE*x);
	}
}
