package com.display;

//��µ� ����

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateMemberDisplay extends FramePage implements Displayable {
	private final String[] labels= {"test"," test1","test2  "};
	private JTextField []field = new JTextField[3];
	private JButton confirmBtn;
	private JButton cancelBtn;
	private JPanel textPnl, btnPnl;
	public CreateMemberDisplay()
	{
		setTitle("Add Member Manager");
		setSize(300,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		setLayout(new BorderLayout());
		textPnl = new JPanel(new GridLayout(3,2));
		for(int i=0;i<3;i++) {
			textPnl.add(new JLabel(labels[i]));
			field[i] = new JTextField(30);
			textPnl.add(field[i]);
		}
		add("Center",textPnl);
		
		btnPnl = new JPanel(new FlowLayout());
		confirmBtn = new JButton("confirm");
		cancelBtn = new JButton("cancel");
		btnPnl.add(confirmBtn);
		btnPnl.add(cancelBtn);
		add("South",btnPnl);
	}

	public void display() {
		setVisible(true);
	}
}