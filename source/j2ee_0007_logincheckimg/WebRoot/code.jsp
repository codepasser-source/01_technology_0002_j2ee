<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
  <%@ page import="java.util.Date"%>  
  <%@ page import="com.baishui.login.*"%>  
  
  
  
  <html>  
  <head>  
  <title>��¼����</title>  
  <meta http-equiv="Content-Type" content="text/html; charset=GB18030">  
 
  <script type="text/javascript">
    function getCheck(){
    	<%  
        response.setHeader("Cache-Control","no-cache");  
        response.setHeader("Expires","Thu,01 Jan 1970 00:00:01 GMT");  
        String checkCode = StringTool.randomChars(4);//������֤�� StringTool.randomChars(4)  
        session.setAttribute("c",checkCode);//��֤�����session��  
        long t = (new Date()).getTime();//ȷ��ÿ��ˢ�¶������µ���֤��ͼƬ  
        System.out.println(t);
        %>   
   }
  </script>
  
  </head>  
  <body topmargin="150px" leftmargin="20px" rightmargin="20px">  
  <form method="post" action="login">  
  <center><h2>��¼����</h2></center><br>  
  
  <table align="center" cellspacing="0" cellpadding="0" border="0" width="50%">
    <tr>
       <td> �˺�:</td>
       <td><input type="text" name="username" value="">  </td>
    </tr>
   <tr>
        <td>����:</td>
       <td><input type="password" name="password" value=""> </td>
   </tr>
  <tr>
      <td> ��֤��:</td>
       <td>
         <input type="text" name="check_code" value="" size=5>
         <IMG id="check_img" src="<%=request.getContextPath()%>/CheckCoderTool?t=<%=t%>" alt="��ѿ����ģ�λ����������ߵ���֤�����"> 
      </td>
   </tr> 
  <tr>
    <td colspan="2"><input type="submit" name="submit" class="buttonblue" value="��¼">  </td>
    <td></a></td>
  </tr>
     
       
  
  
  
  </table>  
  </form>  
  </body>  
  </html>  