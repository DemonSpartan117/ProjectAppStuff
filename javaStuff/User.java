import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Arrays;

import javax.crypto.Cipher;

public abstract class User {

	//TODO: please add in some notes for those of us unfamiliar with Java encryption
	private static KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	private static KeyPair rsaPair = keyGen.generateKeyPair();
	private static Cipher cipher = Cipher.getInstance("RSA");

	private static String encrypt(String password) {
		cipher.init(Cipher.ENCRYPT_MODE, rsaPair.getPublic());
		byte[] encryptedBytes = cipher.doFinal(password.getBytes());
		return new String(encryptedBytes);
	}

	private static String decrypt(String password) {
		cipher.init(Cipher.DECRYPT_MODE, rsaPair.getPrivate());
		byte[] decryptedBytes = cipher.doFinal(password);
		return new String(decryptedBytes);
	}


	private String name;
	private String password;
	private boolean admin;
	

	//constructor for guests only.
	protected User() {
		this.name = Guest;
		this.password = "";
		this.admin = false;
	}

	protected User(String name, String password, boolean admin){
		this.name = name;
		this.password = User.encrypt(password);
		this.admin = admin;
	}

	public boolean isAdmin() {
		return this.admin;
	}

	public String getName() {
		return new String(name);
	}

	protected String getPassword() {
		return User.decrypt(password);
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password, String currentPassword) {
		if (! User.decrypt(this.password).equals(currentPassword)) {
			throw new IllegalArgumentException("Authentication failed");
		}
		this.password = User.encrypt(password);
	}

	/*methods for the Users
	 * post (all User objects except for Guests can do this)
	 * request app (all Users except Guest and possibly Administrator can do this)
	 * List to be continued*/
}
