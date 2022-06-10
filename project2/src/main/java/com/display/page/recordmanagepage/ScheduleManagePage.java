package com.display.page.recordmanagepage;

import java.util.ArrayList;

import javax.swing.JCheckBox;

import com.display.UIDisplayer;
import com.record.records.Record;
import com.record.records.Schedule;
import com.std.User;
import com.util.RecordType;

public class ScheduleManagePage extends RecordManagePage {

    public ScheduleManagePage(UIDisplayer displayer, User user) {
        super(displayer, user);        
    }

    @Override
    protected void setRecordManager() {
        user.rank.setRecordManager(RecordType.SCHEDULE);    
    }

    @Override
    protected RecordManageComponentMediator createMediator(JCheckBox[] searchOptions) {
        return new ScheduleManageComponentMediator(displayer, searchOptions);
    }

    @Override
    protected String createTitle() {
        return "스케줄관리";
    }

    @Override
    protected String[] createHeader() {
        return new String[] { "스케줄이름", "스케줄날짜" };
    }

    @Override
    protected String createAddBtnName() {
        return "스케줄추가";
    }

    @Override
    protected String createDeleteBtnName() {
        return "스케줄삭제";
    }

    @Override
    protected void record2Arr(Object[][] data, ArrayList<Record> records) {
        for(int i = 0; i < data.length; i++) {
			data[i][0] = ((Schedule) records.get(i)).getName(); 
			data[i][1] = ((Schedule) records.get(i)).getDate();
		}
    }
}
