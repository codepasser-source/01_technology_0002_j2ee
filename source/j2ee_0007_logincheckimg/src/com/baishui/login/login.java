package com.baishui.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public login() {
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

		 this.doPost(request, response);
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

		 HttpSession session = request.getSession(); 
		          try{  
			          String checkCode = request.getParameter("check_code");  
			          if(checkCode==null || "".equals(checkCode)) {
			        	  System.out.println("ȱ����֤��");
			          }else{ 
			              String rightCheckCode = (String)session.getAttribute("c");  
			              if(!checkCode.equals(rightCheckCode)){
			        	     System.out.println("��֤�벻��ȷ��");  
			        	   }else{
			        		      System.out.println("��֤����ȷ");
			        		      System.out.println(request.getParameter("username"));
						          System.out.println(request.getParameter("password"));
			        	   } 
			          }
			         
			      } catch(Exception e){  
			            e.printStackTrace();
			      }finally{  
			         request.getRequestDispatcher("/index.jsp").forward(request, response);
			      }  
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