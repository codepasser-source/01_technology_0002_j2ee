package com.baishui.tag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DynaTag extends SimpleTagSupport implements DynamicAttributes{

    private ArrayList<String> keys = new ArrayList<String>();
    private ArrayList<Object> values = new ArrayList<Object>();
    @Override
    public void setDynamicAttribute(String url, String key , Object value)
            throws JspException {
        this.keys.add(key);
        this.values.add(value);
    }
    @Override
    public void doTag() throws JspException, IOException {

          JspWriter out = this.getJspContext().getOut();
          out.println("<ol>");
          for (String key : keys) {
            Object value = values.get(keys.indexOf(key));
            out.println("<li>"+key+" = " + value +"</li>");
          }
          out.println("</ol>");
    }

    
}
