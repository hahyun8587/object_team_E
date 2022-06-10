package com.display.page.mainpage.settingpage;

import java.awt.Color;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import com.display.ComponentMediator;
import com.display.UIDisplayer;

public class SettingComponentMediator extends ComponentMediator {
    private JComboBox<String> fontBox;
    private JComboBox<Color> colorBox;
    private JComboBox<Integer> sizeBox;
    private ButtonGroup styleBtnGroup; 

    public SettingComponentMediator(UIDisplayer displayer) {
        super(displayer);
    }

    public void confirm() {
        FontUIResource resource = new FontUIResource(new Font((String) fontBox.getSelectedItem(), Integer.parseInt(styleBtnGroup.getSelection().getActionCommand()), (int) sizeBox.getSelectedItem()));
        Enumeration<Object> enumeration =  UIManager.getDefaults().keys();
        
        while(enumeration.hasMoreElements()) {
            Object key = enumeration.nextElement();

            if(UIManager.get(key) instanceof FontUIResource)
                UIManager.put(key, resource);
        }
        UIManager.put("Panel.background", new ColorUIResource((Color) colorBox.getSelectedItem()));
        prune();
    }

    public void cancel() {
        prune();
    }

    public void registerFontBox(JComboBox<String> fontBox) {
        this.fontBox = fontBox;
    }

    public void registerStyleBtnGroup(ButtonGroup styleBtnGroup) {
        this.styleBtnGroup = styleBtnGroup;
    }

    public void registerSizeBox(JComboBox<Integer> sizeBox) {
        this.sizeBox = sizeBox;
    }

    public void registerColorBox(JComboBox<Color> colorBox) {
        this.colorBox = colorBox;
    }

    
}
