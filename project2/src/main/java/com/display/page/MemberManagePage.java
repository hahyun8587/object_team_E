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
import com.DB.*;
import com.DB.loader.*;
import com.display.actionListener.MoveActionListener;
import com.std.*;
import com.util.*;

public class MemberManagePage extends FramePage {
	private final String[] column = {"ID","이름"};
	
	private JScrollPane scrolledTable;
	private JTable manageuser;
	private JPanel buttonPanel;
	private JButton usergroupbutton;
	private JButton creatememberbutton;
	private JButton backBtn;
	private String[][] content;
	private UserAuthentication ua;
	private DAO dao;
	private MemberManagePage mp;
	private DefaultTableModel tableModel;

	private Color color;
	public MemberManagePage(User user, Color color){
		super(user, color);

		this.color = color;

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
		backBtn = new JButton("뒤로가기");

		//backBtn.addActionListener(new MoveActionListener(new MainPage(user, color), this));
		
		backBtn.addActionListener(new moveActionListener());
		buttonPanel.add(usergroupbutton);
		buttonPanel.add(creatememberbutton);
		buttonPanel.add(backBtn);
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

	
	public class moveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new MainPage(user, color).display();
		}
	}
}