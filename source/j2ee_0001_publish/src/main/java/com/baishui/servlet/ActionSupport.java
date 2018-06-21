package com.baishui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
//@WebServlet("/ActionSupport")
public class ActionSupport extends HttpServlet {

    /**
     * UID
     */
    private static final long serialVersionUID = -4408821478669758453L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionSupport() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {


        String param = request.getParameter("username");
        System.out.println("param:"+param);
        request.getRequestDispatcher("index.jsp").forward(request,response );
    }

}
