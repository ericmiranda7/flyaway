package com.flyAway.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flyAway.DBConnection;

public class IDTypeMySQLDAO implements IDTypeDAO {

	@Override
	public List<IDType> findAll() {
		List<IDType> ids = new ArrayList<>();
		DBConnection db = null;
		Connection conn;
		try {
			db = new DBConnection();
			conn = db.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM idtypes");

			while (rs.next()) {
				IDType id = new IDType();
				id.setId(rs.getInt(1));
				id.setType(rs.getString(2));
				ids.add(id);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ids;
	}

}
