import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;


public class Controller {
	
	public static void main(String[] args) {
		
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainForm f = null;
				try {
					f = new MainForm();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(1000, 700);
				f.setVisible(true);
			}
		});
	}
}
	