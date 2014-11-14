package com.secure.userInfo;


public class Moderator extends User{

	public static Moderator getInstance(String name, String password) {
		return new Moderator(name, password);
	}
	
	protected Moderator(String name, String password) {
		super(name, password, false, true);
		// TODO Add in things important for Moderator objects
	}
        
        /**
         * This constructor is never to be actively used to make a Moderator object.
         * It is only here so that the subclass of Moderator can call this constructor
         * and have admin privilages
         * @param name
         * @param password
         * @param admin 
         */
        protected Moderator(String name, String password, boolean admin) {
            super(name, password, admin, true);
        }
	
	/* methods to make for the Moderator class:
	 * remove content (for the forums)
	 * */
}
