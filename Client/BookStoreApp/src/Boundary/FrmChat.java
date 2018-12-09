package Boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrmChat extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StringBuilder sb = new StringBuilder();
	private JFrame frame;
	private JTextField textField;
	String packet;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new FrmChat();
	}

	/**
	 * Create the application.
	 */
	public FrmChat() {
		getContentPane().setBackground(new Color(224, 255, 255));
		initialize();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(976, 617);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 798, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextArea textArea = new JTextArea();
		getContentPane().add(textArea, BorderLayout.CENTER);
		Thread receivingThread = new Thread() {
		     @Override
		     public void run() {
		    	  while(true) {
		        		packet = FrmLogin.sockobj.RecievedPacket();
		        		System.out.println(packet);
		        		sb.append(packet);
		        		sb.append(System.lineSeparator());
		        		textArea.setText(sb.toString());
		      }
		    }
		 };
		 receivingThread.start();
		 FrmLogin.sockobj.SendChatLogin("join a room",FrmLogin.user.getName());	
		
		JLabel lblChat = new JLabel("CHAT");
		getContentPane().add(lblChat, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLogin.sockobj.SendChat(textField.getText(),FrmLogin.user.getName());	
			}
		});
		panel.add(btnSend, BorderLayout.EAST);
		
		textField = new JTextField();
		panel.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

}
