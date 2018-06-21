package com.baishui.login;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


  import java.awt.Color;  
  import java.awt.Graphics2D;  
  import java.awt.image.BufferedImage;  
 
  
  import com.sun.image.codec.jpeg.JPEGCodec;  
  import com.sun.image.codec.jpeg.JPEGEncodeParam;  
  import com.sun.image.codec.jpeg.JPEGImageEncoder; 

  
public class CheckCoderTool extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CheckCoderTool() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		          response.setContentType("image/jpeg");  
		          String c = (String) request.getSession().getAttribute("c");  
		          if (c == null){
		        	  c = "";  
		          }
		          int width = c.length() * 8 + 10;  
		          int height = 16;  
		          int startX = 5;  
		          int startY = 12;  
		          BufferedImage bi = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);  
		          Graphics2D g = bi.createGraphics();  
		          g.setColor(Color.GREEN);  
		          g.setBackground(Color.black);  
		          g.clearRect(0, 0, width, height);  
		          g.drawString(c, startX, startY);  
		          JPEGImageEncoder encoder = null;  
		          JPEGEncodeParam param = null;  
		    
		          try {  
		              encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());  
		              param = encoder.getDefaultJPEGEncodeParam(bi);  
		              param.setQuality(0.9f, false);  
		              encoder.encode(bi);  
		          } catch (Exception e) {  
		              e.printStackTrace();  
		          } finally {  
		              bi = null;  
		              g = null;  
		              c = null;  
		              encoder = null;  
		              param = null;  
		          }  
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
