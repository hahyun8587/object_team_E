package com.display;

import java.awt.GridLayout;

import javax.swing.*;
import java.awt.*;

public class UserGroupDisplay extends JFrame{
	private JComboBox<String> groupList;
	private JButton selectBtn;
	public UserGroupDisplay() {
		setTitle("GroupList");
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		groupList = new JComboBox<String>();
		this.add("Center",groupList);
		
		selectBtn = new JButton("º±≈√");
		this.add("South",selectBtn);
		
		setVisible(true);
	}
}
