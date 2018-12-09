package Boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Connection.SocketClass;
import Entity.TaiKhoan;

public class FrmLogin extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	static TaiKhoan user;
	public static SocketClass sockobj = new SocketClass();
	public FrmLogin() {
		getContentPane().setBackground(new Color(224, 255, 255));
		init();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(976, 617);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void init() {
		getContentPane().setLayout(null);
		JLabel lblLogin = new JLabel("Đăng Nhập");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLogin.setForeground(new Color(0, 0, 255));
		lblLogin.setBounds(351, 87, 211, 37);
		getContentPane().add(lblLogin);
		
		JLabel lblUser = new JLabel("Tên Đăng Nhập");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUser.setBounds(226, 174, 159, 45);
		getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Mật Khẩu");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(226, 261, 159, 45);
		getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setToolTipText("");
		txtUsername.setBounds(444, 176, 202, 44);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(443, 261, 203, 48);
		getContentPane().add(passwordField);
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.setForeground(new Color(154, 205, 50));
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogin.setBackground(new Color(240, 255, 240));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setIcon(new ImageIcon("image\\icon_login.png"));
		btnLogin.addActionListener(this);
		btnLogin.setBounds(219, 401, 187, 76);
		getContentPane().add(btnLogin);
		JButton btnCancel = new JButton("Thoát");
		btnCancel.setForeground(Color.RED);
		btnCancel.setBackground(new Color(255, 228, 225));
		btnCancel.setIcon(new ImageIcon("image\\icon_cancel.png"));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.addActionListener(this);
		btnCancel.setBounds(459, 401, 187, 76);
		getContentPane().add(btnCancel);
		
		JCheckBox chckbxRememberPassword = new JCheckBox("Lưu mật khẩu ?");
		chckbxRememberPassword.setBackground(new Color(224, 255, 255));
		chckbxRememberPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxRememberPassword.setBounds(226, 342, 217, 25);
		getContentPane().add(chckbxRememberPassword);
		
		JButton button = new JButton("Get XML/HTML");
		button.setVisible(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new FrmGetXML();
			}
		});
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(new Color(154, 205, 50));
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBackground(new Color(240, 255, 240));
		button.setBounds(219, 485, 187, 76);
		getContentPane().add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Đăng nhập") {
		 if(txtUsername.getText().isEmpty()) 
		 {
				JOptionPane.showMessageDialog(null, "Tên đăng nhập trống!");
		 }
		 else if (passwordField.getPassword().length == 0 || passwordField.getPassword() == null)
		 {
			 JOptionPane.showMessageDialog(null, "Mật khẩu trống !");
		 }
		 else
		 {
			String[] list;
			
			try {
				String myPass=String.valueOf(passwordField.getPassword());
				sockobj.SendLogin(txtUsername.getText(), myPass);
				String packet = sockobj.RecievedPacket();
				list = sockobj.HandlePacket(packet);
				if(list != null && list[0] != "error connection" && list.length == 3)
				{
				JOptionPane.showMessageDialog(null, "Bạn đã đăng nhập thành công !");
				user  = new TaiKhoan(txtUsername.getText(), myPass,list[1],Integer.parseInt(list[0]),list[2]);
				new FrmChucNangNguoiDung();
				setVisible(false);
				}
				else  
				{
				JOptionPane.showMessageDialog(null, "Lỗi khi giao tiếp với máy chủ!");
				}
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Sai tên đăng nhập và mật khẩu");
			}
		 }
		}
		if(e.getActionCommand() == "Thoát") {
			dispose();
		}
		
	}

	public static void main(String [] args) {
		new FrmLogin();
	}
}
