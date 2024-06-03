package todolist_official;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

import java.security.MessageDigest;
public class UserRegistration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	Connection con =null;
	Statement stm = null;
	ResultSet rs = null;
	private JTextField tUserName;
	private JTextField tEmail;
	private JPasswordField tPassword;
	


	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration  frame = new UserRegistration ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static String passwordHash (String password) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		byte [] messageDigest =md.digest(password.getBytes());
		BigInteger bigInt = new BigInteger(1,messageDigest);
		return bigInt.toString(16);
	
	}


	/**
	 * Create the frame.
	 */
	public UserRegistration () {
		super("UserRegistration ");
		 try {
			con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/cuoiky?useSSL=false","root","19052005");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 744, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");		
		lblNewLabel.setBounds(0, 0, 379, 460);
		lblNewLabel.setIcon(new ImageIcon("plain.jpg"));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Register Form");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblNewLabel_1.setBounds(453, 10, 200, 35);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(414, 55, 120, 34);
		panel.add(lblNewLabel_2);
		
		tUserName = new JTextField();
		tUserName.setBounds(414, 87, 302, 31);
		panel.add(tUserName);
		tUserName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(414, 140, 132, 13);
		panel.add(lblNewLabel_3);
		
		tEmail = new JTextField();
		tEmail.setBounds(413, 163, 303, 31);
		panel.add(tEmail);
		tEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(414, 204, 164, 13);
		panel.add(lblNewLabel_4);
		
		tPassword = new JPasswordField();
		tPassword.setBounds(414, 228, 302, 31);
		panel.add(tPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   LoginPage login = new LoginPage();
	               login.setVisible(true);
	              
	            
			}
		});
		btnBack.setBounds(453, 317, 85, 35);
		panel.add(btnBack);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				   try {
						stm = con.createStatement();
						String stdMail = tEmail.getText();
					
						String stdName = tUserName.getText();
					
						String stdPass = passwordHash(tPassword.getText());
	                    String sql = "INSERT INTO dangnhap(Email,Password,Username) VALUES('" + stdMail + "','" + stdPass+ "','" + stdName + "')";
						stm.executeUpdate(sql);
	                    LoginPage frame = new LoginPage();
	                    frame.setVisible(true);
	                    JOptionPane.showMessageDialog((Component)null, "Đã cập nhật thành công");
	                } catch (Exception var7) {
	                    JOptionPane.showMessageDialog((Component)null, "Thông tin đã nhập không hợp lệ");
	                }
				   
			}
			
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(596, 317, 85, 35);
		panel.add(btnSubmit);
		
		
		
	
		
	}
}
