package com.ns.web.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ns.web.Beans.SignUpBean;
import com.ns.web.Models.DatabaseActions;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final Logger log = LoggerFactory.getLogger(SignUp.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = null;
		SignUpBean sub = new SignUpBean();
		DatabaseActions sud = new DatabaseActions();
		log.info("Getting parameters from web page and saving in sign up bean object.");
		sub.setFirstName(request.getParameter("First Name"));
		sub.setLastName(request.getParameter("Last Name"));
		sub.setEmailID(request.getParameter("Email ID"));
		sub.setPassword(request.getParameter("Password"));
		log.info("Parameters from web page are saved in sign up bean object.");
		log.info("FirstName : "+sub.getFirstName());
		log.info("LastName : "+sub.getLastName());
		log.info("Email ID. : "+sub.getEmailID());
		log.info("Password : "+sub.getPassword());
		
		if (sub.getFirstName() != "" && sub.getLastName() != "" && sub.getEmailID() != "" && sub.getPassword() != "") {
			log.info("Creating user");
			message = sud.insertUser(sub);
			log.info(message);
		}
		else {
			message = "All fields are required, please enter data in all the below fields to register.";
			log.info(message);
		}

		// out.println(message);
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		response.sendRedirect("jsp/SignUp.jsp");

		/**
		 * out.println("Data from sign up form : "); out.println(firstName);
		 * out.println(lastName); out.println(emailID); out.println(password);
		 */

	}

}
