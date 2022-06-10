package com.display.page.mainpage;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.display.CommonActionListener;
import com.display.CorePage;
import com.display.UIDisplayer;
import com.display.ComponentMediator;

import com.std.User;

public class MainPage extends CorePage {

	public MainPage(UIDisplayer displayer, User user) {
		super(displayer, user);
	}

	@Override
	protected void init() {
		JPanel mainPanel = new JPanel(new GridLayout(4, 2));
		JLabel pageLabel = new JLabel("메인페이지");
		ActionListener al = new CommonActionListener();
		ComponentMediator mediator = new MainComponentMediator(displayer);
	
		setTitle("메인페이지");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pageLabel.setHorizontalAlignment(NORMAL);

		mainPanel.add(pageLabel);
		mainPanel.add(new MemberManageBtn("멤버관리", al, mediator));
		mainPanel.add(new JobManageBtn("작업관리", al, mediator));
		mainPanel.add(new ZoomBtn("Zoom", al, mediator));
		mainPanel.add(new ConferenceManageBtn("회의기록관리", al, mediator));
		mainPanel.add(new FileManageBtn("파일관리", al, mediator));
		mainPanel.add(new ScheduleManageBtn("스케줄관리", al, mediator));
		mainPanel.add(new SettingBtn("설정", al, mediator));

		getContentPane().add(mainPanel);
		
		setLocationRelativeTo(null);
	}
}