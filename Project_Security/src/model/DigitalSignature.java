package model;

import java.io.*;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;
import java.util.Base64.Decoder;

/**
 * 
 * @author Jhusseth
 *
 */
public class DigitalSignature {
	
	/**
	 * Answer for digital signarure
	 */
	private String answer;
	/**
	 * @Contructor of the creation of digital signature
	 */
	public DigitalSignature() {
		answer = "";
	}
	
	/**
	 * @description Verify the creation  of the digital signature 
	 * @param args
	 * @return answer if the digital signature is correct, return ok, otherwise not ok  
	 */
	public  void verifyDigitalSignature(String pbk, String fm, String dataFile ) {
		
			try {
				
				File f = new File(pbk);
		        FileInputStream fis = new FileInputStream(f);
		        DataInputStream dis = new DataInputStream(fis);
		        byte[] keyBytes = new byte[(int) f.length()];
		        dis.readFully(keyBytes);
		        dis.close();

		        String temp = new String(keyBytes);
		        String publicKeyPEM = temp.replace("-----BEGIN RSA PUBLIC KEY-----\n", "");
		        publicKeyPEM = publicKeyPEM.replace("\n-----END RSA PUBLIC KEY-----\n", "");


		        Decoder b64= Base64.getDecoder();
		        byte[] decoded = b64.decode(publicKeyPEM);

		        X509EncodedKeySpec spec =
		                new X509EncodedKeySpec(decoded);
		        KeyFactory kf = KeyFactory.getInstance("RSA");
		        PublicKey pubKey = kf.generatePublic(spec);
			
			
				FileInputStream sigfis = new FileInputStream(fm);
				byte[] sigToVerify = new byte[sigfis.available()]; 
				sigfis.read(sigToVerify);
				sigfis.close();
				
				
				Signature sig = Signature.getInstance("SHA256withRSA");
				
				
				sig.initVerify(pubKey);
				
				
				FileInputStream datafis = new FileInputStream(dataFile);
				BufferedInputStream bufin = new BufferedInputStream(datafis);
				
				byte[] buffer = new byte[1024];
				int len;
				while (bufin.available() != 0) {
				    len = bufin.read(buffer);
				    sig.update(buffer, 0, len);
				};
	
				bufin.close();
			
			
			
			boolean verifies = sig.verify(sigToVerify);
			answer = "signature verifies: " + (verifies ? "OK" : "Not OK");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAnswer() {
		return answer;
	}
	
	
}

