package com.record;

import com.DB.Query;
import com.std.User;

/**
 * Class that manages conferences.
 */
public class ConferenceManager extends RecordManager {
    @Override
    public void register(User participant, Record record, RecordManager rm) {
        sql = Query.getInsertQuery(new Conferenced(participant, (Conference) record, (ConferenceManager) rm));

        _notifyAll();
    }
}
