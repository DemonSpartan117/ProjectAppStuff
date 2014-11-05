
public class Moderator extends User{

	public static Moderator getInstance(String name, String password) {
		return new Moderator(name, password);
	}
	
	protected Moderator(String name, String password) {
		super(name, password);
		// TODO Add in things important for Moderator objects
	}
	
	/* methods to make for the Moderator class:
	 * remove content (for the forums)
	 * */
}
