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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Connection.SocketClass;

public class FrmTaoTaiKhoan extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtTenNhanVien;
	private JComboBox<String> cbChucVu;
	private JTable table = new JTable() {
		private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {                
        return false;               
           };
	};
	String [] title = new String[] {"STT", "ID", "Tên nhân viên", "Username", "Password", "Chức vụ"};
	private DefaultTableModel tableModel = new DefaultTableModel();
	SocketClass sockobj = FrmLogin.sockobj;
	
	public FrmTaoTaiKhoan() {
		init();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(777, 597);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
	public void init() {
		setBackground(new Color(224, 255, 255));
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblToTiKhon = new JLabel("TẠO TÀI KHOẢN ");
		lblToTiKhon.setForeground(new Color(0, 0, 255));
		lblToTiKhon.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblToTiKhon.setBounds(262, 24, 221, 52);
		getContentPane().add(lblToTiKhon);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(56, 83, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTnNhnVin = new JLabel("Tên Nhân Viên");
		lblTnNhnVin.setForeground(Color.BLUE);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnNhnVin.setBounds(358, 82, 112, 19);
		getContentPane().add(lblTnNhnVin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLUE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(56, 128, 77, 19);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(56, 174, 112, 19);
		getContentPane().add(lblPassword);
		
		JLabel lblChcV = new JLabel("Chức Vụ");
		lblChcV.setForeground(Color.BLUE);
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChcV.setBounds(358, 128, 112, 19);
		getContentPane().add(lblChcV);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setEditable(false);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setBounds(145, 79, 139, 26);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setEditable(false);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setColumns(10);
		txtUsername.setBounds(145, 125, 139, 26);
		getContentPane().add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBounds(145, 171, 139, 26);
		getContentPane().add(txtPassword);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(479, 79, 139, 26);
		getContentPane().add(txtTenNhanVien);
		
		cbChucVu = new JComboBox<String>();
		cbChucVu.setBounds(479, 127, 139, 26);
		getContentPane().add(cbChucVu);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(245, 255, 250));
		btnSave.setIcon(new ImageIcon("image\\icons8-save-as-40.png"));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setForeground(Color.BLUE);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(53, 221, 139, 49);
		btnSave.addActionListener(this);
		getContentPane().add(btnSave);
		
		JButton btnAdd = new JButton("Add New");
		btnAdd.setBackground(new Color(245, 255, 250));
		btnAdd.setIcon(new ImageIcon("image\\icon_add.png"));
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.setForeground(Color.BLUE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(222, 221, 139, 49);
		btnAdd.addActionListener(this);
		getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(245, 255, 250));
		btnUpdate.setIcon(new ImageIcon("image\\icons8-downloading-updates-30.png"));
		btnUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(395, 221, 139, 49);
		btnUpdate.addActionListener(this);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(245, 255, 250));
		btnDelete.setIcon(new ImageIcon("image\\icons8-delete-40.png"));
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setForeground(Color.BLUE);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(565, 221, 139, 49);
		btnDelete.addActionListener(this);
		getContentPane().add(btnDelete);
		
		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(37, 301, 679, 175);
		getContentPane().add(panel);
		
		tableModel.setColumnIdentifiers(title);
		table.setBorder(new EmptyBorder(1, 1, 1, 1));
		table.setBackground(new Color(255, 250, 250));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new EmptyBorder(1, 1, 1, 1));
		panel.add(scrollPane);
		
		updateTable();

		table.setModel(tableModel);	
		cbChucVu.addItem("Nhan vien");
		cbChucVu.addItem("Thu kho");
		cbChucVu.addItem("Admin");
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("image\\icons8-back-40.png"));
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBackground(new Color(245, 255, 250));
		btnBack.setBounds(577, 489, 139, 49);
		btnBack.addActionListener(this);
		getContentPane().add(btnBack);
	}
	public void updateTable()
	{
		while (tableModel.getRowCount()>0)
        {
            tableModel.removeRow(0);
         }
		String[] list =  null;
		sockobj.SearchAccount();
		String packet = sockobj.RecievedPacket();
		list = sockobj.HandlePacket(packet);
		    
			for(int i = 0 ; i < list.length/5 ; i++)
			{	
				String n ="" ;
			     for(int j = 0 ; j < list[5*i+3].length() ; j++)
			     {
			    	 n =  n + "*" ;//String.valueOf(list[5*i+3].length()
			     }
				String[] list2 =  {String.valueOf(i+1),list[5*i],list[5*i+1],list[5*i+2],n,list[5*i+4]};
				tableModel.addRow(list2);;
			}
			table.setModel(tableModel);	
	}
	public void refreshText()
	{
		 txtUsername.setText("");
		 txtUsername.setEditable(true);
		 txtPassword.setText("");
		 txtPassword.setEditable(true);
		 txtTenNhanVien.setText("");
		 txtTenNhanVien.setEditable(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Save") {
			if(Integer.parseInt(txtID.getText()) > table.getRowCount()  )
			{
				sockobj.CreateAccount(txtUsername.getText(), txtPassword.getText(), txtTenNhanVien.getText(), txtID.getText(), cbChucVu.getSelectedItem().toString());
				String packet = sockobj.RecievedPacket();
				String[] list  = sockobj.HandlePacket(packet);
				updateTable();
				refreshText();
				txtID.setText("");
				if(list[0].equals("Success"))
				{
					JOptionPane.showMessageDialog(null, "Bạn đã tạo tài khoản thành công !");
				}
				else if (list[0].equals("Failed"))
				{
					JOptionPane.showMessageDialog(null, "Tên đăng nhập trùng, vui lòng kiểm tra lại thông tin");
				}
			}
			else if (Integer.parseInt(txtID.getText()) <= table.getRowCount())
			{
				sockobj.UpdateAccount(txtUsername.getText(), txtPassword.getText(), txtTenNhanVien.getText(), txtID.getText(), cbChucVu.getSelectedItem().toString());
				String packet = sockobj.RecievedPacket();
				String[] list  = sockobj.HandlePacket(packet);
				updateTable();
				refreshText();
				txtID.setText("");
				if(list[0].equals("Success"))
				{
					JOptionPane.showMessageDialog(null, "Bạn đã cập nhật tài khoản thành công !");
				}
				else if (list[0].equals("Failed"))
				{
					JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
				}
			}
		}
		if(e.getActionCommand() == "Add New") {
			 txtID.setText(String.valueOf(table.getRowCount() + 1));
			 refreshText();
			 
		}
		if(e.getActionCommand() == "Update") {
		 if(table.getSelectedRow() >= 0 )
		 {
			 String list  =  (String) tableModel.getValueAt(table.getSelectedRow(), 1);
		     txtID.setText(list);
		     String list2  =  (String) tableModel.getValueAt(table.getSelectedRow(), 3);
		     txtUsername.setText(list2);
		     txtUsername.setEditable(true);
		     String list3  =  (String) tableModel.getValueAt(table.getSelectedRow(), 4);
		     txtPassword.setText(list3);
		     txtPassword.setEditable(true);
		     String list4  =  (String) tableModel.getValueAt(table.getSelectedRow(), 2);
		     txtTenNhanVien.setText(list4);
		     txtTenNhanVien.setEditable(true);
		     String list5  =  (String) tableModel.getValueAt(table.getSelectedRow(), 5);
			 cbChucVu.setSelectedItem(list5);
		 }
		}
		if(e.getActionCommand() == "Delete") {
			if(table.getSelectedRow() >= 0 )
			{
			int dialogButton = JOptionPane.YES_NO_OPTION;
			String list2  =  (String) tableModel.getValueAt(table.getSelectedRow(), 3);
			int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có chắc muốn xóa tên đăng nhập : " + list2 + " ?" ,"Warning", dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION){
				sockobj.DeleteAccount(list2);
				String packet = sockobj.RecievedPacket();
				String[] list  = sockobj.HandlePacket(packet);
				if(list[0].equals("Success"))
				{
					JOptionPane.showMessageDialog(null, "Bạn đã xóa tài khoản thành công !");
				}
				else if (list[0].equals("Failed"))
				{
					JOptionPane.showMessageDialog(null, "Có lỗi trong quá trình xóa vui lòng thử lại !");
				}
			    updateTable();
			  }
		    }
			else 
			{
				JOptionPane.showMessageDialog(null, "Bạn cần chọn cột trước khi xóa");
			}
		}
		if(e.getActionCommand() == "Back") {
			dispose();
			new FrmChucNangNguoiDung();
		}
		
	}
	
	public static void main(String[] args) {
		new FrmTaoTaiKhoan();
	}
	
}
