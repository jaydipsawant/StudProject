package com.serv.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

/**
 * Servlet implementation class MVCDemoServlet
 */
@WebServlet("/MVCDemoServlet")
public class MVCDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MVCDemoServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] studnets = {"Lawasa","Akurdi","Lonavala"};
		request.setAttribute("Stud_obj_data", studnets);
		
		RequestDispatcher rd= request.getRequestDispatcher("/Ex4-HelloServlet/view_student.jsp");
		rd.forward(request, response);
	}

}
