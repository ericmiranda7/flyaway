package com.flyAway.actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction extends AbstractAction {

	public LogoutAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void execute() {
		request.getSession().invalidate();
		
		try {
			response.sendRedirect("/FlyAway/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
