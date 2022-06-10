package com.display.page.recordmanagepage.addpage;

import javax.swing.JTable;

import com.display.FramePage;
import com.display.UIDisplayer;

public class AddScheduleDialog extends AddRecordDialog {

    public AddScheduleDialog(UIDisplayer displayer, FramePage owner, JTable table) {
        super(displayer, owner, table);
    }

    @Override
    protected String[] createArgs() {
        return new String[] { "스케줄이름", "스케줄날짜" };
    }   

    @Override
    protected String createTitle() {
        return "스케줄추가";
    }
}
