var xmlHttp ;

function start(){
   window.setInterval("getMsgBox()",1000*10); //设置十秒钟访问服务器资源
}   

function getMsgBox(){  
	
   var user_id = document.getElementById("user_id").value;//用户ID作为查询条件 向服务器端发送
   
  //1创建XMLHttpRequest 对象
  //需要针对IE和其他类型的浏览器建立这个对象的不同方式写不同的代码
  if(window.XMLHttpRequest){ 
	  //针对 FireFox Mozillar Opera Safari IE7 IE8
	 xmlHttp = new XMLHttpRequest(); 
	  //针对某些特定版本的mozillar浏览器的BUG进行验证
	  if(xmlHttp.overrideMimeType){
		  xmlHttp.overrideMimeType("text/xml");
	  }
  }else if(window.ActiveXObject){
	  //针对IE6 之前的版本
	  var activexName = ["MSXML2.XMLHTTP","Microsoft.XMLHTTP"];
	  for(var i=0;i<activexName.length;i++){
		  try{
			xmlHttp = new ActiveXObject(activexName[i]);
			  break;
		  }catch(e){ 
		  }
	  } 
  } 
  if(!xmlHttp){
	  alert("对不起，您的浏览器版本过低");
  }else{
	  //alert(xmlHttp.readyState); 
	  //2回调函数
	  xmlHttp.onreadystatechange = callback;
	  //3设置连接信息
	  //第三个参数是同步还是异步的方式 true表示异步 
	    
	  /*  4.发送数据，开始和服务器端进行交互
	    同步方式下send方法这句话在服务器端返回数据时执行完
	    异步方式下send方法这句话立即这行完 
      */ 
	  /*POST 方式实现 */
	  xmlHttp.open("POST", "AJAXServer",true);
	  xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
	  xmlHttp.send("user_id="+user_id);
  } 
} 
function callback(){
	/* 判断对象是否交互完成
	 * readyState：0-未初始化  1-open方法成功调用以后  2-服务器已经接收到请求  3- 交互中相应未接受 4-完成
	 * 当xmlHttp.readyState发生变化时 就会执行callback 方法
	*/
	 //alert(xmlHttp.readyState);
	  if(xmlHttp.readyState==4){
		  //判断http的交互是否成功
		  if(xmlHttp.status==200){
			  //获取服务端返回的数据
			  var responseText = xmlHttp.responseText; 
			  //获得msg_id 如果不为空则显示消息提示  
			   
			  if(responseText.length!=2){//当返回空串时为2
				  //alert(responseText);
				  reSetPopTop();
				  popmsg("你又一条消息请注意查收,msg_id="+responseText) //打开msgbox页面
			  } 
		  }
	  }
}

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
    
    popTop+=10; //调整每次上升的高度
    var mytime=setTimeout("popshow();",100); //调整每次上升的时间间隔
} 

//弹出消息
function reSetPopTop(){
  popTop=50;  
}

//隐藏消息
function hiben(){
 oPopup.hide();
}	
 


