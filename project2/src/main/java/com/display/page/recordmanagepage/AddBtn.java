package com.display.page.recordmanagepage;

import java.awt.event.ActionListener;

import com.display.CommonBtn;
import com.display.ComponentMediator;

public class AddBtn extends CommonBtn {
    
    public AddBtn(String text, ActionListener al, ComponentMediator mediator) {
        super(text, al, mediator);        
    }

    public void execute() {
        ((RecordManageComponentMediator) mediator).add();
    }
}
