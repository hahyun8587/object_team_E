package com.display.page.mainpage.settingpage;

import javax.swing.DefaultComboBoxModel;

import com.display.CommonComboBox;
import com.display.ComponentMediator;

public class SizeComboBox extends CommonComboBox {

    public SizeComboBox(ComponentMediator mediator) {
        super(mediator);
        
        setModel(new DefaultComboBoxModel<>(new Integer[] { 10, 12, 15, 20, 25, 30, 35 }));
        ((SettingComponentMediator) mediator).registerSizeBox(this);
    }
}
