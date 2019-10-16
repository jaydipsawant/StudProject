package com.serv.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex4-HelloServlet/HelloServlet")   //from html
//@WebServlet("/HelloServlet") from jsp file

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HelloServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletContext sc=getServletContext();
		
		String name=sc.getInitParameter("FirstName");
		out.println("<html><body>");
		out.println(name);
		out.println("Please find entered data of students"+"<br/><br/>"+request.getParameter("sfirstname")+"     "+request.getParameter("slastname"));
		out.println("</body></html>");			
	}
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("Please find entered data of students"+"<br/><br/>"+request.getParameter("sfirstname")+"     "+request.getParameter("slastname"));
		out.println("</body></html>");			
		
	}*/
}
