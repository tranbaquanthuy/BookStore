package Boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Connection.SocketClass;

public class FrmQuanLy extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaLoaiSach;
	private JTextField txtTenLoaiSach;
	
	private JTable tableLoaiSach = new JTable(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {                
	        return false;               
	           };
		};
	String [] titleLoaiSach = new String[] {"STT", "Mã loại sách" , "Tên Loại Sách"};
	private DefaultTableModel tableModelLoaiSach = new DefaultTableModel();
	
	private JTable tableSach = new JTable() {
			/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {                
        return false;               
           };
	};
	String [] titleSach = new String[] {"STT", "Mã sách", "Tên sách", "Tác giả", "Loại sách", "Giá bìa","Tổng"};
	private DefaultTableModel tableModelSach = new DefaultTableModel();
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtGiaTien;
	private JTextField txtTenTacGia;
	private JComboBox<String> cbLoaiSach;
	private JButton btnAddLoaiSach = new JButton("Add new");
	private JButton btnSaveLoaiSach = new JButton("Save");
	private JButton btnUpdateLoaiSach = new JButton("Update");
	private JButton btnDeleteLoaiSach = new JButton("Delete");
	
	private JButton btnAddSach = new JButton("Add new");
	private JButton btnSaveSach = new JButton("Save");
	private JButton btnUpdateSach = new JButton("Update");
	private JButton btnDeleteSach = new JButton("Delete");
	private JTextField txtSoLuong;
	private JTextField textField;
	public FrmQuanLy() {
		setBackground(new Color(224, 255, 255));
		init();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(976, 617);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
	public void init() {
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(new Color(0, 0, 255));
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.setBackground(new Color(224, 255, 255));
		tabbedPane.setBounds(0, 0, 768, 462);
		getContentPane().add(tabbedPane);
		
		JPanel panelLoaiSach = new JPanel();
		panelLoaiSach.setForeground(new Color(224, 255, 255));
		panelLoaiSach.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Quản lý Loại Sách", null, panelLoaiSach, null);
		panelLoaiSach.setLayout(null);
		
		JLabel lblTnLoiSch = new JLabel("Tên Loại Sách");
		lblTnLoiSch.setForeground(Color.BLUE);
		lblTnLoiSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnLoiSch.setBounds(42, 94, 113, 26);
		panelLoaiSach.add(lblTnLoiSch);
		
		JLabel lblMLoiSch = new JLabel("Mã Loại Sách");
		lblMLoiSch.setForeground(Color.BLUE);
		lblMLoiSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMLoiSch.setBounds(42, 48, 113, 26);
		panelLoaiSach.add(lblMLoiSch);
		
		txtMaLoaiSach = new JTextField();
		txtMaLoaiSach.setEditable(false);
		txtMaLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaLoaiSach.setBounds(177, 45, 280, 33);
		panelLoaiSach.add(txtMaLoaiSach);
		txtMaLoaiSach.setColumns(10);
		
		txtTenLoaiSach = new JTextField();
		txtTenLoaiSach.setEditable(false);
		txtTenLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenLoaiSach.setColumns(10);
		txtTenLoaiSach.setBounds(177, 92, 280, 33);
		panelLoaiSach.add(txtTenLoaiSach);
		btnAddLoaiSach.setBackground(new Color(245, 255, 250));
		
		
		btnAddLoaiSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddLoaiSach.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icon_add.png"));
		btnAddLoaiSach.setForeground(Color.BLUE);
		btnAddLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddLoaiSach.setBounds(248, 161, 139, 49);
		btnAddLoaiSach.addActionListener(this);
		panelLoaiSach.add(btnAddLoaiSach);
		btnSaveLoaiSach.setBackground(new Color(245, 255, 250));
		
		
		btnSaveLoaiSach.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-save-as-40.png"));
		btnSaveLoaiSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnSaveLoaiSach.setForeground(Color.BLUE);
		btnSaveLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSaveLoaiSach.setBounds(97, 161, 139, 49);
		btnSaveLoaiSach.addActionListener(this);
		panelLoaiSach.add(btnSaveLoaiSach);
		btnUpdateLoaiSach.setBackground(new Color(245, 255, 250));
		
		btnUpdateLoaiSach.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-downloading-updates-30.png"));
		btnUpdateLoaiSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateLoaiSach.setForeground(Color.BLUE);
		btnUpdateLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateLoaiSach.setBounds(399, 161, 139, 49);
		btnUpdateLoaiSach.addActionListener(this);
		panelLoaiSach.add(btnUpdateLoaiSach);
		btnDeleteLoaiSach.setBackground(new Color(245, 255, 250));
		
		btnDeleteLoaiSach.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-delete-40.png"));
		btnDeleteLoaiSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeleteLoaiSach.setForeground(Color.BLUE);
		btnDeleteLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteLoaiSach.setBounds(553, 161, 139, 49);
		btnDeleteLoaiSach.addActionListener(this);
		panelLoaiSach.add(btnDeleteLoaiSach);
		
		JPanel panelSach = new JPanel();
		panelSach.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Quản lý Sách", null, panelSach, null);
		panelSach.setLayout(null);
		
		JLabel lblMSch = new JLabel("Mã Sách");
		lblMSch.setForeground(Color.BLUE);
		lblMSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSch.setBounds(38, 64, 71, 26);
		panelSach.add(lblMSch);
		
		JLabel lblTnSch = new JLabel("Tên Sách");
		lblTnSch.setForeground(Color.BLUE);
		lblTnSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSch.setBounds(38, 104, 71, 26);
		panelSach.add(lblTnSch);
		
		JLabel lblTnTcGi = new JLabel("Mã Tác Giả");
		lblTnTcGi.setForeground(Color.BLUE);
		lblTnTcGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnTcGi.setBounds(284, 104, 104, 26);
		panelSach.add(lblTnTcGi);
		
		JLabel lblLoiSch = new JLabel("Loại Sách");
		lblLoiSch.setForeground(Color.BLUE);
		lblLoiSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiSch.setBounds(38, 24, 71, 26);
		panelSach.add(lblLoiSch);
		
		cbLoaiSach = new JComboBox<String>();
		cbLoaiSach.setBounds(121, 24, 138, 26);
		panelSach.add(cbLoaiSach);
		
		JLabel lblGiTin = new JLabel("Giá Tiền");
		lblGiTin.setForeground(Color.BLUE);
		lblGiTin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiTin.setBounds(284, 64, 71, 26);
		panelSach.add(lblGiTin);
		
		txtMaSach = new JTextField();
		txtMaSach.setEditable(false);
		txtMaSach.setBounds(121, 64, 138, 26);
		panelSach.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		txtTenSach = new JTextField();
		txtTenSach.setEditable(false);
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(121, 104, 138, 26);
		panelSach.add(txtTenSach);
		
		txtGiaTien = new JTextField();
		txtGiaTien.setEditable(false);
		txtGiaTien.setColumns(10);
		txtGiaTien.setBounds(383, 64, 138, 26);
		panelSach.add(txtGiaTien);
		
		txtTenTacGia = new JTextField();
		txtTenTacGia.setEditable(false);
		txtTenTacGia.setColumns(10);
		txtTenTacGia.setBounds(383, 104, 138, 26);
		panelSach.add(txtTenTacGia);
		btnSaveSach.setBackground(new Color(245, 255, 250));
		
		btnSaveSach.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-save-as-40.png"));
		btnSaveSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnSaveSach.setForeground(Color.BLUE);
		btnSaveSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSaveSach.setBounds(97, 161, 139, 49);
		btnSaveSach.addActionListener(this);
		panelSach.add(btnSaveSach);
		btnAddSach.setBackground(new Color(245, 255, 250));
		
		btnAddSach.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icon_add.png"));
		btnAddSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddSach.setForeground(Color.BLUE);
		btnAddSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddSach.setBounds(248, 161, 139, 49);
		btnAddSach.addActionListener(this);
		panelSach.add(btnAddSach);
		btnUpdateSach.setBackground(new Color(245, 255, 250));
		
		btnUpdateSach.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-downloading-updates-30.png"));
		btnUpdateSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateSach.setForeground(Color.BLUE);
		btnUpdateSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateSach.setBounds(399, 161, 139, 49);
		btnUpdateSach.addActionListener(this);
		panelSach.add(btnUpdateSach);
		btnDeleteSach.setBackground(new Color(245, 255, 250));
		
		btnDeleteSach.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\ProjectManagement\\image\\icons8-delete-40.png"));
		btnDeleteSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeleteSach.setForeground(Color.BLUE);
		btnDeleteSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteSach.setBounds(553, 161, 139, 49);
		btnDeleteSach.addActionListener(this);
		panelSach.add(btnDeleteSach);
		
		//Loại Sách
		tableModelLoaiSach.setColumnIdentifiers(titleLoaiSach);
		tableLoaiSach.setBorder(new EmptyBorder(1, 1, 1, 1));
		tableLoaiSach.setBackground(new Color(255, 250, 250));
		tableLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableLoaiSach.setModel(tableModelLoaiSach);
		
		JPanel panelTableLoaiSach = new JPanel(new GridLayout(1, 1));
		panelTableLoaiSach.setBorder(new EmptyBorder(1, 1, 1, 1));
		panelTableLoaiSach.setBackground(new Color(248, 248, 255));
		panelTableLoaiSach.setBounds(42, 235, 683, 169);
		panelLoaiSach.add(panelTableLoaiSach);
		
		JScrollPane scrollPaneLoaiSach = new JScrollPane(tableLoaiSach);
		scrollPaneLoaiSach.setViewportBorder(new EmptyBorder(1, 1, 1, 1));
		panelTableLoaiSach.add(scrollPaneLoaiSach);
		
		//Sách
		tableModelSach.setColumnIdentifiers(titleSach);
		tableSach.setBorder(new EmptyBorder(1, 1, 1, 1));
		tableSach.setBackground(new Color(255, 250, 250));
		tableSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableSach.setModel(tableModelSach);
		
		JPanel panelTableSach = new JPanel(new GridLayout(1, 1));
		panelTableLoaiSach.setBorder(new EmptyBorder(1, 1, 1, 1));
		panelTableLoaiSach.setBackground(new Color(248, 248, 255));
		panelTableSach.setBounds(38, 235, 683, 169);
		panelSach.add(panelTableSach);
		
		JScrollPane scrollPaneSach = new JScrollPane(tableSach);
		scrollPaneSach.setViewportBorder(new EmptyBorder(1, 1, 1, 1));
		panelTableSach.add(scrollPaneSach);
		
		JLabel lblSLng = new JLabel("Số Lượng");
		lblSLng.setForeground(Color.BLUE);
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSLng.setBounds(284, 24, 71, 26);
		lblSLng.setVisible(false);
		panelSach.add(lblSLng);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(383, 24, 138, 26);
		txtSoLuong.setVisible(false);
		panelSach.add(txtSoLuong);
		
		JLabel lblNm = new JLabel("Năm ");
		lblNm.setForeground(Color.BLUE);
		lblNm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNm.setBounds(541, 24, 104, 26);
		panelSach.add(lblNm);
		lblNm.setVisible(false);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(597, 24, 138, 26);
		textField.setVisible(false);
		panelSach.add(textField);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(579, 475, 139, 49);
		getContentPane().add(btnBack);
		btnBack.setIcon(new ImageIcon("D:\\Eclipse\\workspace\\QuanTriDuAnPhanMem\\image\\icons8-back-40.png"));
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBackground(new Color(245, 255, 250));
		btnBack.addActionListener(this);
		
		String[] list =  null;
		FrmLogin.sockobj.SearchLoaiSach();
		String packet = FrmLogin.sockobj.RecievedPacket();
		 list = FrmLogin.sockobj.HandlePacket(packet);
		for(int i = 0 ; i < list.length/2 ; i++)
		{
		String[] list2 =  {String.valueOf(i+1),list[2*i],list[2*i+1]};
		tableModelLoaiSach.addRow(list2);
		}
		tableLoaiSach.setModel(tableModelLoaiSach);	
		
		String[] list3 =  null;
		FrmLogin.sockobj.SearchBook("1", "All");
		String packet2 = FrmLogin.sockobj.RecievedPacket();
list3 = FrmLogin.sockobj.HandlePacket(packet2);
		for(int i = 0 ; i < list3.length/6 ; i++)
		{	
			String[] list4 =  {String.valueOf(i+1),list3[6*i],list3[6*i+1],list3[6*i+2],list3[6*i+3],list3[6*i+4],list3[6*i+5]};
			tableModelSach.addRow(list4);
		}
		tableSach.setModel(tableModelSach);	
		
		String[] list2 =  null;
		FrmLogin.sockobj.SearchLoaiSach();
		String packet3 = FrmLogin.sockobj.RecievedPacket();
list2 = FrmLogin.sockobj.HandlePacket(packet3);
		for(int i = 0 ; i < list2.length ; i = i+2)
		{	
			cbLoaiSach.addItem(list2[i]);
		} 
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSaveLoaiSach) {
		 if(txtMaLoaiSach.getText().equals("L11") == false)
		 {
				FrmLogin.sockobj.UpdateLoaiSach(txtTenLoaiSach.getText(),txtMaLoaiSach.getText());
				String packet = FrmLogin.sockobj.RecievedPacket();
				String[] list  = FrmLogin.sockobj.HandlePacket(packet);
				if(list[0].equals("Success"))
				{
					JOptionPane.showMessageDialog(null, "Bạn đã cập nhật thành công !");
				}
				else if (list[0].equals("Failed"))
				{
					JOptionPane.showMessageDialog(null, "Có lỗi xảy ra,vui lòng kiểm tra lại thông tin");
				}
				while (tableModelLoaiSach.getRowCount()>0)
            {
					tableModelLoaiSach.removeRow(0);
            }
				String[] list1 =  null;
				FrmLogin.sockobj.SearchLoaiSach();
				String packet1 = FrmLogin.sockobj.RecievedPacket();
list1 = FrmLogin.sockobj.HandlePacket(packet1);
				for(int i = 0 ; i < list1.length/2 ; i++)
				{
				String[] list2 =  {String.valueOf(i+1),list1[2*i],list1[2*i+1]};
				tableModelLoaiSach.addRow(list2);
				}
				tableLoaiSach.setModel(tableModelLoaiSach);	
		 }
		 else
		 {
			 FrmLogin.sockobj.CreateLoaiSach(txtTenLoaiSach.getText(),txtMaLoaiSach.getText());
			 String packet = FrmLogin.sockobj.RecievedPacket();
				String[] list  = FrmLogin.sockobj.HandlePacket(packet);
			    if(list[0].equals("Success"))
			    {
			    	JOptionPane.showMessageDialog(null, "Bạn đã cập nhật thành công !");
			    }
			    else if (list[0].equals("Failed"))
			    {
			    	JOptionPane.showMessageDialog(null, "Có lỗi xảy ra,vui lòng kiểm tra lại thông tin");
			    }
				while (tableModelLoaiSach.getRowCount()>0)
         {
					tableModelLoaiSach.removeRow(0);
         }
				String[] list1 =  null;
				FrmLogin.sockobj.SearchLoaiSach();
				String packet1 = FrmLogin.sockobj.RecievedPacket();
list1 = FrmLogin.sockobj.HandlePacket(packet1);
				for(int i = 0 ; i < list1.length/2 ; i++)
				{
				String[] list2 =  {String.valueOf(i+1),list1[2*i],list1[2*i+1]};
				tableModelLoaiSach.addRow(list2);
				}
				tableLoaiSach.setModel(tableModelLoaiSach);	
		 }
		}
		if(e.getSource() == btnAddLoaiSach) {
			     txtMaLoaiSach.setText("L11");
			     txtTenLoaiSach.setEditable(true);
		}
		if(e.getSource() == btnUpdateLoaiSach) {
			 if(tableLoaiSach.getSelectedRow() >= 0 )
			 {
			     String list2  =  (String) tableModelLoaiSach.getValueAt(tableLoaiSach.getSelectedRow(), 1);
			     txtMaLoaiSach.setText(list2);
			     String list3  =  (String) tableModelLoaiSach.getValueAt(tableLoaiSach.getSelectedRow(), 2);
			     txtTenLoaiSach.setText(list3);
			     txtTenLoaiSach.setEditable(true);
			 }
		}
		if(e.getSource() == btnDeleteLoaiSach) {
			if(tableLoaiSach.getSelectedRow() >= 0 )
			{
			SocketClass sockobj = new SocketClass();
			int dialogButton = JOptionPane.YES_NO_OPTION;
			String list2  =  (String) tableModelLoaiSach.getValueAt(tableLoaiSach.getSelectedRow(), 1);
			int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có chắc muốn xóa loại sách : " + list2 + " ?" ,"Warning", dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION){
				FrmLogin.sockobj.DeleteLoaiSach(list2);
				String packet = FrmLogin.sockobj.RecievedPacket();
				String[] list  = sockobj.HandlePacket(packet);
				if(list[0].equals("Success"))
				{
					JOptionPane.showMessageDialog(null, "Bạn đã xóa tài khoản thành công !");
				}
				else if (list[0].equals("Failed"))
				{
					JOptionPane.showMessageDialog(null, "Có lỗi trong quá trình xóa vui lòng thử lại !");
				}
				while (tableModelLoaiSach.getRowCount()>0)
		        {
							tableModelLoaiSach.removeRow(0);
		         }
						String[] list1 =  null;
						FrmLogin.sockobj.SearchLoaiSach();
						String packet1 = FrmLogin.sockobj.RecievedPacket();
list1 = FrmLogin.sockobj.HandlePacket(packet1);
						for(int i = 0 ; i < list1.length/2 ; i++)
						{
						String[] list3 =  {String.valueOf(i+1),list1[2*i],list1[2*i+1]};
						tableModelLoaiSach.addRow(list3);
						}
						tableLoaiSach.setModel(tableModelLoaiSach);	
			  }
		    }
			else 
			{
				JOptionPane.showMessageDialog(null, "Bạn cần chọn cột trước khi xóa");
			}
		}
		if(e.getSource() == btnSaveSach) {
			if(txtMaSach.getText().equals("B36") == false)
			 {
			 
			 }
			else
			{
		     }
				String[] list3 =  {"36",txtMaSach.getText(),txtTenSach.getText(),"Nguyen Nhat Anh","thieu nhi",txtGiaTien.getText(),"10"};
				tableModelSach.addRow(list3);
				tableSach.setModel(tableModelSach);	
			
		}
		if(e.getSource() == btnAddSach) {
		   txtMaSach.setText("B36");
		   txtTenSach.setEditable(true);
		   txtSoLuong.setEditable(true);
		   txtGiaTien.setEditable(true);
		   txtTenTacGia.setEditable(true);
		}
		if(e.getSource() == btnUpdateSach) {
			
		}
		if(e.getSource() == btnDeleteSach) {
			tableModelSach.removeRow(tableSach.getRowCount() - 1);
		}
		if(e.getActionCommand() == "Back") {
			this.dispose();
			new FrmChucNangNguoiDung();
		}
	  
	}
	public static void main(String[] args) {
		new FrmQuanLy();
	}
}
