package com.record;

import java.util.ArrayList;

/**
 * Class that manages schedules.
 */
public class ScheduleManager extends RecordManager {

    /**
     * Constructs <code>ScheduleManager</code> object with <code>scheduleds</code>.
     * @param conferenceds an array list of scheduled 
     */
    public ScheduleManager(ArrayList<Recorded> scheduleds) {
        super(scheduleds);
    }

    @Override
    protected Recorded create(String[] args) {
        return new Scheduled(recordeds.get(0).getParticipant(), new Schedule(args[0], args[1]), args[2]);
    }

    @Override
    public int registerTo(String id, String[] args) {
        return mediator.sendRegisteration(id, args, 2);
    }

    @Override
    public int deleteFrom(String id, int i) {
        return mediator.sendDeletion(id, 2, i);
    }

    public void reserveAlarm() {
        /*implement*/
    }
}
