package com.display;

//허승돈 구현

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class DisplayTaskManager extends JFrame{
	private JTable taskTable;
	private final String[] column = {"프로젝트명","시작일","마감 에정일"};
	private JButton completeBtn, addtaskBtn;
	private JScrollPane taskScroll;
	private JPanel BtnPnl;
	
	
	public DisplayTaskManager() {
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
		
		setVisible(true);
	}
	
	public static void main(String[] arg) {
		new DisplayTaskManager();
	}
}
