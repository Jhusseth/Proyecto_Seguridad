package model;
import java.security.*;

/**
 * 
 * @author Jhusseth
 *
 */
public class KeyGenerator {

	/**
	 * 
	 */
	private KeyPairGenerator generator;
	
	/**
	 * @Constructor generator of keys
	 */
	public KeyGenerator() {
		
	}

	/**
	 * @description method for the generation of keys
	 * @return keiPair key wirh algorhitm RSA 2048
	 */
	public KeyPair generateKeys() {
		
		try {
			generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);
			KeyPair keyPair = generator.generateKeyPair();
			return keyPair;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}
