package com.display.page.mainpage.settingpage;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import com.display.ComponentMediator;

public class StyleBtnGroup extends ButtonGroup {
    private ComponentMediator mediator;
    
    public StyleBtnGroup(JRadioButton[] radioBtns, ComponentMediator mediator) {
        this.mediator = mediator;

        for(int i = 0; i < radioBtns.length; i++) {
            radioBtns[i].setActionCommand(String.valueOf(i));
            add(radioBtns[i]);
        }
        ((SettingComponentMediator) mediator).registerStyleBtnGroup(this);
    }
}
