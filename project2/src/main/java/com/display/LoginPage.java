package com.display;

import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame implements Displayable {
	private JPanel loginPanel = new JPanel();
	private JLabel idLabel = new JLabel("아이디");
	private JLabel pwLabel = new JLabel("비밀번호 ");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("로그인");
	private JButton idpwSearchBtn = new JButton("아이디/비밀번호 찾기");

	private String[] data = null;

	public LoginPage() {
		super("로그인 창");
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		loginBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {	
				data = new String[2];
				data[0] = idText.getText();
				data[1] = new String(pwText.getPassword()).trim();
				
				setVisible(false);
				new MainPage().display();
				/*
				if (id.length() == 0 || pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!",
							JOptionPane.DEFAULT_OPTION);
					return null;
				}
			
			
				if (id.equals("test") && pw.equals("test1")) {
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
					//dp.gomain();
					//여기서 다른 화면으로 이동하도록 구현
					return;
				}
				*/
	
				//JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
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