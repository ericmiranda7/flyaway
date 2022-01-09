package com.flyAway.actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyAway.data.RegistrationDetails;
import com.flyAway.data.RegistrationDetailsDAO;
import com.flyAway.data.RegistrationDetailsMySQLDAO;

public class RegisterAction extends AbstractAction {

	public RegisterAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void execute() {
		RegistrationDetailsDAO rdao = new RegistrationDetailsMySQLDAO();
		RegistrationDetails rd = new RegistrationDetails();

		rd.setFullName(request.getParameter("fullName"));
		rd.setAddress(request.getParameter("address"));
		rd.setAge(Integer.parseInt(request.getParameter("age")));
		rd.setMobile(request.getParameter("mobile"));
		rd.setUsername(request.getParameter("username"));
		rd.setIdType(Integer.parseInt(request.getParameter("idType")));
		rd.setCountry(request.getParameter("country"));
		rdao.insertDetails(rd);
		request.getSession().setAttribute("regDetails", rd);
		try {
			response.sendRedirect("/FlyAway/pages/review");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
