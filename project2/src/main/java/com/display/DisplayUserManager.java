package com.display;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.*;

public class DisplayUserManager extends JFrame {
	private final String[] column = {"직번","이름","직급"};
	
	private JScrollPane scrolledTable;
	private JTable manageuser;
	
	public DisplayUserManager(){
		setTitle("User Manager");
		setSize(1200,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		DefaultTableModel tableModel = new DefaultTableModel(column,0);
		
		manageuser = new JTable(tableModel);
		manageuser.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		scrolledTable = new JScrollPane(manageuser);
		this.add(scrolledTable);
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DisplayUserManager();
	}
}
