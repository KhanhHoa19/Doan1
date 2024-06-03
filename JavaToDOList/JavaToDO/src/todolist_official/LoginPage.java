package todolist_official;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField logEmail;
	private JPasswordField logPass;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String passwordHash (String password) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		byte [] messageDigest =md.digest(password.getBytes());
		BigInteger bigInt = new BigInteger(1,messageDigest);
		return bigInt.toString(16);
	
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(397, 152, 70, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(397, 244, 95, 27);
		contentPane.add(lblNewLabel_1);
		
		logEmail = new JTextField();
		logEmail.setBounds(397, 188, 221, 35);
		contentPane.add(logEmail);
		logEmail.setColumns(10);
		
		logPass = new JPasswordField();
		logPass.setBounds(397, 282, 221, 35);
		contentPane.add(logPass);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/cuoiky?useSSL=false","root","19052005");
					String Email = logEmail.getText();
					String password = UserRegistration.passwordHash(logPass.getText());
					
					Statement stm = con.createStatement();
					String sql ="select * from dangnhap where Email= '"+ Email+"'and Password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					
					if(rs.next()) {
						dispose();
						MainForm hpage = new MainForm();
						hpage.show();
					}else {
						JOptionPane.showMessageDialog(null, "username or password is wrong");
						logEmail.setText("");
						logPass.setText("");
					}
					con.close();
				}catch(Exception a) {
					
				}
					
			
			}
		});
		btnLogin.setBounds(589, 378, 123, 23);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Register");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				LoginPage login = new LoginPage();
				login.setVisible(false);
				login.dispose();	
				UserRegistration obj = new UserRegistration ();
				obj.setVisible(true);	
				login.dispose();	
				
			}
		});
		btnReset.setBounds(446, 378, 89, 23);
		contentPane.add(btnReset);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("log.png"));
		label.setBounds(443, 0, 141, 141);
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("login.jpg"));
		lblNewLabel_2.setBounds(0, 0, 345, 455);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("back.jpg"));
		lblNewLabel_3.setBounds(330, 0, 402, 455);
		contentPane.add(lblNewLabel_3);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
