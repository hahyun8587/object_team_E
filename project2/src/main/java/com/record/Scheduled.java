package com.record;

import com.std.User;

/**
 * Associaiton class that connects <code>User</code> class and <code>Schedule</code> class.
 * This class represents schedule of single participant.
 */
public class Scheduled extends Recorded{
    private String alarm;

    /**
     * Constructs <code>Scheduled</code> object with <code>participant</code>, <code>schedule</code>, <code>sm</code>, and <code>alaram</code>.
     * @param participant participant of the schedule
     * @param schedule the schedule that <code>Scheduled</code> object represents
     * @param sm schedule manager that manages the <code>Scheduled</code> object
     * @param alarm alarm that participant of the schedule setted
     */
    public Scheduled(User participant, Schedule schedule, String alarm) {
        super(participant, schedule);
        
        this.alarm = alarm;
    }
    
    @Override
    public String toString() {
        return "schedule";
    }

    /**
     * Sets alarm.
     * @param alarm alarm to set
     */
    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }
}