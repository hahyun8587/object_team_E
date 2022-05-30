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

import java.util.regex.PatternSyntaxException;
import java.sql.SQLException;

import java.util.ArrayList;
import java.lang.Thread;
import com.DB.*;
import com.DB.loader.*;
import com.display.*;
import com.display.page.*;
import com.std.*;
import com.util.*;

public class MemberManagePage extends JFrame implements Displayable {
	private final String[] column = {"ID","이름"};
	
	private JScrollPane scrolledTable;
	private JTable manageuser;
	private JPanel buttonPanel;
	private JButton usergroupbutton;
	private JButton creatememberbutton;
	private String[][] content;
	private UserAuthentication ua;
	private DAO dao;
	private MemberManagePage mp;
	private DefaultTableModel tableModel;

	public MemberManagePage(){
		
		try{
			dao = DAO.getDAO(GlobalVariables.DRIVER, GlobalVariables.URL,GlobalVariables.ID, GlobalVariables.PASSWORD);

            dao.setLoader(new UserListLoader());
			ua = new UserAuthentication((ArrayList<User>) dao.loadInstance());

			content = new String[ua.getUsers().size()][2];
			for(int i=0;i<content.length;i++){
				content[i][0] = ua.getUsers().get(i).getId();
				content[i][1] = ua.getUsers().get(i).getName();
			}
//			dao.close();
		}
		catch(SQLException e) {
            e.printStackTrace();
        } catch(PatternSyntaxException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
		setTitle("User Manager");
		setSize(1200,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1,2));
		
		tableModel = new DefaultTableModel(content, column);
		
		manageuser = new JTable(tableModel);
		manageuser.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		scrolledTable = new JScrollPane(manageuser);
		this.add(scrolledTable);
		
		buttonPanel = new JPanel(new GridLayout(2,1));
		
		usergroupbutton = new JButton("user group");
		creatememberbutton = new JButton("add member");
		buttonPanel.add(usergroupbutton);
		buttonPanel.add(creatememberbutton);
		this.add(buttonPanel);
		
		mp = this;
		usergroupbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new UserGroupDisplay().display();
			}
		});
		creatememberbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateMemberDisplay(mp).display();
			}
		});
	}
	
	 public void createmember(String[] str){
		tableModel.addRow(str);
	 }

	public void display() {
		setVisible(true);
	}
}