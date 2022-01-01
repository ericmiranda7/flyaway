package com.flyAway;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyAway.actions.Action;
import com.flyAway.actions.LoginAction;

@WebServlet("/pages/*")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();
		HttpSession session = request.getSession(false);
		System.out.println("sysp " + path);

		if (path.equals("/")) {
			if (session.getAttribute("auth") == null)
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			else
				request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		} else if (path.startsWith("/action")) {
			String action = path.substring(9);
			switch (action) {
			case "login":
				Action loginAction = new LoginAction(request);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
