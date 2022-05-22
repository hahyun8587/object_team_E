package com.record.manager;

import java.util.ArrayList;

import com.record.records.Assigned;
import com.record.records.Job;
import com.record.records.Recorded;
import com.util.Mediator;

/**
 * Class that manages jobs.
 * This class is applied factory design pattern.
 */
public class JobManager extends RecordManager {
    
    /**
     * Constructs <code>JobManager</code> object with <code>assigneds</code>.
     * @param assigneds an array list of assigned 
     */
    public JobManager(ArrayList<Recorded> assigneds, Mediator mediator) {
       super(assigneds, mediator);
       type = 1;
    }

    @Override
    protected Recorded create(String[] args) {
        return new Assigned(recordeds.get(0).getParticipant(), new Job(args[0], args[1], Integer.parseInt(args[2])));
    }
}
