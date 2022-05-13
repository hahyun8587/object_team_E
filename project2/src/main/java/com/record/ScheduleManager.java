package com.record;

import com.std.User;

/**
 * Class that manage schedules.
 */
public class ScheduleManager extends RecordManager {
    @Override
    public void register(User participant, Record record, RecordManager rm) {
        temp = new Scheduled(participant, (Schedule) record, (ScheduleManager) rm, null);

        _notifyAll();
    }

    public void reserveAlarm() {
        /*implement*/
    }
}
