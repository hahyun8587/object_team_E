package com.display.page;

// 작성자: 허승돈

import javax.swing.*;
import java.awt.*;

public class UserGroupDisplay extends FramePage {
	private JComboBox<String> groupList;
	private JButton selectBtn;

	public UserGroupDisplay() {
		setTitle("GroupList");
		setSize(300,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		groupList = new JComboBox<String>();
		this.add("Center",groupList);
		
		selectBtn = new JButton("그룹별 사용자 조회");
		this.add("South",selectBtn);
	}

	public void display() {
		setVisible(true);
	}
}
