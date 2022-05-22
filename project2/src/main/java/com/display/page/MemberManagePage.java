package com.display.page;

// 작성자: 허승돈

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import java.util.regex.PatternSyntaxException;
import java.sql.SQLException;

import com.DB.*;
import com.display.*;
import com.std.*;
import com.util.*;

public class MemberManagePage extends JFrame implements Displayable {
	private final String[] column = {"ID","이름"};
	
	private JScrollPane scrolledTable;
	private JTable manageuser;
	private JPanel buttonPanel;
	private JButton usergroupbutton;
	private JButton creatememberbutton;
	private String content[][];
	private UserAuthentication uat;
	
	public MemberManagePage(){
		/** 
		content = new String[ua.getUsers().size()][2];
		uat = ua;

		for(int i=0;i<ua.getUsers().size();i++)
		{
			content[i][0] = ua.getUsers().get(i).getId();
			content[i][1] = ua.getUsers().get(i).getName();
//			content[i][1] = "HurSeungDon";
//			content[i][2] = ua.getUsers().get(i).rank.getRank();
//			content[i][2] = "TeamLeader";
		}
		**/
		
		setTitle("User Manager");
		setSize(1200,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1,2));
		
//		DefaultTableModel tableModel = new DefaultTableModel(column,0);
		
		manageuser = new JTable(content,column);
		manageuser.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		scrolledTable = new JScrollPane(manageuser);
		this.add(scrolledTable);
		
		buttonPanel = new JPanel(new GridLayout(2,1));
		
		usergroupbutton = new JButton("user group");
		creatememberbutton = new JButton("add member");
		buttonPanel.add(usergroupbutton);
		buttonPanel.add(creatememberbutton);
		this.add(buttonPanel);
		
		usergroupbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new UserGroupDisplay().display();
			}
		});
		creatememberbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateMemberDisplay().display();
			}
		});
	}
	
	// public void createmember(){
		
	// }

	public void display() {
		setVisible(true);
	}
}