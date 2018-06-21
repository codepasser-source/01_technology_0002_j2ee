package com.matt.damon.testpost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPost
 */
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public HeaderServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		getHeaderInfomation(request);

		getRequestBodyString(request);

		getCookie(request);
		setCookie(response);

		PrintWriter out = response.getWriter();
		out.write("{\"id\":1,\"name\":\"lis\"}");
		out.flush();
	}

	private void getHeaderInfomation(HttpServletRequest request) {
		Enumeration<String> headerNames = request.getHeaderNames();

		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			System.out.println("name:" + name + " ---- >"
					+ request.getHeader(name));
		}
	}

	private void getRequestBodyString(HttpServletRequest request) {
		BufferedReader br = null;
		try {
			br = request.getReader();
			String inputLine;
			StringBuffer requestBody = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				requestBody.append(inputLine);
			}
			System.out
					.println("request body content:" + requestBody.toString());
			br.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();// 这样便可以获取一个cookie数组
		if (cookies != null && cookies.length != 0) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();// get the cookie name
				String cookieValue = cookie.getValue(); // get the cookie value
				System.out.println("cookieName:" + cookieName + " ---- >"
						+ cookieValue);
			}
		}

	}

	private void setCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("cookiename", "cookievalue");
		cookie.setMaxAge(3600);

		response.addCookie(cookie);
	}
}
