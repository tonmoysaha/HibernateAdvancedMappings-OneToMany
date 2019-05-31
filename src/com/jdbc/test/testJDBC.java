package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class testJDBC {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/one-to-many?useSSL=false";
		String uName = "hbstudent";
		String pass = "hbstudent";

		try {
			Connection conn = DriverManager.getConnection(jdbcURL, uName, pass);
			System.out.println("connection Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
