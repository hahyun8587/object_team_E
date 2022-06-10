package com.display.page.mainpage.settingpage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.display.CommonActionListener;
import com.display.ComponentMediator;
import com.display.FrameDialog;
import com.display.FramePage;
import com.display.UIDisplayer;

public class SettingDialog extends FrameDialog {
    
    public SettingDialog(UIDisplayer displayer, FramePage owner) {
        super(displayer, owner);
    }

    @Override
    protected void init() {
        Container contentPane = getContentPane();
        JPanel fontPanel = new JPanel();
        JPanel colorPanel = new JPanel();
        JPanel btnPanel = new JPanel();
        JLabel fontLabel = new JLabel("폰트");
        JLabel colorLabel = new JLabel("배경색");
        JLabel sizeLabel = new JLabel("크기");
        JRadioButton[] radioBtns = { new JRadioButton("plain"), new JRadioButton("bold"), new JRadioButton("italic") };
        ComponentMediator mediator = new SettingComponentMediator(displayer);
        ActionListener al = new CommonActionListener();

        setTitle("설정");
        setSize(400, 300);
        setLayout(new FlowLayout());

        fontPanel.add(fontLabel);
        fontPanel.add(new FontComboBox(mediator));

        new StyleBtnGroup(radioBtns, mediator);
        
        for(JRadioButton btn : radioBtns) 
            fontPanel.add(btn);

        fontPanel.add(sizeLabel);
        fontPanel.add(new SizeComboBox(mediator));

        contentPane.add(fontPanel);

        colorPanel.add(colorLabel);
        colorPanel.add(new ColorComboBox(mediator));

        contentPane.add(colorPanel);

        btnPanel.add(new ConfrimBtn("확인", al, mediator));
        btnPanel.add(new CancelBtn("취소", al, mediator));

        contentPane.add(btnPanel, BorderLayout.SOUTH);
    }
}
