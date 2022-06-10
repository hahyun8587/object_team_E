package com.display.page.recordmanagepage;

import java.awt.event.ActionListener;

import com.display.CommonBtn;
import com.display.ComponentMediator;

public class SearchBtn extends CommonBtn {
    public SearchBtn(String text, ActionListener al, ComponentMediator mediator) {
        super(text, al, mediator);
    }

    public void execute() {
        ((RecordManageComponentMediator) mediator).search();
    }
}
