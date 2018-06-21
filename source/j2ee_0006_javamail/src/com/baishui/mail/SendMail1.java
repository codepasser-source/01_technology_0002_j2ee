package com.baishui.mail;

import java.util.Properties;

import javax.mail.Message; 
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 /**
  * 
  * @author baishui
  *   
  * 邮件发送demo1  版本 1.0
  *  需要邮件服务器
  */
public class SendMail1 {
  public static void main(String[] args) {
	Properties props = new Properties(); 
	Session session = Session.getInstance(props,null);
	
	props.put("mali.host", "127.0.0.1"); //设置邮件服务器地址
	props.put("mail.trans", "smtp"); //设置邮件传输的协议 
	Message message = new MimeMessage(session);
	
	try {
		//设置发件人地址
		message.setFrom(new InternetAddress("239081196@qq.com")); 
		/** 邮件发送的方式
	     Message.RecipientType.TO  直接发送
	     Message.RecipientType.CC  抄送
	     Message.RecipientType.BCC 密送
	    */
		//设置收件人地址
	    message.setRecipient(Message.RecipientType.TO,new InternetAddress("239081195@qq.com"));
	    
	    //设置邮件主题
	    message.setSubject("你好吗？");
	    //设置邮件的内容
	    message.setText("祝你生日快乐");
	    //发送
	    Transport.send(message);
	    
	} catch (AddressException e) { 
		e.printStackTrace();
	} catch (MessagingException e) { 
		e.printStackTrace();
	}
  }
}
