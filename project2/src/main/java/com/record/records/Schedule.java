package com.record.records;

/**
 * Class that represents schedule.
 */

public class Schedule extends Record {
    private String date;

    /**
     * Constructs <code>Schedule</code> object with <code>name</code> and <code>date</code>.
     * @param name name of the schedule
     * @param date date of the schedule
     */
    public Schedule(String name, String date) {
        super(name);
        this.date = date;
    }

    /**
     * Gets date of the schedule.
     * @return date of the schedule
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date of the schedule.
     * @param date date of the schedule to set
     */
    public void setDate(String date) {
        this.date = date;
    }
}