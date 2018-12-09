package Boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FrmLapHoaDon extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField txtMaHoaDon;
	private JTextField txtNgayBan;
	private JTextField txtMaNhanVien;
	private JTextField txtTenKhachHang;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtSoLuong;
	private JTextField txtTenSach;
	private JTextField txtDonGia;
	private JTextField txtGiamGia;
	private JTextField txtThanhTien;
	private JTable table = new JTable();
	
	private DefaultTableModel tableModel = new DefaultTableModel();
	
	String [] title = new String[] {"STT", "Mã hàng", "Tên hàng", "Số lượng", "Đơn giá", "Giảm giá %", "Thành tiền"};
	private JTextField txtTongTien;
	private JTextField txtMaSach;
	private JTextField txtSearch;
	
	public FrmLapHoaDon() {
		init();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 922);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public void init() {
		getContentPane().setBackground(new Color(224, 255, 255));
		setBackground(new Color(0, 191, 255));
		getContentPane().setLayout(null);
		
		JLabel lblH = new JLabel("HÓA ĐƠN BÁN SÁCH");
		lblH.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblH.setForeground(new Color(0, 0, 255));
		lblH.setBounds(270, 13, 311, 52);
		getContentPane().add(lblH);
		
		JLabel lblThngTinChung = new JLabel("Thông tin chung");
		lblThngTinChung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThngTinChung.setBounds(25, 62, 130, 24);
		getContentPane().add(lblThngTinChung);
		
		JLabel lblMHan = new JLabel("Mã hóa đơn");
		lblMHan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMHan.setForeground(Color.BLUE);
		lblMHan.setBounds(58, 90, 97, 24);
		getContentPane().add(lblMHan);
		
		JLabel lblNgyBn = new JLabel("Ngày bán");
		lblNgyBn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyBn.setForeground(Color.BLUE);
		lblNgyBn.setBounds(58, 126, 82, 22);
		getContentPane().add(lblNgyBn);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setBounds(155, 92, 144, 22);
		getContentPane().add(txtMaHoaDon);
		txtMaHoaDon.setColumns(10);
		
		txtNgayBan = new JTextField();
		txtNgayBan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgayBan.setBounds(155, 127, 144, 22);
		getContentPane().add(txtNgayBan);
		txtNgayBan.setColumns(10);
		
		JLabel lblMKhchHng = new JLabel("Tên khách hàng");
		lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMKhchHng.setForeground(Color.BLUE);
		lblMKhchHng.setBounds(400, 91, 112, 22);
		getContentPane().add(lblMKhchHng);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblaCh.setForeground(Color.BLUE);
		lblaCh.setBounds(400, 126, 60, 22);
		getContentPane().add(lblaCh);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinThoi.setForeground(Color.BLUE);
		lblSinThoi.setBounds(400, 157, 112, 32);
		getContentPane().add(lblSinThoi);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMNhnVin.setForeground(Color.BLUE);
		lblMNhnVin.setBounds(58, 164, 115, 19);
		getContentPane().add(lblMNhnVin);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaNhanVien.setBounds(155, 163, 144, 22);
		getContentPane().add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenKhachHang.setBounds(524, 92, 144, 22);
		getContentPane().add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiaChi.setBounds(524, 127, 144, 22);
		getContentPane().add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoDienThoai.setBounds(524, 163, 144, 22);
		getContentPane().add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		JLabel lblThngTinMt = new JLabel("Thông tin mặt hàng");
		lblThngTinMt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThngTinMt.setBounds(25, 197, 170, 24);
		getContentPane().add(lblThngTinMt);
		
		JLabel lblMHng = new JLabel("Mã sách");
		lblMHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMHng.setForeground(Color.BLUE);
		lblMHng.setBounds(58, 230, 67, 28);
		getContentPane().add(lblMHng);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSLng.setForeground(Color.BLUE);
		lblSLng.setBounds(58, 268, 82, 34);
		getContentPane().add(lblSLng);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoLuong.setBounds(155, 274, 116, 22);
		getContentPane().add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JLabel lblTnSch = new JLabel("Tên sách");
		lblTnSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSch.setForeground(Color.BLUE);
		lblTnSch.setBounds(296, 230, 75, 28);
		getContentPane().add(lblTnSch);
		
		txtTenSach = new JTextField();
		txtTenSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenSach.setEditable(false);
		txtTenSach.setBounds(383, 233, 116, 22);
		getContentPane().add(txtTenSach);
		txtTenSach.setColumns(10);
		
		JLabel lblnGi = new JLabel("Đơn giá");
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblnGi.setForeground(Color.BLUE);
		lblnGi.setBounds(534, 230, 75, 28);
		getContentPane().add(lblnGi);
		
		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDonGia.setEditable(false);
		txtDonGia.setBounds(621, 233, 116, 22);
		getContentPane().add(txtDonGia);
		txtDonGia.setColumns(10);
		
		JLabel lblGimGi = new JLabel("Giảm giá %");
		lblGimGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGimGi.setForeground(Color.BLUE);
		lblGimGi.setBounds(296, 268, 97, 34);
		getContentPane().add(lblGimGi);
		
		txtGiamGia = new JTextField();
		txtGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGiamGia.setBounds(383, 274, 116, 22);
		getContentPane().add(txtGiamGia);
		txtGiamGia.setColumns(10);
		
		JLabel lblThnhTin = new JLabel("Thành tiền");
		lblThnhTin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThnhTin.setForeground(Color.BLUE);
		lblThnhTin.setBounds(532, 268, 91, 34);
		getContentPane().add(lblThnhTin);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtThanhTien.setEditable(false);
		txtThanhTien.setBounds(621, 274, 116, 22);
		getContentPane().add(txtThanhTien);
		txtThanhTien.setColumns(10);
		
		tableModel.setColumnIdentifiers(title);
		table.setBorder(new EmptyBorder(1, 1, 1, 1));
		table.setBackground(new Color(255, 250, 250));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(tableModel);

		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(53, 325, 684, 196);
		getContentPane().add(panel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new EmptyBorder(1, 1, 1, 1));
		panel.add(scrollPane);
		
		JLabel lblNhpp = new JLabel("Nhấp đúp để xóa một dòng ");
		lblNhpp.setForeground(Color.RED);
		lblNhpp.setBounds(35, 560, 178, 16);
		getContentPane().add(lblNhpp);
		
		JLabel lblNewLabel = new JLabel("Bằng chữ :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(28, 597, 112, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTongTien = new JLabel("Không đồng");
		lblTongTien.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setBounds(131, 593, 168, 32);
		getContentPane().add(lblTongTien);
		
		JLabel lblTngTin = new JLabel("Tổng tiền");
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTngTin.setForeground(Color.BLUE);
		lblTngTin.setBounds(383, 554, 91, 28);
		getContentPane().add(lblTngTin);
		
		txtTongTien = new JTextField();
		txtTongTien.setForeground(Color.BLUE);
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(482, 557, 183, 24);
		getContentPane().add(txtTongTien);
		txtTongTien.setColumns(10);
		
		JLabel lblng = new JLabel("đồng");
		lblng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblng.setForeground(Color.BLUE);
		lblng.setBounds(674, 557, 69, 21);
		getContentPane().add(lblng);
		
		JButton btnAdd = new JButton("Thêm sách");
		btnAdd.setBackground(new Color(240, 248, 255));
		btnAdd.setForeground(Color.BLUE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icon_add.png"));
		btnAdd.setBounds(12, 646, 183, 57);
		btnAdd.addActionListener(this);
		getContentPane().add(btnAdd);
	
		txtMaSach = new JTextField();
		txtMaSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaSach.setBounds(155, 233, 116, 22);
		getContentPane().add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JButton btnSave = new JButton("Lưu hóa đơn");
		btnSave.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-save-as-40.png"));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setForeground(Color.BLUE);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBackground(new Color(240, 248, 255));
		btnSave.setBounds(207, 646, 183, 57);
		btnSave.addActionListener(this);
		getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Hủy hóa đơn");
		btnCancel.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-delete-40.png"));
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel.setForeground(Color.BLUE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(new Color(240, 248, 255));
		btnCancel.setBounds(400, 646, 183, 57);
		btnCancel.addActionListener(this);
		getContentPane().add(btnCancel);
		
		JButton btnExport = new JButton("In hóa đơn");
		btnExport.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-export-40.png"));
		btnExport.setHorizontalAlignment(SwingConstants.LEFT);
		btnExport.setForeground(Color.BLUE);
		btnExport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExport.setBackground(new Color(240, 248, 255));
		btnExport.setBounds(593, 646, 183, 57);
		btnExport.addActionListener(this);
		getContentPane().add(btnExport);
		
		JLabel lblMHan_1 = new JLabel("Mã hóa đơn");
		lblMHan_1.setForeground(Color.BLUE);
		lblMHan_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMHan_1.setBounds(131, 750, 120, 32);
		getContentPane().add(lblMHan_1);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSearch.setBounds(230, 746, 284, 39);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-search-40 (1).png"));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBackground(new Color(240, 248, 255));
		btnSearch.setBounds(540, 742, 150, 49);
		btnSearch.addActionListener(this);
		getContentPane().add(btnSearch);
		
		JButton btnBack = new JButton("Quay lại");
		btnBack.addActionListener(this);
		btnBack.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\QuanTriDuAnPhanMem\\image\\icons8-back-40.png"));
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBackground(new Color(240, 248, 255));
		btnBack.setBounds(12, 813, 150, 49);
		getContentPane().add(btnBack);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Thêm sách") {
		String[] list = {	"1", txtMaSach.getText(), "Dac Nhan Tam" , txtSoLuong.getText() , "54.000" ,txtGiamGia.getText() , "54.000"};
		tableModel.addRow(list);
		}
		if(e.getActionCommand() == "Lưu hóa đơn") {
			//Action của Button Lưu hóa đơn
		}
		if(e.getActionCommand() == "Hủy hóa đơn") {
			//Action của Button Hủy hóa đơn
		}
		if(e.getActionCommand() == "In hóa đơn") {
			//Action của Button In hóa đơn
		}
		if(e.getActionCommand() == "Tìm kiếm") {
			//Action của Button Tìm kiếm hóa đơn
			while (tableModel.getRowCount()>0)
	        {
	            tableModel.removeRow(0);
	        }
			String[] list = {	"1", "B02", "Computer networking" , "1" , "60.000" , "10%" , "54.000"};
			String[] list2 = { "2", "B01" ,"Dac Nhan Tam" , "1" , "100.000" ,"10%" , "90.000" } ;
			tableModel.addRow(list);
			tableModel.addRow(list2);
		}
		if(e.getActionCommand() == "Quay lại") {
			new FrmChucNangNguoiDung();
			dispose();
		}
		
	}
	public static void main(String[] args) {
		new FrmLapHoaDon();
		
	}
}
