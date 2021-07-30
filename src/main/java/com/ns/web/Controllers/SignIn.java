package com.ns.web.Controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ns.web.Beans.SignInBean;
import com.ns.web.Models.DatabaseActions;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(SignIn.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = null;
		HttpSession session = null;
		String firstnameDB = null;
		String emailDB = null;
		String passwordDB = null;
		// TODO Auto-generated method stub
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			SignInBean sib = new SignInBean();
			DatabaseActions sud = new DatabaseActions();
			sib.setEmailID(request.getParameter("Email ID."));
			sib.setPassword(request.getParameter("Password"));
			log.info("EmailID : " + sib.getEmailID());
			log.info("Password : " + sib.getPassword());

			if (sib.getEmailID() == "" || sib.getPassword() == "") {
				message = "Email ID. and password can not be empty.";
				session = request.getSession();
				session.setAttribute("message", message);
				response.sendRedirect("jsp/SignIn.jsp");
				
			} else {

				ResultSet rs = sud.getUserDetails(sib);

				while (rs.next()) {
					firstnameDB = (String) rs.getObject("firstname");
					emailDB = (String) rs.getObject("emailid");
					passwordDB = (String) rs.getObject("password");
				}
				log.info("firstname : " + firstnameDB);
				log.info("emqail ID : " + emailDB);
				log.info("password : " + passwordDB);

				if (sib.getEmailID().equalsIgnoreCase(emailDB) && sib.getPassword().equals(passwordDB)) {
					session = request.getSession();
					session.setAttribute("emailID", emailDB);
					session.setAttribute("firstname", firstnameDB);
					response.sendRedirect("jsp/Welcome.jsp");
					log.info(emailDB+" : has logged in successfully.");
				} else {
					message = "Email ID. or password is incorrect.";
					session = request.getSession();
					session.setAttribute("message", message);
					response.sendRedirect("jsp/SignIn.jsp");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
