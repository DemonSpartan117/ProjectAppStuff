
public class Administrator extends Moderator {

	public static Administrator getInstance(String name, String password) {
		return new Administrator(name, password);
	}	

	protected Administrator(String name, String password) {
		super(name, password);
	}

	private Administrator() {
		super(root, root); // This is 'root' user
	}

}
