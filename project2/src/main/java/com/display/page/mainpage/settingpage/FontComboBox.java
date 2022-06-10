package com.display.page.mainpage.settingpage;

import javax.swing.DefaultComboBoxModel;

import com.display.CommonComboBox;
import com.display.ComponentMediator;

public class FontComboBox extends CommonComboBox {

    public FontComboBox(ComponentMediator mediator) {
        super(mediator);

        setModel(new DefaultComboBoxModel<>(new String[] { "Dialog", "Times", "Courier", "Helvetica", "Monospace" }));
        ((SettingComponentMediator) mediator).registerFontBox(this);
    }
}
