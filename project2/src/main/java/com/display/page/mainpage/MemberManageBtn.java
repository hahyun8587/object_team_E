package com.display.page.mainpage;

import java.awt.event.ActionListener;

import com.display.CommonBtn;
import com.display.ComponentMediator;

public class MemberManageBtn extends CommonBtn {

    public MemberManageBtn(String text, ActionListener al, ComponentMediator mediator) {
        super(text, al, mediator);
    }

    public void execute() {
        ((MainComponentMediator) mediator).memberManage();
    }
}