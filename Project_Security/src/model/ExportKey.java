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
	
	
	public ExportKey() {
		keyGenerator = new KeyGenerator();
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void generateFiles(String ruta) throws IOException {
		
		KeyPair keyPair = keyGenerator.generateKeys();
//		String publicPath = "./prueba.pub";
//		String privatePath = "./private.txt";

//        File publicKeyFile = new File(publicPath);
//        File privateKeyFile = new File(privatePath);
   
        Base64.Encoder encoder = Base64.getEncoder();
        System.out.println("Formato privada: "+keyPair.getPrivate().getFormat());
        
        byte[] publicKey = keyPair.getPublic().getEncoded();
        System.out.println("Formato publica: "+keyPair.getPublic().getFormat());
        
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
}
