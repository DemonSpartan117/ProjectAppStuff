package com.secure.userInfo;

public class User {


	private String name;
	private String password;
	private final boolean admin;
        private boolean moderator;
	

	//constructor for guests only.
	public User() {
		this.name = "Guest";
		this.password = "";
		this.admin = false;
	}

	protected User(String name, String password, boolean admin, boolean moderator){
		this.name = name;
		this.password = password;
		this.admin = admin;
                this.moderator = moderator;
	}

	public boolean isAdmin() {
		return this.admin;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	
	public void setName(String name) {
		this.name = name;
                //TODO: make sure no one else is using the name before setting the name
	}
	
	public void setPassword(String password, String currentPassword) {
		if (!(this.password).equals(currentPassword)) {
			throw new IllegalArgumentException("Authentication failed");
		}
		this.password = password;
	}
        
        public boolean isModerator() {
            return moderator;
        }

	/*methods for the Users
	 * post (all User objects except for Guests can do this)
	 * request app (all Users except Guest and possibly Administrator can do this)
	 * List to be continued*/
}
