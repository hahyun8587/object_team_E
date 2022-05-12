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

    /**
     * Sets record manager of <code>FullTime</code> object.
     * @param rm record manager to set
     */
    public void setRecordManager(RecordManager rm) {
        this.rm = rm;
    }
}
