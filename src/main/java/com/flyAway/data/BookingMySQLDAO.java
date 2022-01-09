package com.flyAway.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flyAway.DBConnection;

public class BookingMySQLDAO implements BookingDAO {

	@Override
	public boolean insertBooking(Booking booking) {
		DBConnection db = null;

		try {
			db = new DBConnection();
			Connection conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO booking(username, flightNumber) VALUES(?, ?)");
			ps.setString(1, booking.getUsername());
			ps.setInt(2, booking.getFlightNumber());
			return ps.execute();

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
