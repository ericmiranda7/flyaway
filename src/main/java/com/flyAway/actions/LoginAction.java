package com.flyAway.actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyAway.DBConnection;
import com.flyAway.domain.User;

public class LoginAction extends AbstractAction implements Action {

	public LoginAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void execute() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		try {
			db = new DBConnection();
			conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				session.setAttribute("result", "error");
			} else {
				User user = new User(username, password, "1".equals(rs.getString(3)));
				session.setAttribute("auth", user);
				session.removeAttribute("result");
			}
			response.sendRedirect("/FlyAway/");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
