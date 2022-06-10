package com.display.page.mainpage.settingpage;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;

import com.display.CommonComboBox;
import com.display.ComponentMediator;

public class ColorComboBox extends CommonComboBox {

    public ColorComboBox(ComponentMediator mediator) {
        super(mediator);

        setModel(new DefaultComboBoxModel<>(new Color[] { Color.BLACK, Color.BLUE, Color.CYAN, Color.LIGHT_GRAY, Color.WHITE }));
        ((SettingComponentMediator) mediator).registerColorBox(this);
    }
}
