package com.display.page.mainpage.settingpage;

import java.awt.event.ActionListener;

import com.display.CommonBtn;
import com.display.ComponentMediator;

public class ConfrimBtn extends CommonBtn {
    
    public ConfrimBtn(String text, ActionListener al, ComponentMediator mediator) {
        super(text, al, mediator);
    }
    
    public void execute() {
        ((SettingComponentMediator) mediator).confirm();
    }
}
