package com.display.page.recordmanagepage.addpage;

import javax.swing.JTable;
import javax.swing.JTextField;

import com.display.FramePage;
import com.display.UIDisplayer;

public class AddJobDialog extends AddRecordDialog {

    public AddJobDialog(UIDisplayer displayer, FramePage owner, JTable table) {
        super(displayer, owner, table);
    }

    @Override
    protected String[] createArgs() {
        return new String[] { "작업이름", "마감일", "진행도", "우선순위" };
    }   

    @Override
    protected String createTitle() {
        return "작업추가";
    }
}
