package com.baishui.listener;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @SuppressWarnings("unchecked")
    @Override
    public void sessionCreated(HttpSessionEvent sessionEv) {
        HttpSession session = sessionEv.getSession();
        String sessionID = session.getId();
        ServletContext application = session.getServletContext();
        Map<String, String> online = null;
        if (session.isNew()) {
            online = (Map<String, String>) application.getAttribute("online");
            if (online == null) {
                online = new Hashtable<String, String>();
            }
            String userName = (String) session.getAttribute("loginUser");
            userName = (userName == null) ? "游客" + sessionID : userName;
            online.put(sessionID, userName);
        }
        application.setAttribute("online", online);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEv) {
        HttpSession session = sessionEv.getSession();
        String sessionID = session.getId();
        ServletContext application = session.getServletContext();
        Map<String, String> online = (Map<String, String>) application
                .getAttribute("online");
        if (online != null) {
            online.remove(sessionID);
        }
        application.setAttribute("online", online);
    }

}
