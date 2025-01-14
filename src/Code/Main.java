package Code;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame{
	JButton b1, b2, b3, b4;
	
	public Main(String title)
	{
		super(title);
		addcontrols();
		showWindow();
		addEvents();
	}
	public void addcontrols()
	{
		JLayeredPane lay = getLayeredPane();
		
		//add the picture
		JLabel bgLbl = new JLabel();
		Image bgImage = Toolkit.getDefaultToolkit().createImage(Main.class.getResource("/Picture/Picture4.png"));
		bgLbl.setIcon(new ImageIcon(bgImage));
		
		JLabel jlb1 = new JLabel();
		Image Image = Toolkit.getDefaultToolkit().createImage(Main.class.getResource("/Picture/coffee-1974841_1280.jpg"));
		jlb1.setIcon(new ImageIcon(Image));
		
		lay.add(jlb1, Integer.valueOf(0));
		jlb1.setBounds(0,0,1280,720);
		
		JLabel jlb2 = new JLabel();
		jlb2.setText("Hotline: 0817011246"); //set text of label
		jlb2.setForeground(new Color(168, 147, 103)); //set color for the text
		jlb2.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
		
		lay.add(jlb2, Integer.valueOf(1));
		jlb2.setBounds(1000,0,500,50);
		jlb2.setOpaque(false);
		
		JLabel jlb2text = new JLabel();
		jlb2text.setText("Bring unbelievable things to you!"); //set text of label
		jlb2text.setForeground(new Color(168, 147, 103)); //set color for the text
		jlb2text.setFont(new Font("Calibri (Body)", Font.BOLD, 15));
		
		lay.add(jlb2text, Integer.valueOf(1));
		jlb2text.setBounds(180,0,1000,200);
		jlb2text.setOpaque(false);
		
		JPanel coffecontrol = new JPanel();
		coffecontrol.setLayout(new FlowLayout());
		coffecontrol.add(bgLbl);
		lay.add(coffecontrol, Integer.valueOf(3));
		
		coffecontrol.setBounds(0,50,1195,720);
		coffecontrol.setOpaque(false);
		
		
		JPanel control = new JPanel();
		control.setLayout(new BoxLayout(control, BoxLayout.X_AXIS));
		lay.add(control, Integer.valueOf(4));
		control.setBounds(0,155,1195,720); // hiển thị
		control.setOpaque(false);

		JPanel hi1 = new JPanel();
		hi1.setLayout(new FlowLayout());
		control.add(hi1);
		
		
		b1 = new JButton("Home Page");
		b2 = new JButton("Service");
		
		hi1.setOpaque(false);
		
		hi1.add(b1);
		hi1.add(Box.createHorizontalStrut(50));
		hi1.add(b2);
		
		JPanel con2 = new JPanel();
		con2.setLayout(new FlowLayout());
		control.add(con2);
			
		b4 = new JButton("Money");
		

		con2.add(Box.createHorizontalStrut(50));
		con2.add(b4);
		
		con2.setOpaque(false);
		
		b1.setContentAreaFilled(false);
		b1.setForeground(new Color(168, 147, 103));
		Font b1a = new Font(".VnVogue", Font.BOLD, 18);
		b1.setFont(b1a);
		b1.setBorder(new EmptyBorder(0,0,0,0));
		
		b2.setContentAreaFilled(false);
		b2.setForeground(new Color(168, 147, 103));
		Font b1b = new Font(".VnVogue", Font.BOLD, 18);
		b2.setFont(b1a);
		b2.setBorder(new EmptyBorder(0,0,0,0));
		

		b4.setContentAreaFilled(false);
		b4.setForeground(new Color(168, 147, 103));
		Font b1d = new Font(".VnVogue", Font.BOLD, 18);
		b4.setFont(b1a);
		b4.setBorder(new EmptyBorder(0,0,0,0));
		
		b2.setPreferredSize(b1.getPreferredSize());
		b4.setPreferredSize(b1.getPreferredSize());
	}
	public void addEvents()
	{
		
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Login loginFrame = new Login("LOGIN");
		        loginFrame.setVisible(true);
		        // Đóng cửa sổ của class Main
		        dispose();
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Chuyển sang giao diện của class Service ở đây
		        Service serviceFrame = new Service();
		        serviceFrame.setVisible(true);
		        // Đóng cửa sổ của class Main nếu bạn muốn
		        dispose();
			}
		});

		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.this.setVisible(false);
				LocalDate date = LocalDate.now();
				String dateString = date.toString();
				System.out.println(dateString);
				new Money("Money", dateString);
			}
		});
	}
	
	public static void main(String[] args) {
		new Main("Main");
	}
	
	public void showWindow()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setState(MAXIMIZED_BOTH);		
	}

}
