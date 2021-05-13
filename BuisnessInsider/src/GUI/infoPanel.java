package GUI;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import GUI.startUp;
import javax.swing.JTextArea;

public class infoPanel { // Shows instructions for customer.
	
	/**
	 * @wbp.parser.entryPoint
	 */
	void initUI4() throws IOException { // Inititialzes all panels and frames.
		
		JFrame frmCustomerInfo = new JFrame("Create New Account");
		frmCustomerInfo.setTitle("Customer Info");
    	
    	java.net.URL URL = getClass().getResource("/resources/images.png");
        Image daffyDuckImage = ImageIO.read( URL );
        
		frmCustomerInfo.setIconImage(daffyDuckImage);
    	
    	
    	frmCustomerInfo.setSize(600, 200);
    	frmCustomerInfo.setLocation(800, 300);
		frmCustomerInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCustomerInfo.setResizable(false);
		JPanel panel1 = new JPanel();
		frmCustomerInfo.getContentPane().add(panel1);
		
		
		panel1.setLayout(null);
		
		JTextArea txtrhereAreThe = new JTextArea();
		txtrhereAreThe.setEditable(false);
		txtrhereAreThe.setText(" -Here are the instructions:\r\n" + 
				" - Navigate through the panel in search for any nearby shops\r\n" + 
				" - Press on desired shop to begin shopping experience.\r\n" + 
				" - Note: New businesses will appear once owner has added them to the list.\r\n" + 
				" - Use this as reference as many times as you like.");
		txtrhereAreThe.setBounds(0, 0, 594, 171);
		panel1.add(txtrhereAreThe);
		
		frmCustomerInfo.setVisible(true);
	}
}






