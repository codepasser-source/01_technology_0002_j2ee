package com.baishui.download;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
 
import java.io.OutputStream;
import java.net.URL;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLoad extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		BufferedInputStream br =null;
		  OutputStream out =null;
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String filePath = "c:\\uploads\\1.txt";
			boolean isOnLine = false; 
			
			File f =new  File(filePath);
	         if  (!f.exists()) {
	            response.sendError(404,"File not found!" );
	             return ;
	        }
	         
	         br  =   new  BufferedInputStream( new  FileInputStream(f));
	         byte[] buf =new byte [1024];
	         int  len  =   0 ;

	        response.reset();  //  非常重要 
	        
	         if  (isOnLine) {  //  在线打开方式 
	            URL u  =   new  URL( "file:/// "   +  filePath);
	            response.setContentType(u.openConnection().getContentType());
	            response.setHeader( "Content-Disposition","inline;filename="+f.getName());
	             //  文件名应该编码成UTF-8 
	        }  else  {  //  纯下载方式 
	            response.setContentType( " application/x-msdownload " );
	            response.setHeader( "Content-Disposition","attachment;filename= "+f.getName());
	        }
	        
	         out  =  response.getOutputStream();
	         while  ((len = br.read(buf))>0){
	            out.write(buf,0,len); 
	         }
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
			  if(br!=null){ 
					br.close(); 
			    }
			  if(out!=null){
				out.close();
			 }
			}catch (IOException e) { 
				e.printStackTrace();
			}
		} 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}
}