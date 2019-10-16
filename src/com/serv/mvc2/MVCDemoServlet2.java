package com.serv.mvc2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex4-HelloServlet/MVCDemoServlet2")
public class MVCDemoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	//	List<Student> stdData = StudentDBUtil.getStudents();
		//request.setAttribute("Student_Data", stdData);
		RequestDispatcher rd = request.getRequestDispatcher("/Ex4-HelloServlet/Student_view.jsp");
		rd.forward(request, response);
	}

}
