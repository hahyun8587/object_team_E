package com.record.manager;

import java.util.ArrayList;

import com.record.records.Recorded;
import com.record.records.Schedule;
import com.record.records.Scheduled;
import com.util.Mediator;

/**
 * Class that manages schedules.
 */
public class ScheduleManager extends RecordManager {

    /**
     * Constructs <code>ScheduleManager</code> object with <code>scheduleds</code>.
     * @param conferenceds an array list of scheduled 
     */
    public ScheduleManager(ArrayList<Recorded> scheduleds, Mediator mediator) {
        super(scheduleds, mediator);
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
