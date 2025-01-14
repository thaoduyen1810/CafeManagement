package Code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Money extends JFrame{
	JTextField txtGuestMoney;
	private JButton btntke;
	String Date;
	
	public Money(String title, String Date)
	{
		super(title);
		this.Date=Date;
		addControls();
		addEvents();
		showWindow();
	}
	
	public void addControls()
	{
		JLayeredPane lay = getLayeredPane();
		
		JLabel bgLbl = new JLabel();
		Image bgImage = Toolkit.getDefaultToolkit().createImage(Main.class.getResource("/Picture/quaythungan-qtn011-5 (1).png"));
		bgLbl.setIcon(new ImageIcon(bgImage));
		
		lay.add(bgLbl, Integer.valueOf(0));
		bgLbl.setBounds(0,0,450,300);
		
		JLabel jlb1 = new JLabel();
		jlb1.setText("Statistical"); //set text of label
		jlb1.setForeground(Color.BLACK); //set color for the text
		jlb1.setFont(new Font("Calibri (Body)", Font.BOLD, 20));
		
		lay.add(jlb1, Integer.valueOf(1));
		jlb1.setBounds(184, 25, 146, 38);
		jlb1.setOpaque(false);
		
		JTextField l1 = new JTextField("Total Money: " + getTotalMoneyForDay(Date));
		l1.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
		l1.setForeground(Color.BLACK);
		l1.setEditable(false);
		l1.setBorder(new EmptyBorder(0,0,0,0));
		lay.add(l1, Integer.valueOf(1));
		l1.setBounds(150, 102, 163, 38);
		l1.setOpaque(false);

        btntke = new JButton("Home");
        btntke.setForeground(new Color(168, 147, 103));
        Font b1sss = new Font(".VnVogue", Font.BOLD, 18);
		btntke.setFont(b1sss);
		btntke.setContentAreaFilled(false);
        lay.add(btntke, Integer.valueOf(1));
        btntke.setBounds(299, 215, 85, 38);
        btntke.setOpaque(false);

        JLabel lblTotal = new JLabel("Total Money:");
        lblTotal.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
        lblTotal.setForeground(Color.BLACK);
        lay.add(lblTotal, Integer.valueOf(1));
        lblTotal.setBounds(10, 102, 146, 38);
        lblTotal.setOpaque(false);
        
		
	}

	    public int getTotalMoneyForDay(String date) {
	    	int totalMoney = 0;
	        String query = "SELECT SUM(thanhtien) AS totalMoney FROM thucpham WHERE Date like '"+
	        date+"%'";
	        try (Connection connection = Connect.connecting();
	             Statement preparedStatement = connection.createStatement()) 
	        {
	            
	            try (ResultSet resultSet = preparedStatement.executeQuery(query)) 
	            {
	                if (resultSet.next()) {
	                    totalMoney = resultSet.getInt("totalMoney");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return totalMoney;
	    }
	
	public void addEvents()
	{
		btntke.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Money.this.setVisible(false);
				new Main("Main");
			}
		});
	}
	
	public static void main(String[] args) {
	}
	
	public void showWindow()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(450, 300);
		this.setLocationRelativeTo(null);
		this.setState(MAXIMIZED_BOTH);	
		this.setResizable(false);
	}

}
