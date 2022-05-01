package com.std;

import com.util.RecordManager;

public abstract class FullTime extends Rank {
    private String department;
    //private UIDisplayer displayer;

    public FullTime(String role, String department) {
        super(role);
        this.department = department;
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
