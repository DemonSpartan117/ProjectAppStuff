
public class User {

	String name;
	private String password;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return new String(name);
	}

	public String getPassword() {
		return new String(password); // Needs encrypt/decrypt
	}

}
