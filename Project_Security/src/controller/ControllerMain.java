package controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import model.DigitalSignature;
import model.ExportKey;
import model.Firma;

/**
 * 
 * @author Jhusseth
 *
 */
public class ControllerMain {
	
	/**
	 * link to model
	 */
	private DigitalSignature ds;
	private ExportKey ek;
	private Firma fm;
	
	private String message;
	
	public ControllerMain() {
		ds = new DigitalSignature();
		ek = new ExportKey();
		fm = new Firma();
	}
	
	
	public void createKeys(String ruta) {
		
		message = "----------------------------------------------------------------------------------------------------------------- \n" ;
		
		message +="~/ Generando archivos .... \n";
		try {
			ek.generateFiles(ruta);
		} catch (IOException e) {
			e.printStackTrace();
		}
		message +="~/ Archivos generados --> Ruta: "+ ruta + "\n";
		message +="~/ public.pub .... Ok \n ";
		message +="~/ private.key .... Ok \n";
		message +="----------------------------------------------------------------------------------------------------------------- \n" ;
	}
	
	public void signaturefile(String file,String kpv,String fileSave) {
		message ="----------------------------------------------------------------------------------------------------------------- \n" ;
		try {
			
			message +="~/ Firmando archivo .... \n";
			
			fm.signature(file, kpv, fileSave);
			message +="~/ El archivo se firmo correctamente \n ";
			message +="~/ Ruta del archivo firmado : " + fileSave + "\n";
			
			
		} catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException
				| IOException e) {
			e.printStackTrace();
			message +="~/ Se cancelo la firma del archivo \n";
		}
		message +="----------------------------------------------------------------------------------------------------------------- \n" ;
	}
	
	
	public void verifySignature(String pbk, String file, String dataFile) {
		
		message = "----------------------------------------------------------------------------------------------------------------- \n" ;
		
		message +="~/ Verificando archivo .... \n";
		
		ds.verifyDigitalSignature(pbk,file,dataFile);
		
		message +="~/ " + ds.getAnswer() + "\n";
		message +="~/ Ruta del archivo verificado : " + dataFile + "\n";
		
		message +="----------------------------------------------------------------------------------------------------------------- \n" ;
		
	}

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
