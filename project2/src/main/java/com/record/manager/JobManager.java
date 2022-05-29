package com.record.manager;

import java.util.ArrayList;

import com.record.records.Assigned;
import com.record.records.Job;
import com.record.records.Recorded;
import com.util.Mediator;
import com.util.RecordObserver;

/**
 * Class that manages jobs.
 * This class is applied factory design pattern.
 */
public class JobManager extends RecordManager {
    
    /**
     * Constructs <code>JobManager</code> object with <code>assigneds</code>, <code>mediator</code>, and <code>observers</code>.
     * @param assigneds an array list of assigned 
     * @param mediator <code>Mediator</code> object
     * @param observer array list of a specific record observer
     */
    public JobManager(ArrayList<Recorded> assigneds, Mediator mediator, ArrayList<RecordObserver> observers) {
       super(assigneds, mediator, observers);
       
       type = 1;
    }

    @Override
    protected Recorded create(String[] args) {
        return new Assigned(recordeds.get(0).getParticipant(), new Job(args[0], args[1], Integer.parseInt(args[2])));
    }
}
