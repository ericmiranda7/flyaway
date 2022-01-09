package com.flyAway.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flyAway.DBConnection;

public class RegistrationDetailsMySQLDAO implements RegistrationDetailsDAO {

	@Override
	public boolean insertDetails(RegistrationDetails rd) {
		DBConnection db = null;

		try {
			db = new DBConnection();
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO registration VALUES(" + "?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, rd.getFullName());
			ps.setString(2, rd.getAddress());
			ps.setInt(3, rd.getAge());
			ps.setString(4, rd.getMobile());
			ps.setString(5, rd.getUsername());
			ps.setInt(6, rd.getIdType());
			ps.setString(7, rd.getCountry());

			ps.execute();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}

}
