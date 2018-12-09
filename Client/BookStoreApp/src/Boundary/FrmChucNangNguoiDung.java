package Boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class FrmChucNangNguoiDung extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	public FrmChucNangNguoiDung() {
		init();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(976, 617);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public void init() {
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblThngTinNgi = new JLabel("THÔNG TIN NGƯỜI DÙNG");
		lblThngTinNgi.setForeground(Color.BLUE);
		lblThngTinNgi.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblThngTinNgi.setBounds(283, 16, 365, 66);
		getContentPane().add(lblThngTinNgi);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("image\\icons8-administrator-male-80.png"));
		lblNewLabel.setBounds(40, 99, 116, 115);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ và Tên : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(248, 114, 94, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblChcV = new JLabel("Chức Vụ :");
		lblChcV.setForeground(Color.BLUE);
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChcV.setBounds(248, 219, 94, 24);
		getContentPane().add(lblChcV);
		
		
		JLabel lblId = new JLabel("ID : ");
		lblId.setForeground(Color.BLUE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(248, 168, 94, 24);
		getContentPane().add(lblId);
		
		JLabel lblTen = new JLabel("");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTen.setForeground(Color.BLUE);
		lblTen.setBounds(446, 114, 222, 24);
		getContentPane().add(lblTen);
		
		
		JLabel lblID = new JLabel("");
		lblID.setForeground(Color.BLUE);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblID.setBounds(446, 168, 222, 24);
		getContentPane().add(lblID);
		
		JLabel lblChucVu = new JLabel("");
		lblChucVu.setForeground(Color.BLUE);
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChucVu.setBounds(446, 219, 222, 24);
		getContentPane().add(lblChucVu);
		
		JLabel lblChcNng = new JLabel("Chức năng :");
		lblChcNng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChcNng.setBounds(97, 292, 173, 37);
		getContentPane().add(lblChcNng);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(245, 255, 250));
		btnTimKiem.setIcon(new ImageIcon("image\\icons8-search-40.png"));
		btnTimKiem.setForeground(Color.BLUE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.addActionListener(this);
		btnTimKiem.setBounds(83, 349, 187, 66);
		
		getContentPane().add(btnTimKiem);
		
		JButton btnQuanLy = new JButton("Quản lý");
		btnQuanLy.setBackground(new Color(245, 255, 250));
		btnQuanLy.setIcon(new ImageIcon("image\\icons8-maintenance-30.png"));
		btnQuanLy.setForeground(Color.BLUE);
		btnQuanLy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQuanLy.setBounds(337, 349, 173, 66);
		btnQuanLy.addActionListener(this);
		getContentPane().add(btnQuanLy);
		
		JButton btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setBackground(new Color(245, 255, 250));
		btnLapHoaDon.setIcon(new ImageIcon("image\\icons8-invoice-40.png"));
		btnLapHoaDon.setForeground(Color.BLUE);
		btnLapHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLapHoaDon.setBounds(568, 460, 180, 66);
		btnLapHoaDon.addActionListener(this);
		getContentPane().add(btnLapHoaDon);
		
		JButton btnTaoTaiKhoan = new JButton("Tạo tài khoản");
		btnTaoTaiKhoan.setBackground(new Color(245, 255, 250));
		btnTaoTaiKhoan.setIcon(new ImageIcon("image\\icons8-account-40.png"));
		btnTaoTaiKhoan.setForeground(Color.BLUE);
		btnTaoTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTaoTaiKhoan.setBounds(337, 460, 173, 66);
		btnTaoTaiKhoan.addActionListener(this);
		getContentPane().add(btnTaoTaiKhoan);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setBackground(new Color(245, 255, 250));
		btnThongKe.setIcon(new ImageIcon("image\\icon_thongke.png"));
		btnThongKe.setForeground(Color.BLUE);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThongKe.setBounds(83, 460, 184, 66);
		btnThongKe.addActionListener(this);
		getContentPane().add(btnThongKe);
		setBackground(new Color(224, 255, 255));
		
		//set value
		lblTen.setText(FrmLogin.user.getName());
		lblID.setText(String.valueOf(FrmLogin.user.getId()));
		lblChucVu.setText(FrmLogin.user.getChucVu());
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("image\\icons8-shutdown-40.png"));
		btnThoat.setForeground(Color.BLUE);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoat.setBackground(new Color(245, 255, 250));
		btnThoat.setBounds(790, 349, 180, 66);
		btnThoat.addActionListener(this);
		getContentPane().add(btnThoat);
		
		JButton btnNewButton = new JButton("Chat");
		btnNewButton.setSize(180, 68);
		btnNewButton.setLocation(568, 348);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(this);
		
		getContentPane().add(btnNewButton);
		if(FrmLogin.user.getChucVu().equals("Nhan vien"))
		{
			btnThongKe.setVisible(false);
			btnTaoTaiKhoan.setVisible(false);
			btnQuanLy.setVisible(false);
		}
		else if(FrmLogin.user.getChucVu().equals("Thu kho"))
		{
			btnThongKe.setVisible(false);
			btnTaoTaiKhoan.setVisible(false);
			btnLapHoaDon.setVisible(false);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Tìm kiếm") {
			this.dispose();
			new FrmTimKiemSach();
		}
		if(e.getActionCommand() == "Quản lý") {
			this.dispose();
			new FrmQuanLy();
		}
		if(e.getActionCommand() == "Chat") {
			this.dispose();
			new FrmChat();
		}
		if(e.getActionCommand() == "Lập hóa đơn") {
			this.dispose();
			new FrmLapHoaDon();
		}
		if(e.getActionCommand() == "Thống kê") {
			this.dispose();
			new FrmThongKe();
		}
		if(e.getActionCommand() == "Tạo tài khoản") {
			dispose();
			new FrmTaoTaiKhoan();
		}
		if(e.getActionCommand() == "Thoát") {
			String[] list;
			FrmLogin.sockobj.SendDisconnect();
			String packet = FrmLogin.sockobj.RecievedPacket();
			list = FrmLogin.sockobj.HandlePacket(packet);
			if(list != null && list[0] != "error connection")
			{
			System.out.println("Close connection");
			FrmLogin.sockobj.CloseConnection();
			}
			new FrmLogin();
			dispose();
		}
	}
	public static void main(String[] args) {
		new FrmChucNangNguoiDung();
	}
}
