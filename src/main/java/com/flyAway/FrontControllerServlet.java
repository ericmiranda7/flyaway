package com.flyAway;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyAway.actions.Action;
import com.flyAway.actions.ChangePasswordAction;
import com.flyAway.actions.ConfirmAction;
import com.flyAway.actions.LoginAction;
import com.flyAway.actions.LogoutAction;
import com.flyAway.actions.RegisterAction;
import com.flyAway.actions.SearchAction;
import com.flyAway.data.StateDAO;
import com.flyAway.data.StateMySQLDAO;
import com.flyAway.domain.Flight;

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
					StateDAO sd = new StateMySQLDAO();
					request.getSession().setAttribute("states", sd.getAll());
					request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
				}
			} else if (path.equals("/results")) {
				request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
			} else if (path.equals("/flight")) {
				Map<Integer, Flight> flights = (Map<Integer, Flight>) request.getSession().getAttribute("flights");
				request.getSession().setAttribute("flight",
						flights.get(Integer.parseInt(request.getParameter("number"))));
				request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
			} else if (path.equals("/review")) {
				request.getRequestDispatcher("/WEB-INF/review.jsp").forward(request, response);
			} else if (path.equals("/pay")) {
				request.getRequestDispatcher("/WEB-INF/payment.jsp").forward(request, response);
			} else if (path.equals("/confirm")) {
				request.getRequestDispatcher("/WEB-INF/confirmed.jsp").forward(request, response);
			} else if (path.equals("/changepass")) {
				request.getRequestDispatcher("/WEB-INF/changepass.jsp").forward(request, response);
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
			} else if (path.equals("/register")) {
				Action registerAction = new RegisterAction(request, response);
				registerAction.execute();
			} else if (path.equals("/confirm")) {
				Action confirmAction = new ConfirmAction(request, response);
				confirmAction.execute();
			} else if (path.equals("/changepass")) {
				Action changePasswordAction = new ChangePasswordAction(request, response);
				changePasswordAction.execute();
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
