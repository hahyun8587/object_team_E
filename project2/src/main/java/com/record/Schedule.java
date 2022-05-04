package com.record;

/**
 * Class that represents schedule.
 */


public class Schedule extends Record {
    private String date;    

    public Schedule(String name) {
        super(name);
    }
    /**
     * Sets date of the schedule.
     * @param date date of the schedule to set
     */
    public void setDate(String date) {
        this.date = date;
    }
}
