package com.std;

import com.record.RecordManager;

public abstract class FullTime extends Rank {
    private String dept;
    //private UIDisplayer displayer;

    public FullTime(String role, String dept) {
        super(role);
        this.dept = dept;
    }

    public void searchRecord() {
        /*implement*/
    }

    public void reserveAlarm() {
        /*implement*/
    }

    public void setRecordManager(RecordManager rm) {
        /*implement*/
    }

}
