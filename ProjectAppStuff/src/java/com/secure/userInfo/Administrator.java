package com.secure.userInfo;
//no difference

public class Administrator extends Moderator {

	public static Administrator getInstance(String name, String password) {
		return new Administrator(name, password);
	}	

	protected Administrator(String name, String password) {
		super(name, password);
	}

	private Administrator() {
		super("root", "root"); // This is 'root' user
                //(take out the quotation marks once the 'root' user is actually defined
	}
	
	/*methods to add to Administrator:
	 * add app
	 * possibly has ability to restrict users if our customer wants us to
	 * allow this and if we have time*/

}