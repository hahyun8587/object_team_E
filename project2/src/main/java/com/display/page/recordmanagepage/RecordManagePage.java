package com.display.page.recordmanagepage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

import com.display.CorePage;
import com.display.UIDisplayer;
import com.display.BackBtn;
import com.display.CommonActionListener;
import com.display.ComponentMediator;
import com.record.records.Record;
import com.std.User;
import com.util.search.RecordSearchLocal;

public abstract class RecordManagePage extends CorePage {
	private String[] header;

	public RecordManagePage(UIDisplayer displayer, User user) {
		super(displayer, user);
	}

	@Override
	protected void init() {
		JPanel btnPanel = new JPanel(new FlowLayout());
		JCheckBox localSearchBox = new JCheckBox("지역조회");
		JCheckBox globalSearchBox = new JCheckBox("전체조회");
		JCheckBox nameSearchBox = new JCheckBox("이름조회"); 
		ActionListener al = new CommonActionListener();
		ComponentMediator mediator = createMediator(new JCheckBox[] { localSearchBox, globalSearchBox, nameSearchBox });	
		
		setRecordManager();
		setTitle(createTitle());
		setSize(1200,900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		header = createHeader();
		
		add(new JScrollPane(new RecordTable(mediator, loadData(), header)), BorderLayout.NORTH);
		
		btnPanel.add(new BackBtn(al, mediator));
		btnPanel.add(new AddBtn(createAddBtnName(), al, mediator));
		btnPanel.add(new DeleteBtn(createDeleteBtnName(), al, mediator));
		btnPanel.add(localSearchBox);
		btnPanel.add(globalSearchBox);
		btnPanel.add(nameSearchBox);
		btnPanel.add(new SearchField(mediator));

		add(btnPanel, BorderLayout.SOUTH);
	}

	public Object[][] loadData() {
		ArrayList<Record> records;
		Object[][] data;
		int n;
		
		records = user.rank.searchRecord(new RecordSearchLocal(user.rank.getSelectedManager()));
		n = records.size();
	    data = new Object[n][header.length];

		record2Arr(data, records);

		System.out.println(data[0][0]);

		return data;
	}

	protected abstract void setRecordManager();
	protected abstract RecordManageComponentMediator createMediator(JCheckBox[] searchOptions);
	protected abstract String createTitle();
	protected abstract String[] createHeader();
	protected abstract String createAddBtnName();
	protected abstract String createDeleteBtnName();
	protected abstract void record2Arr(Object[][] data, ArrayList<Record> records);

	public String[] getHeader() {
		return header;
	}
}