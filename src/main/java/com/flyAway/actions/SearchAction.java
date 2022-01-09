package com.flyAway.actions;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
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
		LocalDate travelDate = LocalDate.parse(request.getParameter("date"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH));
		int fromCity = Integer.parseInt(request.getParameter("fromCity"));
		int toCity = Integer.parseInt(request.getParameter("toCity"));
		int numPersons = Integer.parseInt(request.getParameter("noOfPersons"));
		System.out.println(numPersons);
		// TODO(): Set number of persons cross checked with available seats

		try {
			db = new DBConnection();
			conn = db.getConnection();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM flights WHERE travel_date = ? AND fromCity = ? AND toCity = ? AND seat_availability >= ?");
			ps.setDate(1, java.sql.Date.valueOf(travelDate));
			ps.setInt(2, fromCity);
			ps.setInt(3, toCity);
			ps.setInt(4, numPersons);
			ResultSet rs = ps.executeQuery();

			Map<Integer, Flight> flights = new HashMap<Integer, Flight>();

			while (rs.next()) {
				System.out.println("there is");
				Flight flight = new Flight();
				flight.setName(rs.getString(1));
				flight.setPrice(rs.getDouble(2));
				flight.setNumber(rs.getInt(3));
				flight.setFromCity(rs.getString(4));
				flight.setToCity(rs.getString(5));
				flight.setDepatureTime(LocalTime.parse(rs.getString(6)));
				flight.setArrivalTime(LocalTime.parse(rs.getString(7)));
				flight.setTotalSeats(rs.getInt(8));
				flight.setBookedSeats(rs.getInt(9));
				flight.setSeatAvailability(rs.getInt(10));
				flight.setTravelDate(LocalDate.parse(request.getParameter("date"),
						DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)));
				flight.setFlightClass(rs.getString(12));
				flights.put(flight.getNumber(), flight);
			}

			request.getSession().setAttribute("flights", flights);
			request.getSession().setAttribute("flightList", new ArrayList<>(flights.values()));
			try {
				request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
