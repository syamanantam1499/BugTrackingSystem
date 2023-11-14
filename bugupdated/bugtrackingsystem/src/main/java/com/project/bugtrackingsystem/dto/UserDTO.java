package com.project.bugtrackingsystem.dto;

public class UserDTO {
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userContact;
	// Admin, Developer, TestEngineer
	private String userRole;
	
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserDTO(Integer userId, String userName, String userPassword, String userEmail, String userContact,String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userRole = userRole;
	}


	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}