package com.baishui.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SayTag1X extends TagSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1796395046261729254L;

    @Override
    public int doEndTag() throws JspException {

        try {
            this.pageContext.getOut().write("taglib version 1.0");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doEndTag();
    }

}
