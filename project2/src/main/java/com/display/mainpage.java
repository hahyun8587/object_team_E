package com.display;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPage extends JFrame implements Displayable {

	private JPanel loginPanel = new JPanel(new GridLayout(3, 2));
	private JLabel idLabel = new JLabel("메인페이지");
	private JButton jobManagementBtn = new JButton("작업관리");
	private JButton memberManagementBtn = new JButton("멤버관리");

	public MainPage() {
		super("메인페이지");

		setContentPane(loginPanel);

		loginPanel.add(idLabel);
		loginPanel.add(jobManagementBtn);
		loginPanel.add(memberManagementBtn);
		idLabel.setHorizontalAlignment(NORMAL);

		setSize(350, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jobManagementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TaskManagePage().display();
				setVisible(true);
			}

		});
		memberManagementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new UserManagePage().display();
				setVisible(true);
			}
		});
	}
	public void display() {
		setVisible(true);
	}

}