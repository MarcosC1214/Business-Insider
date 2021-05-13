package GUI;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.SwingUtilities;

import GUI.startUp;



public class Booter { // Booter class to boot up the program.

	public static void main(String[] args) throws Exception { // Static method to run program 
		
		boolean aa;
		
		if(aa = false) {
			
		}
		
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() { // Void run method.
                try {
                    new startUp().initUI();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
	

	
}
