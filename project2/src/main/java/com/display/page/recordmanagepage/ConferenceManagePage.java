package com.display.page.recordmanagepage;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import com.display.UIDisplayer;
import com.record.records.Conference;
import com.record.records.Record;
import com.std.User;
import com.util.RecordType;


public class ConferenceManagePage extends RecordManagePage {
    
    public ConferenceManagePage(UIDisplayer displayer, User user) {
        super(displayer, user);            
    }

    @Override
    protected void setRecordManager() {
        user.rank.setRecordManager(RecordType.CONFERENCE);
    }

    @Override
    protected RecordManageComponentMediator createMediator(JCheckBox[] searchOptions) {
        return new ConferenceManageComponentMediator(displayer, searchOptions);
    }

    @Override
    protected String createTitle() {
        return "회의기록관리";
    }

    @Override
    protected String[] createHeader() {
        return new String[] { "회의제목", "회의날짜" };
    }

    @Override
    protected String createAddBtnName() {
        return "회의기록추가";
    }

    @Override
    protected String createDeleteBtnName() {
        return "회의기록삭제";
    }

    @Override
    protected void record2Arr(Object[][] data, ArrayList<Record> records) {
        for(int i = 0; i < data.length; i++) {
			data[i][0] = ((Conference) records.get(i)).getName(); 
			data[i][1] = ((Conference) records.get(i)).getDate();
		}
    }
}
