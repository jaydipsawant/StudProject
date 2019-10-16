package com.serv.mvc2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDBUtil studentdbutil;
	@Override
	public void init() throws ServletException {
		try {
			studentdbutil = new StudentDBUtil();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("inside doget");
			String check = request.getParameter("command");
			System.out.println(check);
			if (check == null) {
				check = "LIST";
			}
			switch (check) {

			case "LIST":
				liststud(request, response);
				break;

			case "ADD":
				addStudent(request, response);
				break;

			case "LOAD":
				loadStudent(request, response);
				break;
			case "UPDATE":
				updateStudent(request, response);
				break;
			default:  
				liststud(request, response);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id =Integer.parseInt(request.getParameter("id"));
		String fname= request.getParameter("firstname");
		String lname= request.getParameter("lastname");
		String email= request.getParameter("email");
		
		Student std=new Student(id, fname, lname, email);
		request.setAttribute("STUD_UPD",std );
		StudentDBUtil.updateStudent(std);
		liststud(request, response);
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int studId = Integer.parseInt(request.getParameter("studId"));
		Student std=StudentDBUtil.getStudent(studId);
		request.setAttribute("THE_STUD",std);
		RequestDispatcher rd =request.getRequestDispatcher("/Ex5-StudentApp/Update-stud-details.jsp");
		rd.forward(request, response);
		
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");

		Student thestud = new Student(id, fname, lname, email);
		StudentDBUtil.addSudent(thestud);
		liststud(request, response);
	}

	private void liststud(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Student> students = studentdbutil.getStudents();
		request.setAttribute("STUD_LIST", students);
		System.out.println("set");
		RequestDispatcher rd = request.getRequestDispatcher("/Ex5-StudentApp/list_students.jsp");
		rd.forward(request, response);
	}

}
