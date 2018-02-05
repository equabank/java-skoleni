package com.equabank.skoleni;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CheckEmailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Ahoj jsem tu");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/checkEmail.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		if (email == null) {
			throw new IllegalArgumentException("Email is emapy");
		}

		EmailResponse emailResponse = callService(email);
		req.setAttribute("emailResponse", emailResponse);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/checkEmailResult.jsp");
		requestDispatcher.forward(req, resp);
	}

	public EmailResponse callService(String email) throws ServletException {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("https://ajith-Verify-email-address-v1.p.mashape.com/varifyEmail?email=" + email + "");

			ClientResponse response = webResource.getRequestBuilder().header("Accept", "application/json")
					.header("X-Mashape-Key", "c1CZ2L4YdimshRiXqsgHuCoJXfI2p1N4RLOjsn2zYu6JrPnBF9")
					.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			return response.getEntity(EmailResponse.class);

		} catch (Exception e) {
			throw new ServletException(e.getMessage(), e);
		}

	}

}
