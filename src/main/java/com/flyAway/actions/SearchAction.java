package com.flyAway.actions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyAway.DBConnection;
import com.flyAway.domain.Flight;

public class SearchAction extends AbstractAction {

	public SearchAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void execute() {
		Flight searchFlight = new Flight();
		searchFlight.setTravelDate(LocalDate.parse(request.getParameter("date"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)));
		searchFlight.setFromCity(request.getParameter("fromCity"));
		searchFlight.setToCity(request.getParameter("toCity"));
		// TODO(): Set number of persons cross checked with available seats

		try {
			db = new DBConnection();
			conn = db.getConnection();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM flights WHERE travel_date = ?");
			ps.setDate(1, java.sql.Date.valueOf(searchFlight.getTravelDate()));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		} finally {
			try {
				db.closeConnection();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
