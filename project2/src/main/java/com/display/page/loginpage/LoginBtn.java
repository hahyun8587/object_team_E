package com.display.page.loginpage;

import java.awt.event.ActionListener;

import com.display.CommonBtn;
import com.display.ComponentMediator;

public class LoginBtn extends CommonBtn {
    
    public LoginBtn(String text, ActionListener al, ComponentMediator mediator) {
        super(text, al, mediator);
        setBounds(10, 80, 120, 25);
    }

    @Override
    public void execute() {
        ((LoginComponentMediator) mediator).login();
    }
}