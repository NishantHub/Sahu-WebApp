package com.ns.web.Models;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SahuWebAppDatabase {
	private static final Logger log = LoggerFactory.getLogger(SahuWebAppDatabase.class);
	Connection conn = null;
	public Connection getConnection() {
		String connURL = "jdbc:mysql://localhost:3306/sahuwebapp";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			log.info("Getting Database connection : " + connURL);
			conn = DriverManager.getConnection(connURL, "root", "Welcome1");
			log.info("Got the DB connection");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
