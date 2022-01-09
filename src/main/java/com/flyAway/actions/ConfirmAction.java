package com.flyAway.actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyAway.data.Booking;
import com.flyAway.data.BookingDAO;
import com.flyAway.data.BookingMySQLDAO;
import com.flyAway.domain.Flight;
import com.flyAway.domain.User;

public class ConfirmAction extends AbstractAction implements Action {

	public ConfirmAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void execute() {
		Flight flight = (Flight) request.getSession().getAttribute("flight");
		Booking booking = new Booking();
		booking.setFlightNumber(flight.getNumber());
		booking.setUsername(((User) request.getSession().getAttribute("auth")).getUsername());
		BookingDAO bd = new BookingMySQLDAO();
		bd.insertBooking(booking);
		request.getSession().setAttribute("booking", booking);
		try {
			response.sendRedirect("/FlyAway/pages/confirm");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
