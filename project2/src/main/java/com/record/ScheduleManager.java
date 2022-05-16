package com.record;

import com.DB.Query;
import com.std.User;

/**
 * Class that manages schedules.
 */
public class ScheduleManager extends RecordManager {
    @Override
    public void register(User participant, Record record, RecordManager rm) {
        sql = Query.getInsertQuery(new Scheduled(participant, (Schedule) record, (ScheduleManager) rm, null));

        _notifyAll();
    }

    public void reserveAlarm() {
        /*implement*/
    }
}
