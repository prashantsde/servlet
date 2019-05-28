package com.servlet.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.test.model.BeerExpert;

public class BeerSelect extends HttpServlet {

	private static final long serialVersionUID = 453753504452646685L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Hello Hi This is my first servlet.");
		response.setContentType("text/html");
		String c = request.getParameter("color");
		String[] sizes = request.getParameterValues("sizes");
		for (String size : sizes) {
			System.out.println(size);
		}
		BeerExpert exp = new BeerExpert();
		List<String> brands = exp.getBeer(c);
		PrintWriter out = response.getWriter();
		out.println("Beer Selection Advice <br>.");
		if (null != brands && brands.size() > 0) {
			for (String b : brands) {
				out.println("<br> Got beer color " + b);
			}
		}
		
		System.out.println("Header user-agent: "+ request.getHeader("User-Agent"));
		System.out.println("Header host: "+ request.getHeader("host"));
		Cookie [] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName()+"  "+cookie.getMaxAge()+"  "+cookie.getValue()+"  "+cookie.getPath());
		}
		System.out.println(request.getMethod());
	}
}
