
public class Guest extends User {

	public static Guest getInstance() {
		return new Guest();
	}

	//additional instance variables go here
	
	protected Guest() {
		super(null, null);
		// TODO add in a createUser method for the Guest so they can create an account
	}

}
