package Code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Table {
	
	public static void do_b_actionPerformed(ActionEvent e, JButton b, DefaultTableModel model) {
		b.setBackground(Color.WHITE);
		
		try {
			int row = 0;
//			Class.forName(driver);
			Connection conn = Connect.connecting();
			String sql = "DELETE   from dbo.thucpham ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "error");
		}

		
	}

}
