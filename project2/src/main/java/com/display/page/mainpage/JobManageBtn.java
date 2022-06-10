package com.display.page.mainpage;

import java.awt.event.ActionListener;

import com.display.CommonBtn;
import com.display.ComponentMediator;

public class JobManageBtn extends CommonBtn {

    public JobManageBtn(String text, ActionListener al, ComponentMediator mediator) {
        super(text, al, mediator);
    }

    public void execute() {
        ((MainComponentMediator) mediator).jobManage();
    }
}
