package GUI;

import javax.swing.JOptionPane;

public class JOP { // JOP class in charge of all pop up messages.

	public static void msg(String msg) { // Pop up message only.
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public static String in(String msg){ // Pop up message along with user input.
		return JOptionPane.showInputDialog(msg);
	}
}
