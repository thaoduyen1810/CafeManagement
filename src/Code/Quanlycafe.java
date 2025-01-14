package Code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

class ImagePanel extends JPanel {
    private BufferedImage backgroundImage;

    public ImagePanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

public class Quanlycafe extends JFrame{
	JTextField txtID, txtMK;
	JButton bt1, bt2;
	public Quanlycafe(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	
	public void addEvents()
	{
		bt1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                String inputID = txtID.getText();
                String inputMK = txtMK.getText();

                // Thay đổi giá trị dưới đây để phản ánh thông tin đăng nhập chính xác
                String correctID = "HOABUCU";
                String correctMK = "0123456";

                if (inputID.equals(correctID) && inputMK.equals(correctMK)) {
                    JOptionPane.showMessageDialog(Quanlycafe.this, "Đăng nhập thành công!");
                } else {
                    JOptionPane.showMessageDialog(Quanlycafe.this, "Đăng nhập không thành công. Vui lòng kiểm tra lại!");
                }
			}
		});
	}
	public void addControls()
	{
		Container con = getContentPane();
		
		ImagePanel backgroundPanel = new ImagePanel("src/Picture/coffee-2179009_640.jpg");
        backgroundPanel.setLayout(new BorderLayout());
        con.add(backgroundPanel);

        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lblID = new JLabel("ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(lblID, gbc);

        txtID = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        loginPanel.add(txtID, gbc);

        JLabel lblMK = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(lblMK, gbc);

        txtMK = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginPanel.add(txtMK, gbc);

        bt1 = new JButton("OK");
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(bt1, gbc);

        bt2 = new JButton("Help");
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginPanel.add(bt2, gbc);

        backgroundPanel.add(loginPanel, BorderLayout.CENTER);
		

		
	}
	public void showWindow()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(640, 426);
		this.setLocationRelativeTo(null);
		this.setState(MAXIMIZED_BOTH);		
	}

}
