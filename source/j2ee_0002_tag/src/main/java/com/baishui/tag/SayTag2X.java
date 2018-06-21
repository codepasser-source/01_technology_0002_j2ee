package com.baishui.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SayTag2X extends SimpleTagSupport{

    private String url;
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void doTag() throws JspException, IOException {
        //super.doTag();
        this.getJspContext().getOut().write("taglib version 2.0 attribute:"+url);
    }

    
}
