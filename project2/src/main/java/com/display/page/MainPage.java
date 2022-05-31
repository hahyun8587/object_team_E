package com.display.page;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;

import com.display.actionListener.MoveActionListener;
import com.std.User;

public class MainPage extends FramePage {
	private JPanel mainPanel = new JPanel(new GridLayout(4, 2));
	private JLabel pageLabel = new JLabel("메인페이지");
	private JButton memberManagementBtn = new JButton("멤버관리");
	private JButton jobManagementBtn = new JButton("작업관리");
	private JButton scheduleManagementBtn = new JButton("일정관리");
	private JButton conferenceManagementBtn = new JButton("회의기록관리");
	private JButton conferenceBtn = new JButton("zoom");
	private JButton saveBtn = new JButton("파일불러오기");
	private JButton settingBtn = new JButton("배경");

	public MainPage(User user, Color color) {
		super(user, color);
		
		setTitle("메인페이지");
		setSize(350, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pageLabel.setHorizontalAlignment(NORMAL);

		mainPanel.add(pageLabel);
		mainPanel.add(memberManagementBtn);
		mainPanel.add(jobManagementBtn);
		mainPanel.add(conferenceBtn);
		mainPanel.add(conferenceManagementBtn);
		mainPanel.add(saveBtn);
		mainPanel.add(scheduleManagementBtn);
		mainPanel.add(settingBtn);
	
		jobManagementBtn.addActionListener(new MoveActionListener(new JobManagePage(user, mainPanel.getBackground()), this));
		memberManagementBtn.addActionListener(new MoveActionListener(new MemberManagePage(user, mainPanel.getBackground()), this));
		
	
		settingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}

		});
		conferenceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				URI uri;
				try {
					uri = new URI("https://zoom.us/");
					Desktop desktop = Desktop.getDesktop();
	                try {
						desktop.browse(uri);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
                
			}

		});
		
		saveBtn.addActionListener(new MoveActionListener(new FilePage(user, mainPanel.getBackground()), this));
		
		scheduleManagementBtn.addActionListener(new moveActionListener());

		setContentPane(mainPanel);
		
		setLocationRelativeTo(null);
	}

	public void display() {
		setVisible(true);
	}
	
	private void update() {
		if(mainPanel.getBackground()==Color.cyan) {
			mainPanel.setBackground(Color.yellow);
		}
		else if(mainPanel.getBackground()==Color.yellow) {
			mainPanel.setBackground(Color.lightGray);
		}
		else if(mainPanel.getBackground()==Color.lightGray) {
			mainPanel.setBackground(Color.pink);
		}
		else {
			mainPanel.setBackground(Color.cyan);
		}
	}

	public class moveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new View(user).display();
		}
	}
}