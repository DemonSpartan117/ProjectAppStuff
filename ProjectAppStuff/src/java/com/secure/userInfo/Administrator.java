package com.secure.userInfo;
//no difference

import com.App;


public class Administrator extends Moderator {

	public static Administrator getInstance(String name, String password) {
		return new Administrator(name, password);
	}	

	public Administrator(String name, String password) {
		super(name, password, true);
	}

	public Administrator() {
		super("root", "root", true); // This is 'root' user
                //(take out the quotation marks once the 'root' user is actually defined
	}
        
        public void createAccount() {
            /* database stuff */
        }
	
        public App[] getAppsToAdd() {
            App[] list = new App[5]; //only here so code compiles
            //replace this as you see fit
            
            /* database stuff */
            return list;
        }
        
	/*methods to add to Administrator:
	 * add app
	 * possibly has ability to restrict users if our customer wants us to
	 * allow this and if we have time
         * get list of suggested apps to add to the database*/

}
