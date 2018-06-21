package com.baishui.upload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
 

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpLoadAction extends HttpServlet {
 
	private static final long serialVersionUID = 1L;  
	private ServletContext sc; 
	private String savePath; 
	
	public UpLoadAction() {
		super();
	}

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8"); 
      String forward = "";
      
      //FileUpLoad api
      DiskFileItemFactory fileFactory = new DiskFileItemFactory();
      
      ServletFileUpload upload = new ServletFileUpload(fileFactory); 
      try {
	   List items =	upload.parseRequest(request); 
	   Iterator its = items.iterator(); //遍历
	   while(its.hasNext()){
		   FileItem item = (FileItem)its.next(); 
		   //判断是文件还是文本文字
		   if(item.isFormField()){//文字
			   String username =item.getString("UTF-8") ;//item.getFieldName()参数名
			   System.out.println("上传人："+username);
		   }else{//文件
			   if(item.getName()!=null&&!item.getName().equals("")){//判断是有确认上传文件
				   System.out.println("上传文件大小"+item.getSize());
				   System.out.println("上传文件类型"+item.getContentType());
				   System.out.println("上传文件名称"+item.getName());  //客户端路径和名称
				  //保存在硬盘上
				   File tempFile = new File(item.getName());
				   
			       // 保存文件夹不存在就自动创建： 
				   if(!new File(savePath).isDirectory()){ 
					   System.out.println("文件夹不存在，创建一个");
				       new File(savePath).mkdirs(); 
				   }
				   
				   File file = new File(savePath,tempFile.getName());//sc.getRealPath("/")tomcat根路径
			       //保存文件   
				   item.write(file);
				   request.setAttribute("msg","文件上传成功"); 
			   }else{
				   request.setAttribute("msg","没有选择文件上传"); 
			   }
		    }
	   }
	   
	   forward = "/upload_success.jsp";
	   
	  } catch (FileUploadException e) { 
		  System.out.println("FileUploadException");
		  request.setAttribute("msg","请求无法解析"); 
		  forward = "/error.jsp";
		  e.printStackTrace();
	  }catch (Exception e) {  
		  System.out.println("文件上传异常");
		  forward = "/error.jsp";
		  request.setAttribute("msg","文件上传失败"); 
		  e.printStackTrace(); 
	   }finally{
           request.getRequestDispatcher(forward).forward(request, response);
	   }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init(ServletConfig config) throws ServletException {
		 this.savePath = config.getInitParameter("savePath");
		 System.out.println("fileupload servlet init");
		 System.out.println("文件上传服务器地址： 服务器-"+this.savePath);
		 this.sc=config.getServletContext();
	}

}
