package com.display;

import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;

public class LoginPage extends FramePage implements Displayable {
	private JPanel loginPanel = new JPanel();
	private JLabel idLabel = new JLabel("아이디");
	private JLabel pwLabel = new JLabel("비밀번호 ");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("로그인");
	private JButton idpwSearchBtn = new JButton("아이디/비밀번호 찾기");

	private String[] data = null;

	public LoginPage() {
		
		setTitle("로그인 창");
		loginPanel.setLayout(null);
		setContentPane(loginPanel);
		
		idLabel.setBounds(10, 10, 100, 25);
		pwLabel.setBounds(10, 40, 100, 25);
		idText.setBounds(100, 10, 100, 25);
		pwText.setBounds(100, 40, 100, 25);
		loginBtn.setBounds(10, 80, 120, 25);
		idpwSearchBtn.setBounds(160, 80, 120, 25);
		
		loginPanel.add(idLabel);
		loginPanel.add(idText);
		loginPanel.add(pwLabel);
		loginPanel.add(pwText);
		loginPanel.add(loginBtn);
		loginPanel.add(idpwSearchBtn);

		idLabel.setHorizontalAlignment(NORMAL);
		pwLabel.setHorizontalAlignment(NORMAL);

		setSize(350, 150);

		setLocationRelativeTo(null);
		//this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		loginBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {	
				data = new String[2];
				data[0] = idText.getText();
				data[1] = new String(pwText.getPassword());
				
				dispose();
			}
		});
		/* 
		idpwSearchBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "아이디 비번 찾기 기능~~", "아이디/비밀번호 찾기", JOptionPane.DEFAULT_OPTION);
			}
		});
		*/
	}

	public void display() {
		setVisible(true);
	}

	public void setData(String[] data) {
		this.data = data;
	}

	public String[] getData() {
		return data;
	}
}