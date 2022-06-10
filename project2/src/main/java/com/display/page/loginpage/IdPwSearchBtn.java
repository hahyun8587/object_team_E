package com.display.page.loginpage;

import java.awt.event.ActionListener;

import com.display.CommonBtn;
import com.display.ComponentMediator;

public class IdPwSearchBtn extends CommonBtn {

    public IdPwSearchBtn(String text, ActionListener al, ComponentMediator mediator) {
        super(text, al, mediator);
        setBounds(160, 80, 120, 25);
    }

    @Override
    public void execute() {
        ((LoginComponentMediator) mediator).idPwSearch();
    }
}
