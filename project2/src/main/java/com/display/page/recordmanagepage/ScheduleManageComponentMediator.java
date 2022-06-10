package com.display.page.recordmanagepage;

import javax.swing.JCheckBox;

import com.display.UIDisplayer;
import com.display.page.recordmanagepage.addpage.AddScheduleDialog;

public class ScheduleManageComponentMediator extends RecordManageComponentMediator {
    
    public ScheduleManageComponentMediator(UIDisplayer displayer, JCheckBox[] searchOptions) {
        super(displayer, searchOptions);
    }

    @Override
    public void add() {
        branch(new AddScheduleDialog(displayer, displayer.getCurrentPage(), table));
    }
}