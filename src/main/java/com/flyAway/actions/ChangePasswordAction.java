package com.flyAway.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyAway.data.LoginDAO;
import com.flyAway.data.LoginMySQLDAO;
import com.flyAway.domain.User;

public class ChangePasswordAction extends AbstractAction implements Action {

	public ChangePasswordAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void execute() {
		String oldPass = request.getParameter("oldpass");
		String newPass = request.getParameter("newpass");
		String confirmPass = request.getParameter("confirmpass");

		User user = (User) request.getSession().getAttribute("auth");

		if (!oldPass.equals(user.getPassword())) {
			request.getSession().setAttribute("result", "The old password is incorrect !");
		} else if (!newPass.equals(confirmPass)) {
			request.getSession().setAttribute("result", "The new passwords do not match !");
		} else {
			LoginDAO ld = new LoginMySQLDAO();
			ld.updatePassword(new User(user.getUsername(), newPass, true));
			request.getSession().setAttribute("result", "Passowrd successfully changed, please refresh and re-login !");
		}

		try {
			response.sendRedirect("/FlyAway/pages/changepass");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
