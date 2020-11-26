package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.ControllerMain;

/**
 * 
 * @author Jhusseth
 *
 */
public class GUI_Main extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * relationship with the panel options
	 */
	private Panel_Options options;
	
	/**
	 * relationship with the panel answer
	 */
	private Panel_Answers answer;
	
	/**
	 * relationship with the panel banner
	 */
	private Panel_Banner banner;
	
	/**
	 * relationship with the panel about
	 */
	private Panel_About about;
	
	/**
	 * relationship with the controller
	 */
	private ControllerMain controller;

	public GUI_Main() {
		getContentPane().setBackground(Color.WHITE);
		
		setTitle("<< Digital Signature >>");
		setSize(650,466);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		
		//relations
		options = new Panel_Options(this);
		banner = new Panel_Banner();
		answer = new Panel_Answers();
		controller = new ControllerMain();
		about = new Panel_About();
		
		
		//add panel to main
		getContentPane().add(banner, BorderLayout.NORTH);
		getContentPane().add(answer, BorderLayout.CENTER);
		getContentPane().add(options, BorderLayout.SOUTH);
		
	}
	
	
	public void createKeys() {
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setApproveButtonText("Save Keys");
	    int f = chooser.showDialog(this, null);
	    String patch = chooser.getSelectedFile().getPath();
		
		if( JFileChooser.APPROVE_OPTION==f) {
			controller.createKeys(patch);
			JOptionPane.showMessageDialog(null,
			         "El archivo se a guardado exitosamente",
			             "Información",JOptionPane.INFORMATION_MESSAGE);
			    
			answer.setText(controller.getMessage());
		}
		else {
		answer.setText("~/ Se cancelo la operación \n");

		}	
	}
	
	
	public void signatureFile() {
		
		JFileChooser chooserF = new JFileChooser();
		int f = chooserF.showOpenDialog(this);
		
		if(JFileChooser.APPROVE_OPTION == f) {
			String file = chooserF.getSelectedFile().getPath();
			JFileChooser chooserPk = new JFileChooser();
			int pv = chooserPk.showOpenDialog(this);
		    
			if(JFileChooser.APPROVE_OPTION == pv) {
				 String patchPv = chooserPk.getSelectedFile().getPath();
				 
				 JFileChooser chooserNf = new JFileChooser();
					int nF = chooserNf.showSaveDialog(this);
					
				if( JFileChooser.APPROVE_OPTION==nF) {
					String nFile = chooserNf.getSelectedFile().getPath();
					
					controller.signaturefile(file, patchPv, nFile);
					JOptionPane.showMessageDialog(null,
					         "El archivo se firmo correctamente",
					             "Información",JOptionPane.INFORMATION_MESSAGE);
					    
					answer.setText(controller.getMessage());
				}
				else {
					answer.setText("~/ No se seleciono la llave privada \n");
				}
			}
			else {
				answer.setText("~/ No se creo el archivo con la firma \n");
			}
		}
		else {	    
			answer.setText("~/ Se cancelo la firma del archivo \n");
		}	
	}
	
	
	public void verifySignature() {
		JFileChooser chooserPbk = new JFileChooser();
		int pbk = chooserPbk.showOpenDialog(this);
		
		if(JFileChooser.APPROVE_OPTION == pbk) {
			String filePbk = chooserPbk.getSelectedFile().getPath();
			JFileChooser chooserFm = new JFileChooser();
			int fm = chooserFm.showOpenDialog(this);
		    
			if(JFileChooser.APPROVE_OPTION == fm) {
				 String patchFm = chooserFm.getSelectedFile().getPath();
				 
				 JFileChooser chooserNf = new JFileChooser();
					int nF = chooserNf.showOpenDialog(this);
					
				if( JFileChooser.APPROVE_OPTION==nF) {
					String nFile = chooserNf.getSelectedFile().getPath();
					
					controller.verifySignature(filePbk, patchFm, nFile);
					JOptionPane.showMessageDialog(null,
					         "El archivo se verifico correctamente",
					             "Información",JOptionPane.INFORMATION_MESSAGE);
					    
					answer.setText(controller.getMessage());
				}
				else {
					answer.setText("~/ No se seleciono el archivo \n");
				}
			}
			else {
				answer.setText("~/ No se selecciono el archivo con la firma \n");
			}
		}
		else {	    
			answer.setText("~/ Se cancelo la verificacion de la firma \n");
		}
		
	}
	
	
	public void clean() {
		controller.setMessage("");
		answer.clean();
		answer.revalidate();
		repaint();
	}
	

	public static void main(String[] args) {
		
		String message = "\r\n" + 
				".-. .-')            ('-.       .-') _      (`-.     ('-.       .-') _       _ .-') _                 .-')    \r\n" + 
				"\\  ( OO )         _(  OO)     ( OO ) )   _(OO  )_ _(  OO)     ( OO ) )     ( (  OO) )               ( OO ).  \r\n" + 
				" ;-----.\\  ,-.-')(,------.,--./ ,--,',--(_/   ,. (,------.,--./ ,--,',-.-') \\     .'_  .-'),-----. (_)---\\_) \r\n" + 
				" | .-.  |  |  |OO)|  .---'|   \\ |  |\\\\   \\   /(__/|  .---'|   \\ |  |\\|  |OO),`'--..._)( OO'  .-.  '/    _ |  \r\n" + 
				" | '-' /_) |  |  \\|  |    |    \\|  | )\\   \\ /   / |  |    |    \\|  | )  |  \\|  |  \\  '/   |  | |  |\\  :` `.  \r\n" + 
				" | .-. `.  |  |(_(|  '--. |  .     |/  \\   '   /,(|  '--. |  .     |/|  |(_/|  |   ' |\\_) |  |\\|  | '..`''.) \r\n" + 
				" | |  \\  |,|  |_.'|  .--' |  |\\    |    \\     /__)|  .--' |  |\\    |,|  |_.'|  |   / :  \\ |  | |  |.-._)   \\ \r\n" + 
				" | '--'  (_|  |   |  `---.|  | \\   |     \\   /    |  `---.|  | \\   (_|  |   |  '--'  /   `'  '-'  '\\       / \r\n" + 
				" `------'  `--'   `------'`--'  `--'      `-'     `------'`--'  `--' `--'   `-------'      `-----'  `-----'  \r\n" + 
				"--------------------------------------- Firmador y Verificador de Firmas -------------------------------------";
		
		GUI_Main main = new GUI_Main();
		System.out.println(message);
		main.setVisible(true);
	}


	public void about() {
		JOptionPane.showConfirmDialog(null,
				about,
                "Acerca: ",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
	}

}
