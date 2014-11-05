import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Arrays;

import javax.crypto.Cipher;

public abstract class User {


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

	protected User(String name, String password) {
		this.name = name;
		this.password = User.encrypt(password);
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
	
	public void setPassword(String password) {
		this.password = User.encrypt(password);
	}

}
