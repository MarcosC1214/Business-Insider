package GUI;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.SwingUtilities;

import GUI.startUp;



public class Booter {

	public static void main(String[] args) throws Exception {
		
		boolean aa;
		
		if(aa = false) {
			
		}
		
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
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
