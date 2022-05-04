package com.record;

/**
 * Associaiton class that connects <code>User</code> class and <code>Schedule</code> class.
 * This class represents schedule of single participant.
 */
public class Scheduled extends Recorded{
    private String alarm;

    /**
     * Sets alarm.
     * @param alarm alarm to set
     */
    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }
}
