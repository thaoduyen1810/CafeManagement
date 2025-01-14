package Food;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Drink.Drink1;
import Code.Connect;
import Code.Service;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Food1 extends JFrame {
	private ArrayList<Drink1> list;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textsoluong;
	private JButton btnhuy;
	private JButton btnthem;
    private Service k;
    private String namefood;
    private int money;
    private final String date;
    
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=thailam";
    String user = "sa";
    String password = "123456789";
    ResultSet rs;
    private AbstractButton table;
	public Food1(Service  k,String namefood, int money, final String date) {
		
		this.namefood=namefood;
		this.money=money;
		this.date=date;
		
		list= new ArrayList<Drink1>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông Tin:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 22, 112, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnSnPhm = new JLabel("Tên Sản Phẩm:");
		lblTnSnPhm.setFont(new Font("Arial", Font.BOLD, 15));
		lblTnSnPhm.setBounds(10, 80, 125, 23);
		contentPane.add(lblTnSnPhm);
		
		JLabel lblGiSnPhm = new JLabel("Giá Sản Phẩm:");
		lblGiSnPhm.setFont(new Font("Arial", Font.BOLD, 15));
		lblGiSnPhm.setBounds(10, 134, 112, 23);
		contentPane.add(lblGiSnPhm);
		
		JLabel lblSLng = new JLabel("Số Lượng:");
		lblSLng.setFont(new Font("Arial", Font.BOLD, 15));
		lblSLng.setBounds(10, 183, 112, 23);
		contentPane.add(lblSLng);
		
		JLabel lblcaccao = new JLabel(namefood);
		lblcaccao.setFont(new Font("Arial", Font.BOLD, 15));
		lblcaccao.setBounds(187, 80, 185, 23);
		contentPane.add(lblcaccao);
		
		JLabel lblNewLabel_5 = new JLabel(money+"");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(187, 134, 112, 23);
		contentPane.add(lblNewLabel_5);
		
		textsoluong = new JTextField();
		textsoluong.setBounds(185, 183, 187, 28);
		contentPane.add(textsoluong);
		textsoluong.setColumns(10);
		
		btnhuy = new JButton("Hủy");
		btnhuy.setBackground(Color.DARK_GRAY);
		btnhuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnhuy_actionPerformed(e);
			}
		});
		btnhuy.setForeground(new Color(168, 147, 103));
		Font bhuy = new Font("Arial", Font.BOLD, 18);
		btnhuy.setFont(bhuy);
		btnhuy.setBounds(118, 267, 112, 55);
		contentPane.add(btnhuy);
		
		btnthem = new JButton("Thêm");
		btnthem.setBackground(Color.DARK_GRAY);
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnthem_actionPerformed(e, date);
			}
		});
		btnthem.setForeground(new Color(168, 147, 103));
		Font bc = new Font("Arial", Font.BOLD, 18);
		btnthem.setFont(bc);
		btnthem.setBounds(254, 267, 125, 55);
		contentPane.add(btnthem);
		loadDataTableArrayList();
        this.k = k;
	}
	public void loadDataTableArrayList() {
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
                double thanhtien = rs.getDouble(4);
                Date date = rs.getDate(5);
                Drink1 k = new Drink1(douong1, giatien, soluong, thanhtien, date);
                list.add(k);
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	protected void do_btnhuy_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	protected void do_btnthem_actionPerformed(ActionEvent e, String date) {
		try {
            int row = 0;
            Class.forName(driver);
            Connection conn = Connect.connecting();
            String sql = " INSERT INTO dbo.thucpham values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, namefood);
            ps.setInt(2, money);
            ps.setInt(3, Integer.parseInt(textsoluong.getText()));
            ps.setInt(4, money * Integer.parseInt(textsoluong.getText()));
            ps.setString(5, date);

            row = ps.executeUpdate();
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Successfully");
            } else {
                JOptionPane.showConfirmDialog(this, "Fail");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(this, "error");
        }
		System.out.println(date);
       k.loaddatatoarraylist();
       k.loadarraylisttotable();
    }
	}
