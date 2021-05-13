package GUI;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import GUI.startUp;

public class loginSystem { // Login system for business aspect and account.
	
	/**
	 * @wbp.parser.entryPoint
	 */
	void initUI() throws IOException { // Initializes all frames and panels.
		
		JFrame frame = new JFrame("Login");
    	
    	java.net.URL URL = getClass().getResource("/resources/images.png");
        Image daffyDuckImage = ImageIO.read( URL );
        
		frame.setIconImage(daffyDuckImage);
    	
    	
    	frame.setSize(300, 150);
    	frame.setLocation(800, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		JPanel panel1 = new JPanel();
		frame.getContentPane().add(panel1);
		
		
		panel1.setLayout(null);

		JLabel userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		userLabel.setBounds(10, 10, 80, 25);
		panel1.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 12));
		userText.setBounds(100, 10, 160, 25);
		panel1.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		passwordLabel.setBounds(10, 40, 80, 25);
		panel1.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 12));
		passwordText.setBounds(100, 40, 160, 25);
		panel1.add(passwordText);

		JButton loginButton = new JButton("Login");
		 loginButton.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 12));
		loginButton.setBounds(100, 80, 160, 25);
		panel1.add(loginButton);
		
		frame.setVisible(true);
	}
}
