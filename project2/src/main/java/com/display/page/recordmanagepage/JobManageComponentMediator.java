package com.display.page.recordmanagepage;

import javax.swing.JCheckBox;

import com.display.UIDisplayer;
import com.display.page.recordmanagepage.addpage.AddJobDialog;

public class JobManageComponentMediator extends RecordManageComponentMediator {

    public JobManageComponentMediator(UIDisplayer displayer, JCheckBox[] searchOptions) {
        super(displayer, searchOptions);
    }

    @Override
    public void add() {
        branch(new AddJobDialog(displayer, displayer.getCurrentPage(), table));
    } 
}
