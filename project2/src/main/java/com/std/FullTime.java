package com.std;

import com.record.RecordManager;

public abstract class FullTime extends Rank {
    private String dept;

    public FullTime(String role, String dept) {
        super(role);
        this.dept = dept;
    }

    /**
     * Deletes ith record.
     * @param i an index of record to delete
     */
    public void deleteRecord(int i) {   
        rm.delete(i);
    }

    public void registerRecord() {
        /*implement*/
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
