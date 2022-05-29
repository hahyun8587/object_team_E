package com.record.manager;

import java.util.ArrayList;

import com.record.records.Recorded;
import com.record.records.Schedule;
import com.record.records.Scheduled;
import com.util.Mediator;
import com.util.RecordObserver;

/**
 * Class that manages schedules.
 */
public class ScheduleManager extends RecordManager {

    /**
     * Constructs <code>ScheduleManager</code> object with <code>scheduleds</code>, <code>mediator</code>, and <code>observers</code>.
     * @param conferenceds array list of scheduled 
     * @param mediator <code>Mediator</code> object
     * @param observer array list of a specific record obeserver
     */
    public ScheduleManager(ArrayList<Recorded> scheduleds, Mediator mediator, ArrayList<RecordObserver> observers) {
        super(scheduleds, mediator, observers);
        
        type = 2;
    }

    @Override
    protected Recorded create(String[] args) {
        return new Scheduled(recordeds.get(0).getParticipant(), new Schedule(args[0], args[1]), args[2]);
    }

    public void reserveAlarm() {
        /*implement*/
    }
}
