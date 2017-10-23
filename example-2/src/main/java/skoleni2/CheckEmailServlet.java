package skoleni2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckEmailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("ahoj", "Ahoj vzacny hoste");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/checkEmail.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		if (email.length() < 4) {
			req.setAttribute("emailResponse", "chyba");
		} else {
			req.setAttribute("emailResponse", "v poradku");
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/checkEmailResult.jsp");
		requestDispatcher.forward(req, resp);
	}

}
