package com.display.page;

import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;

import com.std.User;
import com.util.UserAuthentication;

public class LoginPage extends FramePage {
	private JPanel loginPanel = new JPanel();
	private JLabel idLabel = new JLabel("아이디");
	private JLabel pwLabel = new JLabel("비밀번호 ");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("로그인");
	private JButton idpwSearchBtn = new JButton("아이디/비밀번호 찾기");
	
	private UserAuthentication ua;

	public LoginPage(UserAuthentication ua) {
		this.ua = ua;
		
		setTitle("로그인 창");
		setSize(350, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loginPanel.setLayout(null);
		idLabel.setBounds(10, 10, 100, 25);
		pwLabel.setBounds(10, 40, 100, 25);
		idText.setBounds(100, 10, 100, 25);
		pwText.setBounds(100, 40, 100, 25);
		loginBtn.setBounds(10, 80, 120, 25);
		idpwSearchBtn.setBounds(160, 80, 120, 25);
		
		idLabel.setHorizontalAlignment(NORMAL);
		pwLabel.setHorizontalAlignment(NORMAL);

		loginBtn.addActionListener(new LoginActionListener());

		loginPanel.add(idLabel);
		loginPanel.add(idText);
		loginPanel.add(pwLabel);
		loginPanel.add(pwText);
		loginPanel.add(loginBtn);
		loginPanel.add(idpwSearchBtn);

		setContentPane(loginPanel);

		setLocationRelativeTo(null);
	}

	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			User user = User.login(ua, idText.getText(), new String(pwText.getPassword()));

			if(user != null) {
				dispose();
				new MainPage(user, null).display();
			}
			else 
				JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 다시 확인해주세요.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void display() {
		setVisible(true);
	}
}