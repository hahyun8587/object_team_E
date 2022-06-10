package com.display;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public abstract class CommonBtn extends JButton implements Command {
    protected ComponentMediator mediator;

    public CommonBtn(String text, ActionListener al, ComponentMediator mediator) {
        setText(text);
        addActionListener(al);

        this.mediator = mediator;
    }

    public abstract void execute();
}
