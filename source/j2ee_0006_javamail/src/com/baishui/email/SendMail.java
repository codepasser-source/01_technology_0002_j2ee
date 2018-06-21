package com.baishui.email; 
import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendMail extends HttpServlet {  
	private static final long serialVersionUID = 1L; 
	public SendMail() {
		super();
	} 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log 
	} 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
	 this.doPost(request, response);
	} 
	
	/**
	 *1.引入  commons email jar  和  Javamail jar 
	 *2.接受页面参数 
	 * 
	 */ 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {  
		
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		
		String sendTo = request.getParameter("sendTo");
		String from = request.getParameter("from");
		String theme = request.getParameter("theme");
		String content = request.getParameter("content"); 
		
		System.out.println("sendTo:"+sendTo);
		System.out.println("from:"+from);
		System.out.println("theme:"+theme);
		System.out.println("content:"+content);

		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.sina.com");//利用 sina 免费的邮件服务器
		email.setAuthentication("baishui_c","4338568999q");//设置sina 的用户名和密码
		email.setCharset("UTF-8");//设置邮件内容编码格式
		try {
			
			email.addTo(sendTo);//设置收件人
			email.setFrom(from);//设置发件人 
			email.setSubject(theme);//设置主题
			email.setMsg(content); //设置内容
			email.send();//发送
			
			request.setAttribute("msg","邮件发送成功");
		} catch (EmailException e) {  
			e.printStackTrace();
			request.setAttribute("msg","邮件发送失败");
		} 
		request.getRequestDispatcher("/sendResult.jsp").forward(request, response);
	}  
	public void init() throws ServletException { 
	}
}
