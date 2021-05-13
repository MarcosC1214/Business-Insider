package GUI;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;


public class allOrderMenus { // GUI creator for final ordering menu.
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textField_2;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	void createAndShowGUI() throws IOException { // GUI initializer for frames and panels.
		
		final JFrame frmOrder = new JFrame("Create New Account");
		frmOrder.setTitle("Order Now?");
    	
    	java.net.URL URL = getClass().getResource("/resources/images.png");
        Image daffyDuckImage = ImageIO.read( URL );
        
		frmOrder.setIconImage(daffyDuckImage);
    	
    	
    	frmOrder.setSize(500,500);
    	frmOrder.setLocation(800, 300);
		frmOrder.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmOrder.setResizable(false);
		JPanel panel1 = new JPanel();
		frmOrder.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(allOrderMenus.class.getResource("/resources/del.png")));
		lblNewLabel.setBounds(-16, 11, 239, 150);
		panel1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Order Menu");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(330, 23, 116, 40);
		panel1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Order");
		btnNewButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOP.msg("Your products have been ordered!");
				frmOrder.dispose();
			}
		});
		btnNewButton.setBounds(318, 409, 116, 23);
		panel1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmOrder.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		btnNewButton_1.setBounds(26, 409, 116, 23);
		panel1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone:");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(233, 99, 46, 14);
		panel1.add(lblNewLabel_2);
		
		textField = new JTextField();
		((AbstractDocument) textField.getDocument()).setDocumentFilter(new CustomDocumentFilter());
		textField.setBounds(289, 97, 195, 20);
		panel1.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("Address:");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(233, 135, 46, 14);
		panel1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(289, 133, 195, 20);
		panel1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Order Specifications:");
		lblNewLabel_4.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 195, 132, 14);
		panel1.add(lblNewLabel_4);
		
		textField_2 = new JTextArea();
		textField_2.setBounds(10, 220, 474, 150);
		panel1.add(textField_2);
		textField_2.setColumns(10);
		
		frmOrder.setVisible(true);
	}

	
}
