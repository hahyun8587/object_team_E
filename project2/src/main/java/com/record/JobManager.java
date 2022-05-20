package com.record;

import java.util.ArrayList;

/**
 * Class that manages jobs.
 * This class is applied factory design pattern.
 */
public class JobManager extends RecordManager {
    
    /**
     * Constructs <code>JobManager</code> object with <code>assigneds</code>.
     * @param assigneds an array list of assigned 
     */
    public JobManager(ArrayList<Recorded> assigneds) {
       super(assigneds);
    }

    @Override
    protected Recorded create(String[] args) {
        return new Assigned(recordeds.get(0).getParticipant(), new Job(args[0], args[1], Integer.parseInt(args[2])));
    }

    @Override
    public int registerTo(String id, String[] args) {
        return mediator.sendRegisteration(id, args, 1);
    }

    @Override
    public int deleteFrom(String id, int i) {
        return mediator.sendDeletion(id, 1, i);
    }
}
