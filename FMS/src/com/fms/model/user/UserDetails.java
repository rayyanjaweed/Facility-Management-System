package com.fms.model.user;

public class UserDetails {

	private int userID;
	
	private String emailID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobNumber;
	
	public UserDetails(String emailID, String firstName, String middleName,
			String lastName, String mobNumber, int userID) {
		super();
		this.emailID = emailID;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobNumber = mobNumber;
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}

	public String getEmailID() {
		return emailID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobNumber() {
		return mobNumber;
	}
	
	
}
