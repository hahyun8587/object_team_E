package com.display.page.recordmanagepage;

import javax.swing.JCheckBox;

import com.display.UIDisplayer;
import com.display.page.recordmanagepage.addpage.AddConferenceDialog;

public class ConferenceManageComponentMediator extends RecordManageComponentMediator {
    
    public ConferenceManageComponentMediator(UIDisplayer displayer, JCheckBox[] searchOptions) {
        super(displayer, searchOptions);
    }

    @Override
    public void add() {
        branch(new AddConferenceDialog(displayer, displayer.getCurrentPage(), table));
    }
}
