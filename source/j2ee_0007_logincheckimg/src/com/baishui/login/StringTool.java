package com.baishui.login;

import java.util.Random;

public class StringTool {

	    /** 
	     * ��������ַ���. <br> 
	      * ����ַ��������ݰ���[0-9]���ַ�. <br> 
	     *  
	       * @param randomLength 
	    *            ����ַ����ĳ��� 
	      * @return ����ַ���. 
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
