package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 * 
 * @author Jhusseth
 *
 */
public class Panel_Answers  extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param main
	 */
	
	/**
	 * TextArea for the aswers in the programm
	 */
	private JTextArea text;
	
	public Panel_Answers () {
		setBackground(Color.WHITE);
		
		text = new JTextArea(15,40);
		text.setBackground(Color.BLUE);
		text.setForeground(Color.WHITE);
		text.setText("");
		text.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(text);
		scroll.setViewportBorder(new LineBorder(Color.BLACK, 5));
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		scroll.setBackground(Color.WHITE);
		
		add(scroll);
	}

	public void setText(String nText) {
		text.append(nText);
	}
	
	public void clean() {
		text.setText("");
	}

	
	
}
