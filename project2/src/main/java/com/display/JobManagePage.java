package com.display;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class JobManagePage extends JFrame implements Displayable {
	private JTable taskTable;
	private final String[] column = {"아이디","이름","직책"};
	private JButton completeBtn, addtaskBtn;
	private JScrollPane taskScroll;
	private JPanel BtnPnl;
	
	public JobManagePage() {
		setTitle("Task Manager");
		setSize(1200,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		DefaultTableModel tableModel = new DefaultTableModel(column,0);
		taskTable = new JTable(tableModel);
		taskTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		taskScroll = new JScrollPane(taskTable);
		this.add("Center",taskScroll);
		
		BtnPnl = new JPanel(new FlowLayout());
		completeBtn = new JButton("작업체크");
		BtnPnl.add(completeBtn);
		addtaskBtn = new JButton("작업생성");
		BtnPnl.add(addtaskBtn);
		this.add("South",BtnPnl);
	}

	public void display() {
		setVisible(true);
	}
}