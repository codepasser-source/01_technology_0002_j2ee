package com.baishui.action;

import java.io.IOException;
 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminAction extends HttpServlet { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminAction() {
		super();
	} 
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		 this.doPost(request, response);
	} 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 String path = request.getContextPath();
         String uri =  request.getRequestURI();
         String url = request.getRequestURL().toString();
         
         System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());
         System.out.println("请求地址uri = "+uri);
         
         if(uri.equals(request.getContextPath()+"/add.do")){
        	 System.out.println("add");
         }else if(uri.equals(request.getContextPath()+"/delete.do")){
        	System.out.println("delete");
         }
         
        
        System.out.println( request.getParameter("name"));
         
	}

	 

}
