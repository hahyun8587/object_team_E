package com.display.page.recordmanagepage;

import java.util.ArrayList;

import javax.swing.JCheckBox;

import com.display.UIDisplayer;
import com.record.records.Job;
import com.record.records.Record;
import com.std.User;
import com.util.RecordType;

public class JobManagePage extends RecordManagePage {
    
    public JobManagePage(UIDisplayer displayer, User user) {
        super(displayer, user);            
    }

    @Override
    protected void setRecordManager() {
        user.rank.setRecordManager(RecordType.JOB);
    }

    @Override
    protected RecordManageComponentMediator createMediator(JCheckBox[] searchOptions) {
        return new JobManageComponentMediator(displayer, searchOptions);
    }

    @Override
    protected String createTitle() {
        return "작업관리";
    }

    protected String[] createHeader() {
        return new String[] { "작업이름", "마감일", "진행도", "우선순위" };
    }

    @Override
    protected String createAddBtnName() {
        return "작업추가";
    }

    @Override
    protected String createDeleteBtnName() {
        return "작업삭제";
    }

    @Override
    protected void record2Arr(Object[][] data, ArrayList<Record> records) {
        for(int i = 0; i < data.length; i++) {
			data[i][0] = ((Job) records.get(i)).getName(); 
			data[i][1] = ((Job) records.get(i)).getDueDate();
			data[i][2] = ((Job) records.get(i)).getProgress();
			data[i][3] = ((Job) records.get(i)).getPriority();
		}
    }

}
