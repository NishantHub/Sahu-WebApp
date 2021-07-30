package com.ns.web.Beans;

public class SignUpBean {
	
	private String firstName;
	private String lastName;
	private String emailID;
	private String password;
	
	public SignUpBean() {
		
	}
	public SignUpBean(String firstName, String lastName, String emailID, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
