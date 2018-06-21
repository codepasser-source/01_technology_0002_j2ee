package com.baishui.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestImage {

	
	public static void main(String[] args) {
		
		
		   BufferedImage bi = new BufferedImage(100, 100,BufferedImage.TYPE_INT_BGR);  
	       Graphics2D g = bi.createGraphics();  
	       g.setBackground(Color.black); 
	       
	       g.setColor(Color.GREEN); 
	       for (int i = 0; i <= 50; i++) {
	    	   g.drawLine(i, i, 100-i, i);
		   }
	       
	       g.setColor(Color.blue); 
	       for (int i = 0; i <= 50; i++) {
	    	   g.drawLine(i,i,i,100-i);
		   }
	       
	       g.setColor(Color.yellow); 
	       for (int i = 0; i <= 50; i++) {
	    	   g.drawLine(i,100-i,100-i,100-i);
		   }
	       
	       g.setColor(Color.red); 
	       for (int i = 0; i <= 50; i++) {
	    	   g.drawLine(100-i,i,100-i,100-i);
		   }
	       
	       g.setColor(Color.white);
	       g.drawString("font", 10, 10);  
	   try {
		    File file =  new File("image.jpeg");
			ImageIO.write(bi, "jpeg", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	}
}
