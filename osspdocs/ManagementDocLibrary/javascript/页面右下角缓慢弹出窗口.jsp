<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'msg1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 

  </head>
<script><!-- 
var oPopup = window.createPopup(); 
var popTop;  
function popmsg(msgstr){ 
    var winstr= " <table   style= 'border:   1   solid     #799ae1 '   width= '240 '   height= '172 '   border= '0 '   cellpadding= '0 '   cellspacing= '0 '> " 
           winstr+= " <tr> <td  height= '30 '>   </td> </tr> <tr> <td   align= 'center '> " 
           winstr+= " <table   width= '90% '   height= '110 '   border= '0 '   cellpadding= '0 '   cellspacing= '0 '> "; 
           winstr+= " <tr> <td   valign= 'top '   style= 'font-size:12px;   face:   Tahoma '> "+msgstr+ " </td> </tr> </table> </td> </tr> </table> "; 
           oPopup.document.body.innerHTML = winstr; 
       popshow(); 
      } 
function popshow(){ 
   //window.status=popTop; 
   if(popTop>1720){ 
     clearTimeout(mytime); 
     oPopup.hide();  
     return;  
   }else  if(popTop> 1520&&popTop <1720){ 
     //alert(popTop);
     oPopup.show(screen.width-250,screen.height,241,1720-popTop); //缓慢下降
   }else if(popTop> 1500&&popTop <1520){ 
     //alert(popTop);
     oPopup.show(screen.width-250,screen.height+(popTop-1720),241,172); //保持不动 
   }else if(popTop <180){ 
     // alert(popTop);
      oPopup.show(screen.width-250,screen.height,241,popTop); //缓慢上升
   }else if(popTop <220){  
   //  alert(popTop);
     oPopup.show(screen.width-250,screen.height-popTop,241,172);//保持不动 
    } 
     popTop+=10; 
    var mytime=setTimeout("popshow();",100); 
}  
function set(){
  popTop=50;  
}
function hiben(){
 oPopup.hide();
}
--></script>
<body> 
  <input type="button" onclick="set();popmsg('你有一条新信息请注意查收')" value="弹出">
  <input type="button" onclick="hiben();" value="隐藏">
  <table width="150" border="1">
  <tr><td>ss</td></tr>
  </table>
</body> 
</HTML> 
