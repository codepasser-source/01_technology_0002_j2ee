


$(document).ready(function (){
	
	var pw = $("#password"); 
	pw.keyup(function (event){
		//var myEvent = event || window.event; 
		//alert(pw.val());
		 passwordPower(pw.val()); 
	}); 
})

function Evaluate(word){
    return word.replace(/^(?:([a-z])|([A-Z])|([0-9])|(.)){5,}|(.)+$/g, "$1$2$3$4$5").length;
}


function passwordPower(word){ 
/**
 * 把密码强度分为四等:
　　1. 密码长度小于或等于四位.或者密码只有一种组合
    2. 密码长度大于四位, 且有两种组合
　　3. 密码长度大于四位, 且有三种组合
    4. 密码长度大于四位, 且有四种组合
 */  
	var power = Evaluate(word);
	var powerNode = $("#power");
	//alert(power)
	switch (power) {
	case 1:
		powerNode.css("display","block");
		powerNode.text("很弱"); 
		powerNode.css("border-color","#ee0055").css("color","#ee0055"); 
		powerNode.fadeIn("slow");//淡入淡出
		break;
    case 2:
    	powerNode.css("display","block");
    	powerNode.text("较弱");
    	powerNode.css("border-color","#ee8855").css("color","#ee8855");
    	powerNode.fadeIn("slow");
		break;
    case 3:
    	powerNode.css("display","block");
    	powerNode.text("较强");
    	powerNode.css("border-color","#eedd55").css("color","#eedd55");
    	powerNode.fadeIn("slow");
		break;
    case 4:
    	powerNode.css("display","block");
    	powerNode.text("安全");
    	powerNode.css("border-color","#ddff33").css("color","#ddff33");
    	powerNode.fadeIn("slow");
	    break;
	default:
		//powerNode.hide("slow"); 
		powerNode.fadeOut("slow");
		break;
	}
	 
}