package com.display;

//작성자: 허승돈

import javax.swing.*;

import javafx.event.ActionEvent;

import java.awt.*;
import java.awt.event.*;

public class CreateMemberDisplay extends JFrame implements Displayable {
	private final String[] labels= {"ID","Password","이름","직책"};
	private JTextField []field = new JTextField[4];
	private JButton confirmBtn;
	private JButton cancelBtn;
	private JPanel textPnl, btnPnl;
	public CreateMemberDisplay(MemberManagePage mp)
	{
		setTitle("Add Member Manager");
		setSize(300,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		setLayout(new BorderLayout());
		textPnl = new JPanel(new GridLayout(4,2));
		for(int i=0;i<4;i++) {
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

		// confirmBtn.addActionListener(new ActionListener(){
		// 	public void actionPerformed(ActionEvent e){
				
		// 	}
		// });
	}

	public void display() {
		setVisible(true);
	}
}