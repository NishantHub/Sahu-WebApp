package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainClass {
	
	static Connection conn = null;
	
	public static void main(String[] args) {
		String connURL = "jdbc:mysql://localhost:3306/sahuwebapp";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				conn = DriverManager.getConnection(connURL, "root", "Welcome1");
				
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from users where emailid = 'SRogers@webapp.com' ;");
				System.out.println("Query executed successfully");
				//System.out.println(rs.getObject("user_id"));
				while (rs.next()) {
					if(rs.getObject("Password")!="")
						System.out.println(rs.getObject("user_id"));
						System.out.println("Data : "+rs.getObject("firstname"));
				}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
