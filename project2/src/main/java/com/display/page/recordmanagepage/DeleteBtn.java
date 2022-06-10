package com.display.page.recordmanagepage;

import java.awt.event.ActionListener;

import com.display.CommonBtn;
import com.display.ComponentMediator;

public class DeleteBtn extends CommonBtn {

    public DeleteBtn(String text, ActionListener al, ComponentMediator mediator) {
        super(text, al, mediator);        
    }

    public void execute() {
        ((RecordManageComponentMediator) mediator).delete();
    }
}
