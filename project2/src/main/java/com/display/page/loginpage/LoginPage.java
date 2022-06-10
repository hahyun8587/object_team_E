package com.display.page.loginpage;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

import com.display.CommonActionListener;
import com.display.FramePage;
import com.display.ComponentMediator;
import com.display.UIDisplayer;
import com.util.UserAuthentication;

public class LoginPage extends FramePage {
	private UserAuthentication ua;
	
	public LoginPage(UIDisplayer displayer, UserAuthentication ua) {
		super(displayer);	

		this.ua = ua;
	}

	@Override
	protected void init() {
		JPanel loginPanel = new JPanel();
		JLabel idLabel = new JLabel("아이디");
		JLabel pwLabel = new JLabel("비밀번호");
		ActionListener al = new CommonActionListener();
		ComponentMediator mediator = new LoginComponentMediator(displayer);


		setTitle("로그인 창");
		setSize(350, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		loginPanel.setLayout(null);
		idLabel.setHorizontalAlignment(NORMAL);
		pwLabel.setHorizontalAlignment(NORMAL);
		idLabel.setBounds(10, 10, 100, 25);
		pwLabel.setBounds(10, 40, 100, 25);
		
		loginPanel.add(idLabel);
		loginPanel.add(pwLabel);
		loginPanel.add(new IdTextField(mediator));
		loginPanel.add(new PwTextField(mediator));
		loginPanel.add(new LoginBtn("로그인", al, mediator));
		loginPanel.add(new IdPwSearchBtn("아이디/비밀번호 찾기", al, mediator));

		getContentPane().add(loginPanel);

		setLocationRelativeTo(null);
	}

	public UserAuthentication getUa() {
		return ua;
	}
}