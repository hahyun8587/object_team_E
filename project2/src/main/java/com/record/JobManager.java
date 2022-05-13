package com.record;

import com.std.User;

public class JobManager extends RecordManager {
    @Override
    public void register(User participant, Record record, RecordManager rm) {
        temp = new Assigned(participant, (Job) record, (JobManager) rm);

        _notifyAll();
    }
}
