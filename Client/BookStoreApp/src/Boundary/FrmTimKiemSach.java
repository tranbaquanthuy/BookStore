package Boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Connection.SocketClass;

public class FrmTimKiemSach extends JFrame implements ActionListener{
	private JTextField txtTenSach;
	private JTextField txtNamSanXuat;
	private JComboBox comboBox;
	private JCheckBox chbLoaiSach;
	private JCheckBox chbTacgia;
	SocketClass sockobj = FrmLogin.sockobj;

	private JTable table = new JTable(){
		public boolean isCellEditable(int row, int column) {                
	        return false;               
	           };
		};
	String [] title = new String[] {"STT", "Mã sách", "Tên sách", "Tác giả", "Loại Sách", "Giá bìa","Số lượng"};
	private DefaultTableModel tableModel = new DefaultTableModel();
	
	JButton btnSearchBasic = new JButton("Tìm kiếm");
	
	JButton btnSearchAdvance = new JButton("Tìm kiếm");
	
	public FrmTimKiemSach() {
		init();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1201, 671);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public void init() {
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblTmKimSch = new JLabel("TÌM KIẾM SÁCH");
		lblTmKimSch.setForeground(Color.BLUE);
		lblTmKimSch.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTmKimSch.setBounds(348, 28, 220, 39);
		getContentPane().add(lblTmKimSch);
		
		JLabel lblTmKimC = new JLabel("Tìm kiếm cơ bản");
		lblTmKimC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTmKimC.setBounds(12, 83, 109, 16);
		getContentPane().add(lblTmKimC);
		
		JLabel lblTnSch = new JLabel("Tên sách");
		lblTnSch.setForeground(Color.BLUE);
		lblTnSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSch.setBounds(24, 128, 70, 29);
		getContentPane().add(lblTnSch);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(92, 122, 135, 42);
		getContentPane().add(txtTenSach);
		txtTenSach.setColumns(10);
		
		
		btnSearchBasic.setBackground(new Color(245, 255, 250));
		btnSearchBasic.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearchBasic.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-search-40.png"));
		btnSearchBasic.setForeground(Color.BLUE);
		btnSearchBasic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearchBasic.setBounds(239, 117, 150, 50);
		btnSearchBasic.addActionListener(this);
		getContentPane().add(btnSearchBasic);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		horizontalBox.setBackground(Color.GRAY);
		horizontalBox.setBounds(12, 103, 393, 75);
		getContentPane().add(horizontalBox);
		
		JLabel lblTmKimNng = new JLabel("Tìm kiếm nâng cao");
		lblTmKimNng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTmKimNng.setBounds(12, 207, 131, 16);
		getContentPane().add(lblTmKimNng);
		
		chbLoaiSach = new JCheckBox("Loại sách");
		chbLoaiSach.setForeground(Color.BLUE);
		chbLoaiSach.setBackground(new Color(224, 255, 255));
		chbLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbLoaiSach.setBounds(24, 241, 113, 25);
		getContentPane().add(chbLoaiSach);
		
		chbTacgia = new JCheckBox("Tác Giả");
		chbTacgia.setForeground(Color.BLUE);
		chbTacgia.setBackground(new Color(224, 255, 255));
		chbTacgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbTacgia.setBounds(24, 290, 131, 25);
		getContentPane().add(chbTacgia);
		
		txtNamSanXuat = new JTextField();
		txtNamSanXuat.setBounds(160, 284, 155, 39);
		getContentPane().add(txtNamSanXuat);
		txtNamSanXuat.setColumns(10);
		
		JLabel lblKtQuTm = new JLabel("Kết quả tìm kiếm");
		lblKtQuTm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKtQuTm.setBounds(436, 83, 123, 16);
		getContentPane().add(lblKtQuTm);
		
		
		
		JButton btnDongY = new JButton("Đồng ý");
		btnDongY.setBackground(new Color(245, 255, 250));
		btnDongY.setHorizontalAlignment(SwingConstants.LEFT);
		btnDongY.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icon_login.png"));
		btnDongY.setForeground(Color.BLUE);
		btnDongY.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDongY.setBounds(802, 542, 150, 57);
		btnDongY.addActionListener(this);
		getContentPane().add(btnDongY);
		
		JButton btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.setBackground(new Color(245, 255, 250));
		btnHuyBo.setHorizontalAlignment(SwingConstants.LEFT);
		btnHuyBo.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-cancel-40.png"));
		btnHuyBo.setForeground(Color.BLUE);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHuyBo.setBounds(1017, 542, 131, 57);
		btnHuyBo.addActionListener(this);
		getContentPane().add(btnHuyBo);
		
		
		btnSearchAdvance.setBackground(new Color(245, 255, 250));
		btnSearchAdvance.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-search-40.png"));
		btnSearchAdvance.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearchAdvance.setForeground(Color.BLUE);
		btnSearchAdvance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearchAdvance.setBounds(101, 348, 160, 50);
		btnSearchAdvance.addActionListener(this);
		getContentPane().add(btnSearchAdvance);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBackground(Color.GRAY);
		horizontalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		horizontalBox_1.setBounds(12, 226, 393, 185);
		getContentPane().add(horizontalBox_1);
		
		
		tableModel.setColumnIdentifiers(title);
		table.setBorder(new EmptyBorder(1, 1, 1, 1));
		table.setBackground(new Color(255, 250, 250));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(tableModel);
		
		JPanel panel = new JPanel(new GridLayout(1,1));
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(436, 106, 712, 420);
		getContentPane().add(panel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new EmptyBorder(1, 1, 1, 1));
		panel.add(scrollPane);
		
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(160, 235, 155, 39);
		getContentPane().add(comboBox);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\QuanTriDuAnPhanMem\\image\\icons8-back-40.png"));
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBackground(new Color(245, 255, 250));
		btnBack.setBounds(755, 13, 150, 57);
		btnBack.addActionListener(this);
		getContentPane().add(btnBack);
		
	
		String[] list =  null;
		sockobj.SearchBook("1", "All");
		String packet = FrmLogin.sockobj.RecievedPacket();
list = sockobj.HandlePacket(packet);
		for(int i = 0 ; i < list.length/6 ; i++)
		{	
			String[] list2 =  {String.valueOf(i+1),list[6*i],list[6*i+1],list[6*i+2],list[6*i+3],list[6*i+4],list[6*i+5]};
			tableModel.addRow(list2);;
		}
		table.setModel(tableModel);	

		
		
		String[] list2 =  null;
		sockobj.SearchLoaiSach();
		String packet1 = FrmLogin.sockobj.RecievedPacket();
list2 = sockobj.HandlePacket(packet1);
		for(int i = 1 ; i < list2.length ; i = i+2)
		{	
			comboBox.addItem(list2[i]);
		}
		
	}

	
	   
	   
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Back") {
		    //this.setVisible(false);
		    this.dispose();
			new FrmChucNangNguoiDung();
		}
		if(e.getActionCommand() == "Đồng ý") {
			
		}
		if(e.getActionCommand() == "Hủy bỏ") {
			while (tableModel.getRowCount()>0)
	        {
	            tableModel.removeRow(0);
	        }
			String[] list =  null;
			SocketClass sockobj = new SocketClass();
			sockobj.SearchBook("1", "All");
			String packet = FrmLogin.sockobj.RecievedPacket();
list = sockobj.HandlePacket(packet);
			for(int i = 0 ; i < list.length/6 ; i++)
			{	
				String[] list2 =  {String.valueOf(i+1),list[6*i],list[6*i+1],list[6*i+2],list[6*i+3],list[6*i+4],list[6*i+5]};
				tableModel.addRow(list2);;
			}
			table.setModel(tableModel);	
		}
		if(e.getSource() == btnSearchBasic) {
			while (tableModel.getRowCount()>0)
	        {
	            tableModel.removeRow(0);
	        }
			String[] list =  null;
			SocketClass sockobj = new SocketClass();
			sockobj.SearchBook(txtTenSach.getText(), "tenSach");
			String packet = FrmLogin.sockobj.RecievedPacket();
list = sockobj.HandlePacket(packet);
			for(int i = 0 ; i < list.length/6 ; i++)
			{	
				String[] list2 =  {String.valueOf(i+1),list[6*i],list[6*i+1],list[6*i+2],list[6*i+3],list[6*i+4],list[6*i+5]};
				tableModel.addRow(list2);;
			}
			table.setModel(tableModel);	
		}
		if(e.getSource() == btnSearchAdvance) {
		  if(chbLoaiSach.isSelected() && chbTacgia.isSelected())
		  {
			  while (tableModel.getRowCount()>0)
		        {
		            tableModel.removeRow(0);
		        }
				String[] list =  null;
				SocketClass sockobj = new SocketClass();
				sockobj.SearchBookAdvanced(txtNamSanXuat.getText(), comboBox.getSelectedItem().toString());
				String packet = FrmLogin.sockobj.RecievedPacket();
list = sockobj.HandlePacket(packet);
				for(int i = 0 ; i < list.length/6 ; i++)
				{	
					String[] list2 =  {String.valueOf(i+1),list[6*i],list[6*i+1],list[6*i+2],list[6*i+3],list[6*i+4],list[6*i+5]};
					tableModel.addRow(list2);;
				}
				table.setModel(tableModel);	
		  }
		}
		
	}
	public static void main(String[] args) {
		new FrmTimKiemSach();
	}
	
}
