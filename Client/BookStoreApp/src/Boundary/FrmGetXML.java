package Boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Connection.SocketClass;

public class FrmGetXML extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	public static SocketClass sockobj = new SocketClass();
	JTextArea textArea;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	public FrmGetXML() {
		getContentPane().setBackground(new Color(224, 255, 255));
		init();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(976, 617);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void init() {
		getContentPane().setLayout(null);
	
		
		JButton button = new JButton("Get XML");
		button.addActionListener(this);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(new Color(154, 205, 50));
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBackground(new Color(240, 255, 240));
		button.setBounds(235, 450, 106, 76);
		getContentPane().add(button);
		
		JButton button3 = new JButton("Get HTML");
		button3.addActionListener(this);
		button3.setHorizontalAlignment(SwingConstants.LEFT);
		button3.setForeground(new Color(154, 205, 50));
		button3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button3.setBackground(new Color(240, 255, 240));
		button3.setBounds(83, 450, 137, 76);
		getContentPane().add(button3);
		
		JButton button2 = new JButton("Back");
		button2.addActionListener(this);
		button2.setHorizontalAlignment(SwingConstants.LEFT);
		button2.setForeground(new Color(154, 205, 50));
		button2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button2.setBackground(new Color(240, 255, 240));
		button2.setBounds(703, 450, 86, 76);
		getContentPane().add(button2);
		
		JButton button4 = new JButton("Caculate");
		button4.addActionListener(this);
		button4.setHorizontalAlignment(SwingConstants.LEFT);
		button4.setForeground(new Color(154, 205, 50));
		button4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button4.setBackground(new Color(240, 255, 240));
		button4.setBounds(361, 450, 106, 76);
		getContentPane().add(button4);
		
		textArea = new JTextArea();
		textArea.setText(" ");
		textArea.setEditable(false);
		textArea.setBounds(83, 16, 706, 334);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(83, 366, 146, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(83, 408, 146, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 366, 92, 26);
		getContentPane().add(passwordField);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Get XML") {
		    try {
				sockobj.SendGetXML("/example.xml");
				String packet = sockobj.RecievedPacket2();
				String n = packet;
			    n = n.replace("HTTP/1.1 200 OK\n", "");
			    n = n.replace("Server: Simple-Python-Server\n", "");
			    n = n.replace("Connection: close\n", "");
			    //System.out.println(packet.indexOf("</SJC>"));
			    String result = n.substring(n.indexOf("<SJC>\n") + 6 , n.indexOf("</SJC>")).trim();
			    System.out.println(Long.parseLong(result));
			    
			    if(Long.parseLong(result) < 1000  || Long.parseLong(result) > 1500)
			    {
			    	//SendMailEntity.sendFromGMail(SendMailEntity.from,passwordField.getText(), SendMailEntity.to, SendMailEntity.subject, SendMailEntity.body);
			    }
			    else {
			    	packet = packet + "SJC is still alright !";
			    }
			    textArea.setText(packet);
                sockobj.CloseConnection();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
		 }
		else if(e.getActionCommand() == "Get HTML") {
		    try {
				sockobj.SendGetHTTP("/2.html");
				String packet = sockobj.RecievedPacket2();
				textArea.setText(packet);
                sockobj.CloseConnection();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
		 }
		
		else if(e.getActionCommand() == "Caculate") {
		    try {
				sockobj.SendCaculate(textField.getText(),textField_1.getText(),"+");
				String packet = sockobj.RecievedPacket();
				String[] n =  sockobj.HandlePacket(packet);
				textArea.setText(n[0].toString());
				n = null;
                sockobj.CloseConnection();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    catch(Exception e1)
		    {
		    	e1.printStackTrace();
		    }
		 }
		else if(e.getActionCommand() == "Back") {
		   dispose();
		   new FrmLogin();
		 }
		
	}


	public static void main(String [] args) {
		new FrmGetXML();
	}
}
