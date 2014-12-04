package com.secure.userInfo;

import com.App;

public class Guest extends User {

	public static Guest getInstance() {
		return new Guest();
	}

	//additional instance variables go here
	
	protected Guest() {
		super();
		// TODO add in a createUser method for the Guest so they can create an account
	}
        
        @Override
        public void postComment(App app, String comment) {
            /*have the User be promped to create an account or login*/
        }
}
