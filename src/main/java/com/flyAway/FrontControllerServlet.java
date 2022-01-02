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
import com.flyAway.actions.LogoutAction;
import com.flyAway.actions.SearchAction;

@WebServlet({ "/pages/*", "/action/*" })
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();
		HttpSession session = request.getSession(false);
		System.out.println("path is: " + request.getServletPath());

		if (request.getServletPath().equals("/pages")) {
			if (path.equals("/")) {
				if (session.getAttribute("auth") == null) {
					request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
				}
			}
		} else if (request.getServletPath().equals("/action")) {
			if (path.equals("/login")) {
				Action loginAction = new LoginAction(request, response);
				loginAction.execute();
			} else if (path.equals("/logout")) {
				Action logoutAction = new LogoutAction(request, response);
				logoutAction.execute();
			} else if (path.equals("/search")) {
				Action searchAction = new SearchAction(request, response);
				searchAction.execute();
			}
		} else {
			System.out.println("else");
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
