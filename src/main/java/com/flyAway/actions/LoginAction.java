package com.flyAway.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.flyAway.DBConnection;

public class LoginAction implements Action {
	private HttpServletRequest request;

	public LoginAction(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void execute() {
		DBConnection db = null;
		Connection conn;
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			db = new DBConnection();
			conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			System.out.println("db row = " + rs.toString());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
