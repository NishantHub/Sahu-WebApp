package com.ns.web.Beans;

public class SignInBean {

	private String emailID;
	private String password;

	public SignInBean() {

	}

	public SignInBean(String emailID, String password) {
		super();
		this.emailID = emailID;
		this.password = password;
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
