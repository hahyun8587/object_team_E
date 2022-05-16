package com.record;

import com.DB.Query;
import com.std.User;

/**
 * Class that manages jobs.
 */
public class JobManager extends RecordManager {
    @Override
    public void register(User participant, Record record, RecordManager rm) {
        sql = Query.getInsertQuery(new Assigned(participant, (Job) record, (JobManager) rm));

        _notifyAll();
    }
}
