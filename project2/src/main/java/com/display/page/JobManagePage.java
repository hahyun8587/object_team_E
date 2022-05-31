package com.display.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.display.actionListener.MoveActionListener;
import com.record.records.Job;
import com.record.records.Record;
import com.std.User;
import com.util.RecordType;
import com.util.search.RecordSearchLocal;

public class JobManagePage extends FramePage {
	private JTable taskTable;
	private JScrollPane taskScroll;
	private JPanel BtnPnl = new JPanel(new FlowLayout());;
	private JButton completeBtn = new JButton("작업체크"); 
	private JButton addTaskBtn = new JButton("작업생성"); 
	private JButton deleteTaskBtn = new JButton("작업삭제");
	private JButton backBtn = new JButton("뒤로가기");
	private final String[] header = {"작업이름", "마감일", "진행도", "우선순위"};

	private Color color;
	public JobManagePage(User user, Color color) {
		super(user, color);
		this.color = color;

		setTitle("작업관리");
		setSize(1200,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	
		taskTable = new JTable(new DefaultTableModel(loadData(), header));
		taskTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		taskScroll = new JScrollPane(taskTable);

		this.add("Center", taskScroll);
		
		//backBtn.addActionListener(new MoveActionListener(new MainPage(user, color), this));
		backBtn.addActionListener(new moveActionListener());
		BtnPnl.add(completeBtn);
		BtnPnl.add(addTaskBtn);
		BtnPnl.add(deleteTaskBtn);
		BtnPnl.add(backBtn);

		this.add("South", BtnPnl);
		
	}

	private Object[][] loadData() {
		ArrayList<Record> records;
		Object[][] rowData;
		int n;

		user.rank.setRecordManager(RecordType.JOB.ordinal());
		
		records = user.rank.searchRecord(new RecordSearchLocal(user.rank.manager));
		n = records.size();
		rowData = new Object[n][header.length];

		for(int i = 0; i < n; i++) {
			rowData[i][0] = ((Job) records.get(i)).getName(); 
			rowData[i][1] = ((Job) records.get(i)).getDueDate();
			rowData[i][2] = ((Job) records.get(i)).getProgress();
			rowData[i][3] = ((Job) records.get(i)).getPriority();
		}
		return rowData;
	}

	public void display() {
		setVisible(true);
	}


	public class moveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new MainPage(user, color).display();
		}
	}
}