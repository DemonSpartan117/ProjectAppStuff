package com.secure.userInfo;

public class Guest extends User {

	public static Guest getInstance() {
		return new Guest();
	}

	//additional instance variables go here
	
	public Guest() {
		super();
		// TODO add in a createUser method for the Guest so they can create an account
	}

}
