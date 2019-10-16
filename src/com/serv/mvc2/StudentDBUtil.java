package com.serv.mvc2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class StudentDBUtil {
	public List<Student> getStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		Connection myconn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
			ds.setURL("jdbc:oracle:thin:@localhost:1521:ORCL");
			ds.setUser("system");
			ds.setPassword("sadmin@12");
			PooledConnection pc = ds.getPooledConnection();
			myconn = ds.getConnection();
			String sql = "select * from student";
			stmt = myconn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				// System.out.println(id + "" + first_name + "" + last_name + "" + email);
				Student tempstud = new Student(id, first_name, last_name, email);
				students.add(tempstud);

			}
		} catch (Exception e) {
			System.out.println("Exception in add" + e.getMessage());
		} finally {
			if (myconn != null)
				myconn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
		return students;
	}

	public static void addSudent(Student thestud) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		DBConnection con = new DBConnection();

		try {
			myConn = con.dbConnection();
			String sql = "insert into student " + "(id,first_name, last_name, email) " + "values (?, ?, ?,?)";
			myStmt = myConn.prepareStatement(sql);

			// set the param values for the student
			myStmt.setInt(1, thestud.getId());
			myStmt.setString(2, thestud.getFirstname());
			myStmt.setString(3, thestud.getLastname());
			myStmt.setString(4, thestud.getEmail());

			// execute sql insert
			myStmt.execute();
		} catch (Exception e) {
			System.out.println("Exception in add" + e.getMessage());
		}
	}
	public static Student getStudent(Integer studId) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		DBConnection con = new DBConnection();

		ResultSet rs = null;
		Student thestud = null;
		try {
			myConn = con.dbConnection();
			String sql = "select * from student where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, studId);
			rs = myStmt.executeQuery();
			if (rs.next()) {
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String email = rs.getString("email");
				thestud = new Student(studId, fname, lname, email);
			} else {
				throw new Exception("ID not found");
			}
			
		}
		catch (Exception e) {
			System.out.println("SQL Execetion in get: " + e.toString());
		}return thestud;
	}
	public static void updateStudent(Student std) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		DBConnection con = new DBConnection();

		try {
			myConn = con.dbConnection();
			String sql = " update student " + "set id=?, first_name=?, last_name=?, email=?" + "where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, std.getId());
			myStmt.setString(2, std.getFirstname());
			myStmt.setString(3, std.getLastname());
			myStmt.setString(4, std.getEmail());
			myStmt.setInt(5, std.getId());
			myStmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SQL Execetion: " + e.toString());
		}
	}
}
