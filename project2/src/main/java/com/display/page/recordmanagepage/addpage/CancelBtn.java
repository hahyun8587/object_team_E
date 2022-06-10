package com.display.page.recordmanagepage.addpage;

import java.awt.event.ActionListener;

import com.display.CommonBtn;
import com.display.ComponentMediator;

public class CancelBtn extends CommonBtn {

    public CancelBtn(String text, ActionListener al, ComponentMediator mediator) {
        super(text, al, mediator);
    }

    public void execute() {
        ((AddRecordComponentMediator) mediator).cancel();
    }
}
