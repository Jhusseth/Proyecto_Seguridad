package view;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Jhusseth
 *
 */
public class Panel_Banner extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * label for message in panel
	 */
	private JLabel lb;
	
	
	public Panel_Banner() {
		
		setBackground(Color.WHITE);
		
		String path = "data/banner.png";
        File file = new File(path);
        BufferedImage image;
		try {
			image = ImageIO.read(file);
			lb = new JLabel(new ImageIcon(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        add(lb);
		
	}
	

}
