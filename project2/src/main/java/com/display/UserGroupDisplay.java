package com.display;

// ��µ� ����

import java.awt.GridLayout;

import javax.swing.*;
import java.awt.*;

public class UserGroupDisplay extends JFrame implements Displayable{
	private JComboBox<String> groupList;
	private JButton selectBtn;
	public UserGroupDisplay() {
		setTitle("GroupList");
		setSize(300,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		groupList = new JComboBox<String>();
		this.add("Center",groupList);
		
		selectBtn = new JButton("����");
		this.add("South",selectBtn);
	}

	public void display() {
		setVisible(true);
	}
}
