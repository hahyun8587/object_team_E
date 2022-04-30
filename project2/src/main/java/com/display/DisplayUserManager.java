package com.display;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class DisplayUserManager extends JFrame implements MouseListener{
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
		
		JButton usergroupbutton = new JButton("사용자 그룹");
		JButton creatememberbutton = new JButton("멤버생성");
		buttonPanel.add(usergroupbutton);
		buttonPanel.add(creatememberbutton);
		this.add(buttonPanel);
		
		usergroupbutton.addMouseListener(this);
		creatememberbutton.addMouseListener(this);
		manageuser.addMouseListener(this);
		
		setVisible(true);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	
	public static void main(String[] args) {
		new DisplayUserManager();
	}
}