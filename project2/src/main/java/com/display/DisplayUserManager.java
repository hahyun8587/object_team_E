package com.display;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;

public class DisplayUserManager extends JFrame {
	private final String[] column = {"직번","이름","소속","직급"};
	
	private JScrollPane scrolledTable;
	private JTable manageuser;
	
	public DisplayUserManager(){
		setTitle("User Manager");
		setSize(1200,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1,2));
		
		DefaultTableModel tableModel = new DefaultTableModel(column,0);
		
		manageuser = new JTable(tableModel);
		manageuser.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		scrolledTable = new JScrollPane(manageuser);
		this.add(scrolledTable);
		
		JPanel buttonPanel = new JPanel(new GridLayout(2,1));
		
		JButton usergroupbutten = new JButton("사용자 그룹");
		JButton createmember = new JButton("멤버생성");
		buttonPanel.add(usergroupbutten);
		buttonPanel.add(createmember);
		this.add(buttonPanel);
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DisplayUserManager();
	}
}
