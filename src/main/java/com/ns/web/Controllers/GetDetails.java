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

import com.ns.web.Models.DatabaseActions;

/**
 * Servlet implementation class GetDetails
 */
@WebServlet("/GetDetails")
public class GetDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GetDetails.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = null;
		String firstnameDB = null;
		String lastnameDB = null;
		String emailDB = null;
		String passwordDB = null;
		String htmlContent = null;
		try {
			session = request.getSession();
			String firstname = (String) session.getAttribute("firstname");
			String emailID = (String) session.getAttribute("emailID");
			log.info("Fetching details of " + firstname + " from database");
			DatabaseActions sud = new DatabaseActions();
			ResultSet rs = sud.getUserDetails(emailID);

			while (rs.next()) {
				firstnameDB = (String) rs.getObject("firstname");
				lastnameDB = (String) rs.getObject("lastname");
				emailDB = (String) rs.getObject("emailid");
				passwordDB = (String) rs.getObject("password");
			}
			log.info("firstname : " + firstnameDB);
			log.info("lastname : " + lastnameDB);
			log.info("emqail ID : " + emailDB);
			log.info("password : " + passwordDB);
			
			htmlContent = "<div class=\"datalist\">"
							+ "<table>\r\n"
							+ "		<tbody>\r\n"
							+ "			<tr>\r\n"
							+ "				<td><p>First Name </p></td>\r\n"
							+ "				<td><p>"+firstnameDB+"</p></td>\r\n"
							+ "			</tr>\r\n"
							+ "			<tr>\r\n"
							+ "				<td><p>Last Name</p></td>\r\n"
							+ "				<td><p>"+lastnameDB+"</p></td>\r\n"
							+ "			</tr>\r\n"
							+ "			<tr>\r\n"
							+ "				<td><p>Email ID.</p></td>\r\n"
							+ "				<td><p>"+emailDB+"</p></td>\r\n"
							+ "			</tr>\r\n"
							+ "			<tr>\r\n"
							+ "				<td><p>Password </p></td>\r\n"
							+ "				<td><p>"+passwordDB+"</p></td>\r\n"
							+ "			</tr>\r\n"
							+ "		</tbody>\r\n"
							+ "	</table>"
							+ "</div>"
							+ "<div class=\"Form\">"
							+ "		<form method=\"post\" action=\"http://localhost:8080/sahu-webapp/GetDetails\">\r\n"
							+ "			<button type=\"submit\" value=\"Hide details\">Hide details</button>\r\n"
							+ "		</form>"
							+ "</div>";
			
			session.setAttribute("htmlContent", htmlContent);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		response.sendRedirect("jsp/Welcome.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("htmlContent", "");
		response.sendRedirect("jsp/Welcome.jsp");
		
	}

}
