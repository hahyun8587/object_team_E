package com.record;

import com.std.User;

/**
 * Class that manages conferences.
 */
public class ConferenceManager extends RecordManager {
    @Override
    public void register(User participant, Record record, RecordManager rm) {
        temp = new Conferenced(participant, (Conference) record, (ConferenceManager) rm);

        _notifyAll();
    }
}
