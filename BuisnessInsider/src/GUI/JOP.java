package GUI;

import javax.swing.JOptionPane;

public class JOP {

	public static void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public static String in(String msg){
		return JOptionPane.showInputDialog(msg);
	}
}
