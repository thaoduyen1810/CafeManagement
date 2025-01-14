package Code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Flow;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Login extends JFrame{
	JTextField txtID, txtMK;
	JButton btnOk;
	JPasswordField txtMMK;
	
	
	public Login(String title)
	{
		super(title);
		addControls();
		setImage();
		addEvents();
		showWindow();
	}
	public void setImage()
	{
		JLabel Imlabel = new JLabel(new ImageIcon(Login.class.getResource("/Picture/Screenshot 2023-12-29 164751.png")));
		add(Imlabel, BorderLayout.WEST);
	}
	public void addControls()
	{
		Container con = getContentPane();
		
		JPanel Main1 = new JPanel();
		Main1.setLayout(new GridLayout());
		con.add(Main1);
        
		JPanel Mainright = new JPanel();
		Mainright.setLayout(new BoxLayout(Mainright, BoxLayout.Y_AXIS));
		Mainright.setBackground(Color.GRAY);
		Main1.add(Mainright);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		pnTitle.setBackground(Color.lightGray);
		JLabel lblTieuDe = new JLabel("LOGIN");
		
		lblTieuDe.setPreferredSize(new Dimension(120, 80));
		
		pnTitle.add(lblTieuDe);
		Mainright.add(pnTitle);
		lblTieuDe.setForeground(new Color(168, 147, 103));
		Font fontTieuDe = new Font(".VnVogue", Font.BOLD, 30);
		lblTieuDe.setFont(fontTieuDe);
		
		JPanel ID = new JPanel();
		ID.setLayout(new FlowLayout());
		ID.setBackground(Color.lightGray);
		JLabel lblID = new JLabel("Admind Email");
		txtID = new JTextField(20);	
		txtID.setForeground(new Color(19, 45, 70));
		ID.add(lblID);
		ID.add(txtID);
		lblID.setForeground(new Color(168, 147, 103));
		Font fontID = new Font(".VnVogue", Font.BOLD, 18);
		lblID.setFont(fontID);
		Mainright.add(ID);
		
		JPanel MK = new JPanel();
		MK.setLayout(new FlowLayout());
		MK.setBackground(Color.lightGray);
		JLabel lblMK = new JLabel("Password");
		txtMMK = new JPasswordField(20);	
		MK.add(lblMK);
		MK.add(txtMMK);
		lblMK.setForeground(new Color(168, 147, 103));
		Font fontMK = new Font(".VnVogue", Font.BOLD, 18);
		lblMK.setFont(fontMK);
		Mainright.add(MK); 
		
		JPanel button = new JPanel();
		button.setLayout(new BoxLayout(button, BoxLayout.X_AXIS));
		Mainright.add(button);
		btnOk = new JButton("LOGIN");
		btnOk.setBackground(Color.gray);
		btnOk.setForeground(new Color(69, 72, 67));
		Font fontbtnOk = new Font(".VnVogue", Font.BOLD, 18);
		btnOk.setFont(fontbtnOk);
		btnOk.setContentAreaFilled(false);
		btnOk.setForeground(new Color(168, 147, 103));
		button.add(btnOk);
		
		
		lblMK.setPreferredSize(lblID.getPreferredSize());
		
	}
	
	public void addEvents()
	{
			
		btnOk.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String username = txtID.getText();
		        String password = txtMMK.getText();
		        
		        String ID = null, MK = null;
		        
		        
				try {
					Connection con = Connect.connecting();
					
					String sql = "SELECT * FROM Login1 "+
							"WHERE ID=?";
					
					PreparedStatement pst = con.prepareStatement(sql);
					
					pst.setString(1, username);
					
					ResultSet rs = pst.executeQuery();
					
					while (rs.next()) {
						ID = rs.getString("ID");
						MK = rs.getString("MK");
						
					}
		        
				} catch (SQLException n) {
					n.printStackTrace();
				}
		        
		        if (username.isEmpty() || password.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter your username and password.");
		        } else if (username.equals(ID)&& password.equals(MK)) {
		            JOptionPane.showMessageDialog(null, "Login Successfully");
		            Login.this.setVisible(false);
		            new Main("Main");
		        } else {
		            JOptionPane.showMessageDialog(null, "Login Fail");
		        }
		    }
		});
		
		txtMMK.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            // Xử lý đăng nhập ở đây
		            String username = txtID.getText();
		            String password = new String(txtMMK.getPassword());
		            if (username.equals("admin") && password.equals("12345678")) {
		                JOptionPane.showMessageDialog(null, "Login Successfully");
		                Login.this.setVisible(false);
		                new Main("Main");
		            } else {
		                JOptionPane.showMessageDialog(null, "Login Fail");
		            }
		        }
		    }
		});
		
	}
	
	public static void main(String[] args) {
		new Login("LOGIN");
		
	}
	public void showWindow()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(700, 400);
		this.setLocationRelativeTo(null);
		this.setState(MAXIMIZED_BOTH);	
		this.setResizable(false);
	}

}
