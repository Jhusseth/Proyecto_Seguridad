package model;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.Base64;

/**
 * 
 * @author Jhusseth
 *
 */
public class ExportKey {
	
	/**
	 * key generator 
	 */
	private KeyGenerator keyGenerator;
	
	/**
	 * 
	 */
	private String message;
	
	public ExportKey() {
		keyGenerator = new KeyGenerator();
		message = "";
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void generateFiles(String ruta) throws IOException {
		
		KeyPair keyPair = keyGenerator.generateKeys();
   
        Base64.Encoder encoder = Base64.getEncoder();
        message +="~/ Formato llave privada: "+keyPair.getPrivate().getFormat() + "\n";
        
        byte[] publicKey = keyPair.getPublic().getEncoded();
        message +="~/ Formato llave publica: "+keyPair.getPublic().getFormat() + "\n";
        
        Writer outPublic = new FileWriter(ruta +"/public" + ".pub");
        outPublic.write("-----BEGIN RSA PUBLIC KEY-----\n");
        outPublic.write(encoder.encodeToString(publicKey));
        outPublic.write("\n-----END RSA PUBLIC KEY-----\n");
        outPublic.close();
        
        PrivateKey pvt = keyPair.getPrivate();
        FileOutputStream out = new FileOutputStream(ruta + "/private" + ".key");
        out.write(pvt.getEncoded());
        out.close();
	}

	public String getMessage() {
		return message;
	}
}
