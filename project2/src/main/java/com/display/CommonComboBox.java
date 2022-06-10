package com.display;

import javax.swing.JComboBox;

public abstract class CommonComboBox extends JComboBox {
    protected ComponentMediator mediator;

    public CommonComboBox(ComponentMediator mediator) {
        this.mediator = mediator;
    }
}
