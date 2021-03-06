package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import database.Sql_connetcton.*;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login frame = new Login();
					frame.setVisible(true);
					Sql_connetcton.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u767B\u5F55\u540D:");
		label.setFont(new Font("宋体", Font.PLAIN, 13));
		label.setBounds(63, 94, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 13));
		label_1.setBounds(63, 132, 54, 15);
		contentPane.add(label_1);
		
		JLabel lbljxy = new JLabel("\u5B66\u7C4D\u7BA1\u7406\u7CFB\u7EDF");
		lbljxy.setFont(new Font("华文行楷", Font.PLAIN, 30));
		lbljxy.setBounds(124, 0, 185, 61);
		contentPane.add(lbljxy);
		
		JLabel label_2 = new JLabel("<html><body>\r\n03111002-\u8D3E\u65B0\u79B9</body></html>");
		label_2.setFont(new Font("楷体", Font.PLAIN, 14));
		label_2.setBounds(303, 36, 117, 48);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 13));
		textField.setBounds(127, 91, 192, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 13));
		passwordField.setBounds(127, 129, 192, 21);
		contentPane.add(passwordField);
		
		final JButton button = new JButton("\u767B\u9646");
		button.setBounds(83, 186, 110, 40);
		contentPane.add(button);
		JButton button_1 = new JButton("\u9000\u51FA");

		button_1.setBounds(239, 186, 110, 40);
		contentPane.add(button_1);
		
		JLabel lblCopyrightc = new JLabel("Copyright (C) 2013 \u8D3E\u65B0\u79B9 \u897F\u5B89\u7535\u5B50\u79D1\u6280\u5927\u5B66 \u8BA1\u7B97\u673A\u5B66\u9662");
		lblCopyrightc.setBounds(63, 246, 351, 15);
		contentPane.add(lblCopyrightc);
		
		Login.this.setResizable(false);
		Login.this.setLocationRelativeTo(null);	
		passwordField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				button.doClick();
				
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=textField.getText();
				String password=String.valueOf(passwordField.getPassword());
				if(Sql_connetcton.login_s(user, password)==1){
					Login_error frame = new Login_error();
					frame.setVisible(true);
				}
				else {
					Login.this.dispose();
					Main main=new Main();
					main.setVisible(true);
				}
			}
		});
	}
}
