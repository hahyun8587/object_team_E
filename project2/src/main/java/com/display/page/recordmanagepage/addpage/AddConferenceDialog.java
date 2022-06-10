package com.display.page.recordmanagepage.addpage;

import javax.swing.JTable;
import javax.swing.JTextField;

import com.display.FramePage;
import com.display.UIDisplayer;

public class AddConferenceDialog extends AddRecordDialog {

    public AddConferenceDialog(UIDisplayer displayer, FramePage owner, JTable table) {
        super(displayer, owner, table);
    }

    @Override
    protected String[] createArgs() {
        return new String[] { "회의이름", "회의날짜" };
    }   

    @Override
    protected String createTitle() {
        return "회의기록추가";
    }
}
