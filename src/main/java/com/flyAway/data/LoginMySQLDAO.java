package com.flyAway.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flyAway.DBConnection;
import com.flyAway.domain.User;

public class LoginMySQLDAO implements LoginDAO {

	@Override
	public void updatePassword(User user) {
		DBConnection db;

		try {
			db = new DBConnection();
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE login SET password = ? WHERE username = ?");
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUsername());
			ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
