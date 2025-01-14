package Code;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Drink.Drink1;
import Food.Food1;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Service extends JFrame {
	private ArrayList<Drink1> list;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	String date;
	String time1;
	String datetime;
	Timer time;

	/**
	 * Launch the application.
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service frame = new Service();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//
	   String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	   String url ="jdbc:sqlserver://localhost:1433;databaseName=duan";
	   String user = "sa";
	   String password = "12345678";
	   Statement st;
	   ResultSet rs;

	
	   private double thanhtien;
	   private DefaultTableModel model;
	   private JButton b1;
	   private JButton b2;
	   private JButton b3;
	   private JButton b4;
	   private JButton b5;
	   private JButton b8;
	   private JButton b11;
	   private JButton b14;
	   private JButton b6;
	   private JButton b9;
	   private JButton b12;
	   private JButton b15;
	   private JButton b7;
	   private JButton b10;
	   private JButton b13;
	   private JButton b16;
	   private JButton b17;
	   private JButton b18;
	   private JButton b19;
	   private JButton b20;
	   private JButton b21;
	   private JButton b23;
	   private JButton b22;
	   private JButton b34;
	   private JButton b26;
	   private JButton b27;
	   private JButton b28;
	   private JButton b29;
	   private JButton b30;
	   private JButton b31;
	   private JButton b32;
	   private JButton b33;
	   private JButton b35;
	   private JButton b36;
	   private JButton b37;
	   private final ButtonGroup buttonGroup = new ButtonGroup();
	   private String formattedTotalAmount;
	
	   private AbstractButton tienkhachtra;

	   private JTextField guestmoney;
	   private JLabel tongtien;
	   private JLabel tienthua;
	   private JButton b24;
	   private JTextField textField;
	   private JTextField textField_1;
	
	  public Service() {
		
		  
		  time = new Timer(5000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
						LocalDateTime currenttime = LocalDateTime.now();
						String date1 = currenttime.toString();
						date = date1.substring(0, 10);
						time1 = date1.substring(11, 19);
						datetime = date + " " + time1;
						System.out.println(datetime);
						textField.setText(time1);
						textField_1.setText(date);

				}
			});
		  time.setInitialDelay(0);
		time.start();
		list= new ArrayList<Drink1>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 1391, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 84, 714);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton bhome = new JButton("Home");
		bhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Mainjf();
			}
		});
		bhome.setForeground(new Color(168, 147, 103));
		Font ba1 = new Font(".VnVogue", Font.BOLD, 18);
		bhome.setFont(ba1);
		bhome.setBackground(Color.BLACK);
		bhome.setBounds(0, 10, 85, 41);
		panel.add(bhome);

		JLabel lblsale =  new JLabel("  Sale");
		lblsale.setBackground(new Color(0, 0, 0));
		lblsale.setForeground(new Color(168, 147, 103));
		Font ba2 = new Font(".VnVogue", Font.BOLD, 18);
		lblsale.setFont(ba1);
		lblsale.setBackground(Color.BLACK);

		
		lblsale.setBounds(10, 89, 64, 446);
		panel.add(lblsale);
		
		JPanel p1 = new JPanel();
		p1.setBounds(104, 56, 387, 354);
		contentPane.add(p1);
		p1.setLayout(null);
		
		b1 = new JButton("Table");
		b1.setForeground(new Color(168, 147, 103));
		Font b1aa = new Font("Forte", Font.BOLD, 15);
		b1.setFont(b1aa);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_b1_actionPerformed(e);
			}
		});
		b1.setBounds(10, 21, 80, 67);
		p1.add(b1);
		
		b2 = new JButton("T1");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b2, model);
			}
		});
		b2.setForeground(new Color(168, 147, 103));
		Font b2aa = new Font("Forte", Font.BOLD, 15);
		b2.setFont(b2aa);
		b2.setBackground(Color.BLACK);
		b2.setBounds(100, 21, 80, 67);
		p1.add(b2);
		
		b3 = new JButton("T2");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b3, model);
			}
		});
		b3.setForeground(new Color(168, 147, 103));
		Font b3a = new Font("Forte", Font.BOLD, 15);
		b3.setFont(b3a);
		b3.setBackground(Color.BLACK);
		b3.setBounds(190, 21, 80, 67);
		p1.add(b3);
		
		b4 = new JButton("T3");
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Table.do_b_actionPerformed(e, b4, model);
			}
		});
		b4.setForeground(new Color(168, 147, 103));
		Font b4a = new Font("Forte", Font.BOLD, 15);
		b4.setFont(b4a);
		b4.setBackground(Color.BLACK);
		b4.setBounds(280, 21, 80, 67);
		p1.add(b4);
		
		b5 = new JButton("T4");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b5, model);
			}
		});
		b5.setForeground(new Color(168, 147, 103));
		Font b5a = new Font("Forte", Font.BOLD, 15);
		b5.setFont(b5a);
		b5.setBackground(Color.BLACK);
		b5.setBounds(10, 98, 80, 67);
		p1.add(b5);
		
		b6 = new JButton("T8");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b6, model);
			}
		});
		b6.setForeground(new Color(168, 147, 103));
		Font b6a = new Font("Forte", Font.BOLD, 15);
		b6.setFont(b6a);
		b6.setBackground(Color.BLACK);
		b6.setBounds(10, 175, 80, 67);
		p1.add(b6);
		
		b7 = new JButton("T12");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b7, model);
			}
		});
		b7.setForeground(new Color(168, 147, 103));
		Font b7a = new Font("Forte", Font.BOLD, 15);
		b7.setFont(b7a);
		b7.setBackground(Color.BLACK);
		b7.setBounds(10, 252, 80, 67);
		p1.add(b7);
		
		b8 = new JButton("T5");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b8, model);
			}
		});
		b8.setForeground(new Color(168, 147, 103));
		Font b8a = new Font("Forte", Font.BOLD, 15);
		b8.setFont(b8a);
		b8.setBackground(Color.BLACK);
		b8.setBounds(100, 98, 80, 67);
		p1.add(b8);
		
		b9 = new JButton("T9");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b9, model);
			}
		});
		b9.setForeground(new Color(168, 147, 103));
		Font b9a = new Font("Forte", Font.BOLD, 15);
		b9.setFont(b9a);
		b9.setBackground(Color.BLACK);
		b9.setBounds(100, 175, 80, 67);
		p1.add(b9);
		
		b10 = new JButton("T13");
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b10, model);
			}
		});
		b10.setForeground(new Color(168, 147, 103));
		Font b10a = new Font("Forte", Font.BOLD, 15);
		b10.setFont(b10a);
		b10.setBackground(Color.BLACK);
		b10.setBounds(100, 252, 80, 67);
		p1.add(b10);
		
		b11 = new JButton("T6");
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b11, model);
			}
		});
		b11.setForeground(new Color(168, 147, 103));
		Font b11a = new Font("Forte", Font.BOLD, 15);
		b11.setFont(b11a);
		b11.setBackground(Color.BLACK);
		b11.setBounds(190, 98, 80, 67);
		p1.add(b11);
		
		b12 = new JButton("T10");
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b12, model);
			}
		});
		b12.setForeground(new Color(168, 147, 103));
		Font b12a = new Font("Forte", Font.BOLD, 15);
		b12.setFont(b12a);
		b12.setBackground(Color.BLACK);
		b12.setBounds(190, 175, 80, 67);
		p1.add(b12);
		
		b13 = new JButton("T14");
		b13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b13, model);
			}
		});
		b13.setForeground(new Color(168, 147, 103));
		Font b13a = new Font("Forte", Font.BOLD, 15);
		b13.setFont(b13a);
		b13.setBackground(Color.BLACK);
		b13.setBounds(190, 252, 80, 67);
		p1.add(b13);
		
		b14 = new JButton("T7");
		b14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b14, model);
			}
		});
		b14.setForeground(new Color(168, 147, 103));
		Font b14a = new Font("Forte", Font.BOLD, 15);
		b14.setFont(b14a);
		b14.setBackground(Color.BLACK);
		b14.setBounds(280, 98, 80, 67);
		p1.add(b14);
		
		b15 = new JButton("T11");
		b15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b15, model);
			}
		});
		b15.setForeground(new Color(168, 147, 103));
		Font b15a = new Font("Forte", Font.BOLD, 15);
		b15.setFont(b15a);
		b15.setBackground(Color.BLACK);
		b15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b15.setBounds(280, 175, 80, 67);
		p1.add(b15);
		
		b16 = new JButton("T15");
		b16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.do_b_actionPerformed(e, b16, model);
			}
		});
		b16.setForeground(new Color(168, 147, 103));
		Font b16a = new Font("Forte", Font.BOLD, 15);
		b16.setFont(b16a);
		b16.setBackground(Color.BLACK);
		b16.setBounds(280, 252, 80, 67);
		p1.add(b16);
		
		JPanel p2 = new JPanel();
		p2.setBounds(104, 450, 387, 400);
		contentPane.add(p2);
		p2.setLayout(null);
		
		b17 = new JButton("Food 1");
		b17.setIcon(new ImageIcon("src/Picture/flan.png"));
		b17.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b17_actionPerformed(e);
			}
		});
		b17.setBounds(10, 21, 160, 91);
		p2.add(b17);
		
		b18 = new JButton("Food 2");
		b18.setIcon(new ImageIcon("src/Picture/ca2.png"));
		b18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_b18_actionPerformed(e);
			}
		});
		b18.setBounds(200, 21, 160, 91);
		p2.add(b18);
		
		b19 = new JButton("Food 3");
		b19.setIcon(new ImageIcon("src/Picture/moussee.png"));
		b19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_b19_actionPerformed(e);
			}
		});
		b19.setBounds(10, 140, 160, 91);
		p2.add(b19);
		
		b20 = new JButton("Food 4");
		b20.setIcon(new ImageIcon("src/Picture/tiramisu (1).png"));
		b20.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b20_actionPerformed(e);
			}
		});
		b20.setBounds(200, 140, 160, 91);
		p2.add(b20);
		
		b23 = new JButton("Food 5");
		b23.setIcon(new ImageIcon("src/Picture/"));
		b23.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b23_actionPerformed(e);
			}
		});
		b23.setBounds(10, 240, 160, 91);
		p2.add(b23);
		
		b22 = new JButton("Food 6");
		b22.setIcon(new ImageIcon("src/Picture/"));
		b22.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				do_b22_actionPerformed(e);
			}
		});
		b22.setBounds(200, 240, 160, 91);
		p2.add(b22);
		
		
		
		
		JPanel p4 = new JPanel();
		p4.setBounds(501, 452, 495, 145);
		contentPane.add(p4);
		p4.setLayout(null);
		
		JButton b21 = new JButton("Total Money");
		b21.setForeground(new Color(168, 147, 103));
		Font bab = new Font(".VnVogue", Font.BOLD, 15);
		b21.setFont(bab);
		b21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_b21_actionPerformed(e);
			}
		});
		b21.setBackground(Color.BLACK);
		b21.setBounds(10, 10, 152, 21);
		p4.add(b21);
		
		tongtien = new JLabel("");
		tongtien.setBounds(192, 14, 102, 13);
		p4.add(tongtien);
		
		JButton b22 = new JButton("GUEST MONEY");
		b22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b22.setForeground(new Color(168, 147, 103));
		Font ba2b = new Font(".VnVogue", Font.BOLD, 15);
		b22.setFont(ba2b);
		b22.setBackground(Color.BLACK);
		b22.setBounds(10, 45, 152, 21);
		p4.add(b22);
		
		JButton b23 = new JButton("ROT MONEY");
		b23.setForeground(new Color(168, 147, 103));
		Font ba3b = new Font(".VnVogue", Font.BOLD, 15);
		b23.setFont(ba3b);
		b23.setBackground(Color.BLACK);
		b23.setBounds(10, 76, 152, 21);
		p4.add(b23);
		
		tienthua = new JLabel("");
		tienthua.setBounds(187, 84, 122, 13);
		p4.add(tienthua);
		
		b24 = new JButton("Print");
		b24.setForeground(new Color(168, 147, 103));
		Font ba4b = new Font(".VnVogue", Font.BOLD, 15);
		b24.setFont(ba4b);
		b24.setBackground(Color.BLACK);
		b24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_b24_actionPerformed(e);
			}
		});
	     b24.setVisible(false);
		
		b24.setBounds(353, 98, 85, 37);
		p4.add(b24);
		
		JButton b25 = new JButton("Bill");
		b25.setForeground(new Color(168, 147, 103));
		Font ba5b = new Font(".VnVogue", Font.BOLD, 15);
		b25.setFont(ba5b);
		b25.setBackground(Color.BLACK);
		b25.setBounds(353, 10, 85, 21);
		p4.add(b25);
		
		JCheckBox cBox = new JCheckBox("Yes");
		cBox.setForeground(new Color(168, 147, 103));
		Font boxb = new Font(".VnVogue", Font.BOLD, 15);
		cBox.setFont(boxb);
		cBox.setBackground(Color.BLACK);
		cBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_cBox_actionPerformed(e);
			}
		});
		buttonGroup.add(cBox);
		cBox.setBounds(353, 37, 70, 21);
		p4.add(cBox);
		
		JCheckBox cBox1 = new JCheckBox("No");
		cBox1.setForeground(new Color(168, 147, 103));
		Font boxb1 = new Font(".VnVogue", Font.BOLD, 15);
		cBox1.setFont(boxb1);
		buttonGroup.add(cBox1);
		cBox1.setBackground(Color.BLACK);
		cBox1.setBounds(353, 60, 70, 21);
		p4.add(cBox1);
		
		guestmoney = new JTextField();
		guestmoney.setBounds(181, 46, 128, 19);
		p4.add(guestmoney);
		guestmoney.setColumns(10);
		
		JLabel lbl1 = new JLabel("Welcome to our coffee house");
		lbl1.setForeground(new Color(168, 147, 103));
		Font ba = new Font("Forte", Font.BOLD, 20);
		lbl1.setFont(ba);
		lbl1.setBounds(172, 25, 268, 21);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("Food");
		lbl2.setForeground(new Color(168, 147, 103));
		Font ba22 = new Font("Forte", Font.BOLD, 20);
		lbl2.setFont(ba22);
		lbl2.setBounds(195, 414, 108, 40);
		contentPane.add(lbl2);
		
		JPanel p3 = new JPanel();
		p3.setBounds(501, 56, 495, 354);
		contentPane.add(p3);
		p3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 475, 334);
		p3.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u0110\u1ED3 U\u1ED1ng", "Gi\u00E1 Ti\u1EC1n", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Ti\u1EC1n"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JPanel p5 = new JPanel();
		p5.setBounds(1006, 56, 316, 668);
		contentPane.add(p5);
		p5.setLayout(null);
		
		b34 = new JButton("MÃ³n 1");
		b34.setIcon(new ImageIcon("src/Picture/thai do caramell.png"));
		b34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_b34_actionPerformed(e);
			}
		});
		b34.setBounds(10, 10, 137, 97);
		p5.add(b34);
		
		b26 = new JButton("MÃ³n 2");
		b26.setIcon(new ImageIcon("src/Picture/tsthaixanhh.png"));
		b26.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b26_actionPerformed(e);
			}
		});
		b26.setBounds(169, 10, 137, 97);
		p5.add(b26);
		b27 = new JButton("MÃ³n 3");
		b27.setIcon(new ImageIcon("src/Picture/phindikemsuaa.png"));
		b27.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b27_actionPerformed(e);
			}
		});
		b27.setBounds(10, 117, 137, 97);
		p5.add(b27);
		
		b28 = new JButton("MÃ³n 4");
		b28.setIcon(new ImageIcon("src/Picture/trathachvaii.png"));
		b28.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b28_actionPerformed(e);
			}
		});
		b28.setBounds(169, 117, 137, 97);
		p5.add(b28);
		
		b29 = new JButton("MÃ³n 5");
		b29.setIcon(new ImageIcon("src/Picture/phinsuadaa.png"));
		b29.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b29_actionPerformed(e);
			}
		});
		b29.setBounds(10, 224, 137, 97);
		p5.add(b29);
		
		b30 = new JButton("MÃ³n 6");
		b30.setIcon(new ImageIcon("src/Picture/freeze trà xanhh.png"));
		b30.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b30_actionPerformed(e);
			}
		});
		b30.setBounds(169, 224, 137, 97);
		p5.add(b30);
		
		b31 = new JButton("MÃ³n 7");
		b31.setIcon(new ImageIcon("src/Picture/capu.png"));
		b31.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b31_actionPerformed(e);
			}
		});
		b31.setBounds(10, 331, 137, 97);
		p5.add(b31);
		
		b32 = new JButton("MÃ³n 8");
		b32.setIcon(new ImageIcon("src/Picture/latte.png"));
		b32.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b32_actionPerformed(e);
			}
		});
		b32.setBounds(169, 331, 137, 97);
		p5.add(b32);
		
		b33 = new JButton("MÃ³n 9");
		b33.setIcon(new ImageIcon("src/Picture/phan xi păngg.png"));
		b33.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b33_actionPerformed(e);
			}
		});
		b33.setBounds(10, 438, 137, 97);
		p5.add(b33);
		
		b35 = new JButton("mÃ³n 10");
		b35.setIcon(new ImageIcon("src/Picture/matcha coco lattee.png"));
		b35.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b35_actionPerformed(e);
			}
		});
		b35.setBounds(169, 438, 137, 97);
		p5.add(b35);
		
		b36 = new JButton("MÃ³n 11");
		b36.setIcon(new ImageIcon("src/Picture/ô long nhiệt đớii.png"));
		b36.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b36_actionPerformed(e);
			}
		});
		b36.setBounds(10, 545, 137, 97);
		p5.add(b36);
		
		b37 = new JButton("MÃ³n 12");
		b37.setIcon(new ImageIcon("src/Picture/espresso.png"));
		b37.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_b37_actionPerformed(e);
			}
		});
		b37.setBounds(169, 545, 137, 97);
		p5.add(b37);
		
		JPanel p6 = new JPanel();
		p6.setBounds(501, 607, 495, 117);
		contentPane.add(p6);
		
		JButton b38 = new JButton("Time");
		b38.setBounds(10, 10, 145, 30);
		b38.setForeground(new Color(168, 147, 103));
		Font ba38b = new Font(".VnVogue", Font.BOLD, 15);
		p6.setLayout(null);
		b38.setFont(ba38b);
		b38.setBackground(Color.BLACK);
		p6.add(b38);
		
		textField = new JTextField();
		textField.setBounds(188, 16, 96, 19);
		p6.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 56, 96, 19);
		p6.add(textField_1);
		textField_1.setColumns(10);
		
		textField.setEditable(false);
		textField_1.setEditable(false);
		textField.setBorder(new EmptyBorder(0,0,0,0));
		textField_1.setBorder(new EmptyBorder(0,0,0,0));
		
		
		
		
		
		JButton b39 = new JButton("Date");
		b39.setBounds(10, 50, 145, 30);
		b39.setForeground(new Color(168, 147, 103));
		Font ba39b = new Font(".VnVogue", Font.BOLD, 15);
		b39.setFont(ba39b);
		b39.setBackground(Color.BLACK);
		p6.add(b39);
		
		JLabel lbl6 = new JLabel("Product");
		lbl6.setForeground(new Color(168, 147, 103));
		Font ba6 = new Font("Forte", Font.BOLD, 20);
		lbl6.setFont(ba6);
		lbl6.setBounds(501, 21, 236, 21);
		contentPane.add(lbl6);
		
		JLabel lbl7 = new JLabel("Drink");
		lbl7.setForeground(new Color(168, 147, 103));
		Font ba7 = new Font("Forte", Font.BOLD, 20);
		lbl7.setFont(ba7);
		lbl7.setBounds(1006, 21, 163, 21);
		contentPane.add(lbl7);
		
		JLabel lbl8 = new JLabel("Money");
		lbl8.setForeground(new Color(168, 147, 103));
		Font ba8 = new Font("Forte", Font.BOLD, 20);
		lbl8.setFont(ba8);
		lbl8.setBounds(501, 420, 129, 22);
		contentPane.add(lbl8);
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		loaddatatoarraylist();
		loadarraylisttotable();
		
	}
	
	protected void do_b17_actionPerformed(ActionEvent e){
		Food1 k2 = new Food1(this,"Bánh Flan",15000, datetime);
		k2.setVisible(true);
	}
	
	protected void do_b18_actionPerformed(ActionEvent e){
		Food1 k3 = new Food1(this,"Bánh cá",10000, datetime);
		k3.setVisible(true);
	}
	
	protected void do_b19_actionPerformed(ActionEvent e){
		Food1 k4 = new Food1(this,"Mousse trà xanh",30000, datetime);
		k4.setVisible(true);
	}
	
	protected void do_b20_actionPerformed(ActionEvent e){
		Food1 k5 = new Food1(this,"Tiramisu",30000, datetime);
		k5.setVisible(true);
	}
	
	protected void do_b26_actionPerformed(ActionEvent e){
		Food1 k26 = new Food1(this,"Trà Sữa Thái Xanh",18000, datetime);
		k26.setVisible(true);
	}
	
	protected void do_b27_actionPerformed(ActionEvent e){
		Food1 k27 = new Food1(this,"Phindi kem sữa",55000, datetime);
		k27.setVisible(true);
	}
	
	protected void do_b28_actionPerformed(ActionEvent e){
		Food1 k28 = new Food1(this,"Trà Thạch Vải",35000, datetime);
		k28.setVisible(true);
	}
	
	protected void do_b29_actionPerformed(ActionEvent e){
		Food1 k29 = new Food1(this,"Phin Sữa Đá",25000, datetime);
		k29.setVisible(true);
	}
	
	protected void do_b30_actionPerformed(ActionEvent e){
		Food1 k30 = new Food1(this,"Freeze trà xanh",60000, datetime);
		k30.setVisible(true);
	}
	
	protected void do_b31_actionPerformed(ActionEvent e){
		Food1 k31 = new Food1(this,"Cappuccino",33000, datetime);
		k31.setVisible(true);
	}
	
	protected void do_b32_actionPerformed(ActionEvent e){
		Food1 k32 = new Food1(this,"Latte",35000, datetime);
		k32.setVisible(true);
	}
	
	protected void do_b33_actionPerformed(ActionEvent e){
		Food1 k33 = new Food1(this,"Phan Xi Păng",40000, datetime);
		k33.setVisible(true);
	}
	
	protected void do_b34_actionPerformed(ActionEvent e) {
		Food1 k = new Food1(this,"Thái Đỏ Caramel",30000, datetime);
		k.setVisible(true);
		
	}
	
	protected void do_b35_actionPerformed(ActionEvent e){
		Food1 k35 = new Food1(this,"Matcha Coco Latte",35000, datetime);
		k35.setVisible(true);
	}
	
	protected void do_b36_actionPerformed(ActionEvent e){
		Food1 k36 = new Food1(this,"Ô long nhiệt đới",45000, datetime);
		k36.setVisible(true);
	}
	
	protected void do_b37_actionPerformed(ActionEvent e){
		Food1 k37 = new Food1(this,"Espresso",37000, datetime);
		k37.setVisible(true);
	}



	
	public void loaddatatoarraylist() {
		try {
			Class.forName(driver);
			Connection conn = Connect.connecting();

			String sql = "select * from dbo.thucpham";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list.clear();
			while (rs.next()) {
				String douong1 = rs.getString(1);
				double giatien = rs.getDouble(2);
				int soluong = rs.getInt(3);
				thanhtien = rs.getDouble(4);
				Drink1  k = new Drink1(douong1, giatien, soluong,thanhtien);
				list.add(k);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loadarraylisttotable() {
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		DecimalFormat decimalFormat = new DecimalFormat("#.###");

		for (Drink1 k : list) {

			String formattedGiaTien = decimalFormat.format(k.giatien);
			String formattedThanhTien = decimalFormat.format(k.giatien * k.soluong);

			model.addRow(new Object[] { k.douong, formattedGiaTien, k.soluong, formattedThanhTien });
		}
	}
	protected void do_b1_actionPerformed(ActionEvent e) {
			
	}
	protected void do_b22_actionPerformed(ActionEvent e) {
		Food1 k40 = new Food1(this,"Esp",37000, datetime);
		k40.setVisible(true);
	}
	protected void do_b23_actionPerformed(ActionEvent e) {
		Food1 k41 = new Food1(this,"Latte",37000, datetime);
		k41.setVisible(true);
	}
	public void Mainjf() {
		this.dispose();
		Main M = new Main(driver);
		M.setVisible(true);
	}
	
	protected void do_b21_actionPerformed(ActionEvent e) {
	    try (Connection conn = Connect.connecting();
	         PreparedStatement ps = conn.prepareStatement("SELECT SUM(thanhtien) AS totalAmount FROM dbo.thucpham");
	         ResultSet rs = ps.executeQuery()) {
	         
	        if (rs.next()) {
	            double totalAmount = rs.getDouble("totalAmount");

	            // Định dạng số tiền
	            DecimalFormat decimalFormat = new DecimalFormat("#.###");
	            String formattedTotalAmount = decimalFormat.format(totalAmount);
	            tongtien.setText(formattedTotalAmount);

	            // Lấy số tiền khách trả
	            String guestMoneyText = guestmoney.getText();
	            if (!guestMoneyText.isEmpty()) {
	                try {
	                    double khachTraAmount = Double.parseDouble(guestMoneyText);

	                    // Tính tiền thừa
	                    double changeAmount = khachTraAmount - totalAmount;
	                    String formattedChangeAmount = decimalFormat.format(changeAmount);
	                    tienthua.setText(formattedChangeAmount);
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số cho số tiền khách trả.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
	                }
	            } else {
	                tienthua.setText("0"); // Trường hợp số tiền khách trả bị bỏ trống
	            }
	        }
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi tính tổng tiền: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    }
	}

	protected void do_cBox_actionPerformed(ActionEvent e) {
		b24.setVisible(true);
	}
	protected void do_b24_actionPerformed(ActionEvent e) {
		 try {
		        Date currentDate = new Date();
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ,  HH:mm:ss");
		        String formattedDate = dateFormat.format(currentDate);

		        double totalAmount = Double.parseDouble(tongtien.getText());

		        String invoiceContent = "Date: " + formattedDate + "\n";
		        invoiceContent += "Total Amount: " + formattedTotalAmount + "\n";

		        
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        for (int i = 0; i < model.getRowCount(); i++) {
		            String drinkName = model.getValueAt(i, 0).toString();
		            String price = model.getValueAt(i, 1).toString();
		            String quantity = model.getValueAt(i, 2).toString();
		            String subtotal = model.getValueAt(i, 3).toString();

		            invoiceContent += "Item: " + drinkName + ", Price: " + price + ", Quantity: "
		                    + quantity + ", Subtotal: " + subtotal + "\n";
		        }

		        
		        String tableNumber = "1"; 
		        invoiceContent += "Table Number: " + tableNumber + "\n";

		        String filePath = "D:\\Bill\\BillMoney.txt";
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
		            writer.write(invoiceContent);
		            System.out.println("Invoice saved to: " + filePath);
		        } catch (IOException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(this, "Error while saving the invoice.", "Error",
		                    JOptionPane.ERROR_MESSAGE);
		        }
		    } catch (NumberFormatException e1) {
		        JOptionPane.showMessageDialog(this, "Please calculate total amount first.", "Error",
		                JOptionPane.ERROR_MESSAGE);
		    }
		}
	}
	
	


