package com.display;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainpage extends JFrame {

	private JPanel loginPanel = new JPanel(new GridLayout(3, 2));

	private JLabel idLabel = new JLabel("이건 메인 페이지 ");



	private JButton loginBtn = new JButton("작업관리");
	private JButton idpwSearchBtn = new JButton("멤버관리");

	public mainpage() {

		super("로그인 창!");

		this.setContentPane(loginPanel);

		loginPanel.add(idLabel);
		loginPanel.add(idpwSearchBtn);
		loginPanel.add(loginBtn);

		idLabel.setHorizontalAlignment(NORMAL);


		setSize(350, 150);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//로그인 버튼을 눌렀을때

		loginBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}

		});

//아이디 비밀번호 찾기 버튼을 눌렀을때

		idpwSearchBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "아이디 비번 찾기 기능~~", "아이디/비밀번호 찾기", JOptionPane.DEFAULT_OPTION);
			}
		});

	}

}