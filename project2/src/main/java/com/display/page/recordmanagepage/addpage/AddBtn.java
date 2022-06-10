package com.display.page.recordmanagepage.addpage;

import java.awt.event.ActionListener;

import com.display.CommonBtn;
import com.display.ComponentMediator;

import java.sql.SQLException;

public class AddBtn extends CommonBtn {

    public AddBtn(String text, ActionListener al, ComponentMediator mediator) {
        super(text, al, mediator);
    }

    public void execute() {
        try {
            ((AddRecordComponentMediator) mediator).add();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
