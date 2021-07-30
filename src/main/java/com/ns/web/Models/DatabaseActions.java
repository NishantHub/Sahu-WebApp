package com.ns.web.Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ns.web.Beans.SignInBean;
import com.ns.web.Beans.SignUpBean;

public class DatabaseActions {
	
	String message = null;
	private static final Logger log = LoggerFactory.getLogger(DatabaseActions.class);

	public String insertUser(SignUpBean sub) {
		String query = "insert into users (firstname,lastname,emailid,password) values ('"+sub.getFirstName()+"','"+sub.getLastName()+"','"+sub.getEmailID()+"','"+sub.getPassword()+"');"; 
		
		try {
			SahuWebAppDatabase wdb = new SahuWebAppDatabase();
			Connection conn = wdb.getConnection();

			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			log.info("Query executed successfully");
			message = "Great! Your account is created, go to 'Home/Sign In' page to login.";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	public ResultSet getUserDetails(SignInBean sib) {
		ResultSet rs = null;
		String query = "Select * from users where emailid = '"+sib.getEmailID()+"';";
		log.info("Fetching user details.");
		log.info("query : "+query);
		
		try {
			SahuWebAppDatabase wdb = new SahuWebAppDatabase();
			Connection conn = wdb.getConnection();

			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			log.info("Query executed successfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getUserDetails(String emailID) {
		ResultSet rs = null;
		String query = "Select * from users where emailid = '"+emailID+"';";
		log.info("Fetching user details.");
		log.info("query : "+query);
		
		try {
			SahuWebAppDatabase wdb = new SahuWebAppDatabase();
			Connection conn = wdb.getConnection();

			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			log.info("Query executed successfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
