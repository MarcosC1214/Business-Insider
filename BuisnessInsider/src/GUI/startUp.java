package GUI;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Color;
import javax.swing.AbstractAction;

public class startUp {
private JTextField textField;
private boolean isClicked = true;


   
private static class FadingPanel extends JPanel {
        private BufferedImage buffer;
        private boolean isFading = false;
        private long start;
        private float alpha = 1.0f;
        private int alpha1 = -255;
        private int increment = 5;
       
        
       

        @Override
        public void paint(Graphics g) {
            if (isFading) {// During fading, we prevent child components from being painted
                g.clearRect(0, 0, getWidth(), getHeight());
                ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                g.drawImage(buffer, 0, 0, this);// We only draw an image of them with an alpha
            } else {
                super.paint(g);
            }
        }
        
        

        public void fadeOut(int time) {
            start = System.currentTimeMillis();
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            this.print(buffer.getGraphics());// Draw the current components on the buffer
            isFading = true;
            final int timeInMillis = time * 1500;
            final Timer t = new Timer(50, null);
            t.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    long elapsed = System.currentTimeMillis() - start;
                    if (elapsed > timeInMillis) {
                        start = 0;
                        isFading = false;
                        buffer = null;
                        repaint();
                        t.stop();
                    } else {
                        alpha = 1.0f - (float) elapsed / timeInMillis;
                        repaint();
                        
                    }
                }
            });
            t.start();
            
            
            
        }
       
    }
	
	JFrame frmWelcome = new JFrame(startUp.class.getSimpleName());


//THREAD START


final static JButton btnNewButton = new JButton("Login");

final static JButton btnNewButton_1 = new JButton("Create New Account");

final static JButton btnNewButton_2 = new JButton("Continue as Guest");


final static JLabel lblNewLabel = new JLabel("Business Insider");


     /**
      * @wbp.parser.entryPoint
      */
     void initUI() throws IOException {
    	
    	 
    	 
    	 
    	final ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("/resources/logo2.png"));
         
         final JLabel Label_1 = new JLabel(imgIcon); 
         
         
   
        
        
        frmWelcome.setBackground(Color.GREEN);
        
        java.net.URL daffyURL = getClass().getResource("/resources/images.png");
        Image daffyDuckImage = ImageIO.read( daffyURL );
        
		frmWelcome.setIconImage(daffyDuckImage);
        frmWelcome.setLocation(450, 200);
        frmWelcome.setResizable(false);
     
        frmWelcome.setTitle("Welcome");
        frmWelcome.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final FadingPanel panel = new FadingPanel();
        
        
        // I use an invoke later to allow the button to release itself
       
       
        SwingUtilities.invokeLater(new Runnable() {

               
                    @Override
               
                    public void run() {
                   
                   
                    if(isClicked) {
                   
            
                   
                   
             
                   Label_1.setBounds(68, 37, 257, 167);
                   panel.add(Label_1);
                  
                   //panel.fadeIn(3); 
                   panel.fadeOut(3);
                   
                   btnNewButton.setOpaque(false);
                   
                   
                   
                   //btnNewButton.setVisible(false);
                   
                   btnNewButton.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 12));
                  
                   btnNewButton.setBounds(142, 107, 89, 23);
                   
                   
                   btnNewButton_1.setOpaque(false);
                   
                   btnNewButton_1.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 12));
                   
                   btnNewButton_1.setBounds(111, 141, 151, 23);
                   
                   
                   btnNewButton_2.setOpaque(false);
                   
                   btnNewButton_2.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 12));
                   
                   btnNewButton_2.setBounds(111, 175, 151, 23);
                   
                  
                   
                   
                   // Fade the panel in 3s.
                   
                   
                   
                   
                   
                   btnNewButton.addActionListener(new ActionListener() {
                       @Override
               		public void actionPerformed(ActionEvent e) {
                       	
                       	loginSystem login;
           				try {
           					
           					login = new loginSystem();
           					login.initUI();
           					//frmWelcome.setVisible(false);
           					
           				} catch (IOException e1) {
           					// TODO Auto-generated catch block
           					e1.printStackTrace();
           				}
                       	
                       }
                       });
                   btnNewButton_1.addActionListener(new ActionListener() {
                       @Override
               		public void actionPerformed(ActionEvent e) {
                       	
                       	registerSystem register;
           				try {
           					register = new registerSystem();
           					register.initUI1();
           					//frmWelcome.setVisible(false);
           				} catch (IOException e1) {
           					// TODO Auto-generated catch block
           					e1.printStackTrace();
           				}
                       	
                       }
                       });
                   
                   btnNewButton_2.addActionListener(new ActionListener() {
                       @Override
               		public void actionPerformed(ActionEvent e) {
                       	
                       	customerPanel custom;
           				try {
           					custom = new customerPanel();
           					custom.initUI3();
           					
           				} catch (IOException e1) {
           					// TODO Auto-generated catch block
           					e1.printStackTrace();
           				}
                       	
                       }
                       });
                   
                  
                    panel.remove(Label_1);
                   
                    
                    lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
                    
                    lblNewLabel.setBounds(122, 17, 131, 23);
                    panel.add(lblNewLabel);
                    	
                    isClicked = false;
                    
                   
                    }
                    
                    
                    panel.add(btnNewButton);
                    panel.add(btnNewButton_1);
                    panel.add(btnNewButton_2);
           
                   }
                    
                    
                    
                });
        
        
      
        panel.setLayout(null);
        
			
		
     
frmWelcome.getContentPane().add(panel);
        
        

        frmWelcome.setSize(400, 300);
        frmWelcome.setVisible(true);
        
    
        
    }
     
  


	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
}