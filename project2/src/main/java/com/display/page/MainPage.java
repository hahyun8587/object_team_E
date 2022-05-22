package com.display.page;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

import com.util.UserAuthentication;

public class MainPage extends FramePage implements Displayable {

	private JPanel loginPanel = new JPanel(new GridLayout(4, 2));
	private JLabel idLabel = new JLabel("메인페이지");
	private JButton jobManagementBtn = new JButton("작업관리");
	private JButton memberManagementBtn = new JButton("멤버관리");
	private JButton settingBtn = new JButton("배경");
	private JButton conferenceBtn = new JButton("회의");
	private JButton scheduleBtn = new JButton("회의일정");
	private JButton saveBtn = new JButton("파일불러오기");

	public MainPage() {
		setTitle("메인페이지");
		setContentPane(loginPanel);

		loginPanel.add(idLabel);
		loginPanel.add(jobManagementBtn);
		loginPanel.add(memberManagementBtn);
		loginPanel.add(settingBtn);
		loginPanel.add(conferenceBtn);
		loginPanel.add(saveBtn);
		loginPanel.add(scheduleBtn);
		idLabel.setHorizontalAlignment(NORMAL);

		setSize(350, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jobManagementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JobManagePage().display();
			}

		});
		memberManagementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MemberManagePage().display(); // HSD: the received 'ua' back to the member management page.
			}
		});
		settingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}

		});
		conferenceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URI uri;
				try {
					uri = new URI("https://zoom.us/");
					Desktop desktop = Desktop.getDesktop();
	                try {
						desktop.browse(uri);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
			}

		});
		
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FilePage("제목없음").display();
                
			}

		});
		
		scheduleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new View().display();
                
			}

		});
	}

	public void display() {
		setVisible(true);
	}
	
	public void update() {
		if(loginPanel.getBackground()==Color.cyan) {
			loginPanel.setBackground(Color.yellow);
			//setColor(Color.yellow);
		}
		
		else if(loginPanel.getBackground()==Color.yellow) {
			loginPanel.setBackground(Color.lightGray);
			//setColor(Color.lightGray);
		}
		else if(loginPanel.getBackground()==Color.lightGray) {
			loginPanel.setBackground(Color.pink);
			//setColor(Color.pink);
		}
		else {
			loginPanel.setBackground(Color.cyan);
			//setColor(Color.cyan);
		}
	}
}