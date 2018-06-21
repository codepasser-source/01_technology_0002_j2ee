package com.baishui.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UrlRewriteFilter implements javax.servlet.Filter{

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
       HttpServletRequest request = (HttpServletRequest) req;
       System.out.println(request.getRequestURI());
       System.out.println(request.getRequestURL());
       chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("UrlRewriteFilter init");
    }


}
