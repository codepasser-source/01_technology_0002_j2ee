package com.baishui.login;

import java.util.Random;

public class StringTool {

	    /** 
	     * 生成随机字符串. <br> 
	      * 随机字符串的内容包含[0-9]的字符. <br> 
	     *  
	       * @param randomLength 
	    *            随机字符串的长度 
	      * @return 随机字符串. 
	        */  
	      public static String randomChars(int randomLength) {  
	           char[] randoms = { '0','1', '2', '3',  
	                  '4', '5', '6', '7', '8', '9' };  
	           Random random = new Random();  
	           StringBuffer ret = new StringBuffer();  
	           for (int i = 0; i < randomLength; i++) {  
	              ret.append(randoms[random.nextInt(randoms.length)]);  
	           }  
	             random = null;  
	             System.out.println(ret.toString());
	          return ret.toString();  
	      }  
}
