package com.display.page.recordmanagepage.addpage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.display.CommonActionListener;
import com.display.ComponentMediator;
import com.display.FrameDialog;
import com.display.FramePage;
import com.display.UIDisplayer;
import com.display.page.loginpage.IdTextField;

public abstract class AddRecordDialog extends FrameDialog {
	protected JTable table;

	public AddRecordDialog(UIDisplayer displayer, FramePage owner, JTable table) {
		super(displayer, owner);
		
		this.table = table;
	}

	@Override
	public void init() {
		String[] args = createArgs();
		JPanel textPnl = new JPanel(new GridLayout(args.length + 1, 2));
		JPanel btnPnl = new JPanel(new FlowLayout());
		JTextField[] argsFields = new JTextField[args.length];
		ActionListener al = new CommonActionListener();
		ComponentMediator mediator = new AddRecordComponentMediator(displayer, table, argsFields);

		setTitle(createTitle());
		setSize(300,400);
		setLayout(new BorderLayout());	

		textPnl.add(new JLabel("id"));
		textPnl.add(new IdField(mediator));

		for(int i = 0; i < args.length; i++) { 
			textPnl.add(new JLabel(args[i]));
			argsFields[i] = new JTextField();
			textPnl.add(argsFields[i]);
		}
		add(textPnl, BorderLayout.CENTER);

		btnPnl.add(new AddBtn("추가", al, mediator));
		btnPnl.add(new CancelBtn("취소", al, mediator));
		add(btnPnl, BorderLayout.SOUTH);
	}

	protected abstract String[] createArgs();
	protected abstract String createTitle();
}