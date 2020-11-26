package model;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * 
 * @author Jhusseth
 *
 */
public class Firma {
	
	
	public Firma() {
		
	}
	
	
	/**
	 * 
	 * @param dataFile
	 * @param pvt
	 * @param signFile
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws SignatureException
	 * @throws IOException
	 * @throws InvalidKeySpecException
	 */
    public void signature(String dataFile, String pvt, String signFile)
            throws InvalidKeyException, NoSuchAlgorithmException, SignatureException, IOException, InvalidKeySpecException {
    	
    	Path path = Paths.get(pvt);
    	byte[] bytes = Files.readAllBytes(path);
    	 
    	PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
    	KeyFactory kf = KeyFactory.getInstance("RSA");
    	PrivateKey privateKey = kf.generatePrivate(ks);
    	
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        
        
        InputStream in = null;
        try {
            in = new FileInputStream(dataFile);
            byte[] buf = new byte[2048];
            int len;
            while ((len = in.read(buf)) != -1) {
            sign.update(buf, 0, len);
            }
        } finally {
            if ( in != null ) in.close();
        }
        
        OutputStream out = null;
        try {
            out = new FileOutputStream(signFile);
            byte[] signature = sign.sign();
            out.write(signature);
        } finally {
            if ( out != null ) out.close();
        }
    }
}