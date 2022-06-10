package com.display.page.recordmanagepage;

import javax.swing.JTextField;

import com.display.ComponentMediator;

public class SearchField extends JTextField {
    private ComponentMediator mediator;

    public SearchField(ComponentMediator mediator) {
        this.mediator = mediator;
        
        ((RecordManageComponentMediator) mediator).registerSearchField(this);
    }
}
