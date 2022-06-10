package com.display.page.loginpage;

import javax.swing.JTextField;

import com.display.ComponentMediator;

public class IdTextField extends JTextField {
    private ComponentMediator mediator;

    public IdTextField(ComponentMediator mediator) {
        this.mediator = mediator;

        setBounds(100, 10, 100, 25);
        ((LoginComponentMediator) mediator).registerId(this);
    }
}
