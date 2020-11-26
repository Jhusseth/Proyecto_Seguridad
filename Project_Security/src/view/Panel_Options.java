package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author Jhusseth
 *
 */
public class Panel_Options extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * relationship with the main class
	 */
	private GUI_Main main;
	
	
	/**
	 * constants for buttons
	 */
	public static final String CREATE ="create_keys";
	public static final String SIGNATURE ="signature_file";
	public static final String VERIFY ="verify signature";
	public static final String CLEAR ="clear_panel";
	public static final String ABOUT = "about";
	
	/**
	 * Button
	 * 
	 */
	private JButton btn_create;
	private JButton btn_signature;
	private JButton btn_verify;
	private JButton btn_clear;
	private JButton btn_about;
	
	/**
	 * 
	 * @param main
	 */
	public Panel_Options (GUI_Main main){
		setBorder(new TitledBorder(null, "opciones", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		this.main = main;
		setLayout(new GridLayout(1,5,4,4));
		
		setBackground(Color.WHITE);
		
		//buttons
		btn_create = new JButton("Crear LLaves");
		btn_create.setBackground(Color.BLACK);
		btn_create.setForeground(Color.WHITE);
		btn_create.setActionCommand(CREATE);
		btn_create.addActionListener(this);
		btn_signature = new JButton("Firmar Archivo");
		btn_signature.setBackground(Color.BLACK);
		btn_signature.setForeground(Color.WHITE);
		btn_signature.setActionCommand(SIGNATURE);
		btn_signature.addActionListener(this);
		btn_verify = new JButton("Verificar Firma");
		btn_verify.setBackground(Color.BLACK);
		btn_verify.setForeground(Color.WHITE);
		btn_verify.setActionCommand(VERIFY);
		btn_verify.addActionListener(this);
		btn_about = new JButton("Acerca");
		btn_about.setBackground(Color.BLACK);
		btn_about.setForeground(Color.WHITE);
		btn_about.setActionCommand(ABOUT);
		btn_about.addActionListener(this);
		btn_clear = new JButton("Limpiar");
		btn_clear.setBackground(Color.BLACK);
		btn_clear.setForeground(Color.WHITE);
		btn_clear.setActionCommand(CLEAR);
		btn_clear.addActionListener(this);
		
		add(btn_create);
		add(btn_signature);
		add(btn_verify);
		add(btn_clear);
		add(btn_about);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String event = e.getActionCommand();
		
		if(event.equals(CREATE)) {
			main.createKeys();
		}
		
		if(event.equals(SIGNATURE)) {
			main.signatureFile();		
		}
		
		if(event.equals(VERIFY)) {
			main.verifySignature();
		}
		
		if(event.equals(CLEAR)) {
			main.clean();
		}
		
		if(event.equals(ABOUT)) {
			main.about();
		}
	}

}
