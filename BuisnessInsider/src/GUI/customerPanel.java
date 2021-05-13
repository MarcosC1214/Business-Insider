package GUI;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import GUI.partyMenu;
import javax.swing.JScrollPane;

public class customerPanel { // Class in charge of opening Customer main menu.
  
	/**
	 * @wbp.parser.entryPoint
	 */
	void initUI3() throws IOException { // Initializes all frames and panels.
    final JFrame f = new JFrame("Customer Main Menu");
    f.setSize(500, 275);
    f.setLocation(800, 300);
    f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	f.setResizable(false);

    
    JMenuBar jmb = new JMenuBar();

    JMenu jmFile = new JMenu("File");
    JMenuItem jmiSave = new JMenuItem("Save");
    JMenuItem jmiExit = new JMenuItem("Exit");
    jmFile.add(jmiSave);
    jmFile.addSeparator();
    jmFile.add(jmiExit);
    jmb.add(jmFile);
    
    final ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("/resources/party.jpg"));
    
    final JLabel Label_1 = new JLabel(imgIcon); 
    
   
   java.net.URL daffyURL = getClass().getResource("/resources/images.png");
   Image daffyDuckImage = ImageIO.read( daffyURL );
   
	f.setIconImage(daffyDuckImage);
    
    jmiExit.addActionListener(new ActionListener() {
        @Override
		public void actionPerformed(ActionEvent ev) {
        	f.dispose();
        }
    });
    
    jmiSave.addActionListener(new ActionListener() {
        @Override
		public void actionPerformed(ActionEvent ev) {
        	//Save Code goes here
        }
    });
    
    

  
    JMenu jmHelp = new JMenu("Help");
    JMenuItem jmiAbout = new JMenuItem("About");
    jmHelp.add(jmiAbout);
    jmb.add(jmHelp);
    
    jmiAbout.addActionListener(new ActionListener() {
        @Override
		public void actionPerformed(ActionEvent ev) { 
        	infoPanel info;
			try {
				info = new infoPanel();
				info.initUI4();
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					System.exit(-1);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
        }
			
       }
    });
    
    f.setJMenuBar(jmb);
    f.getContentPane().setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Shops Near Me:");
    lblNewLabel.setBounds(0, 0, 494, 20);
    lblNewLabel.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 15));
    f.getContentPane().add(lblNewLabel);
    
    JButton button = new JButton("Farmers Market");
    button.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 15));
    button.setHorizontalAlignment(SwingConstants.LEFT);
    button.setBounds(0, 92, 494, 64);
    button.setBorderPainted( false );
    f.getContentPane().add(button);
    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
    f.setVisible(true);
    
    button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			farmerMenu farm;
			try {
				farm = new farmerMenu();
				farm.createAndShowGUI();
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					System.exit(-1);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
    
    JButton button1 = new JButton("Bikes N' More");
    button1.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 15));
    button1.setHorizontalAlignment(SwingConstants.LEFT);
    button1.setBounds(0, 151, 494, 64);
    button1.setBorderPainted( false );
    f.getContentPane().add(button1);
    button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    f.setVisible(true);
    
	 button1.addActionListener(new ActionListener() {
       @Override
		public void actionPerformed(ActionEvent e) {
      	
    	   bikeMenu bike;
			try {
				bike = new bikeMenu();
				bike.createAndShowGUI();
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					System.exit(-1);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       	
       }
       });
    
    
   
    
    
    
    JButton button3 = new JButton("Party Bakery");
   
    button3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
    button3.setHorizontalAlignment(SwingConstants.LEFT);
    button3.setBounds(0, 31, 494, 64);
    button3.setBorderPainted( false );
    f.getContentPane().add(button3);
    button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    f.setVisible(true);
    button3.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		partyMenu party;
			try {
				party = new partyMenu();
				party.createAndShowGUI();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    });
    
    
  }
}
