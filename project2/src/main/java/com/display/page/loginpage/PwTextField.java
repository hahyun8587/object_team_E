package com.display.page.loginpage;

import javax.swing.JPasswordField;

import com.display.ComponentMediator;

public class PwTextField extends JPasswordField {
    private ComponentMediator mediator;

    public PwTextField(ComponentMediator mediator) {
        this.mediator = mediator;

        setBounds(100, 40, 100, 25);
        ((LoginComponentMediator) mediator).registerPw(this);
    }
}
