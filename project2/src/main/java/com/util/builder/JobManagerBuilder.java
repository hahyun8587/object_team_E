package com.util.builder;

import java.util.ArrayList;

import com.record.records.Recorded;
import com.record.manager.RecordManager;
import com.record.manager.JobManager;

/**
 * Class that builds <code>JobManager</code> object.
 * This class is applied builder design pattern.
 */
public class JobManagerBuilder extends RecordManagerBuilder {
    
    /**
     * Constructs <code>JobManagerBuilder</code> object with <code>recordeds</code>.
     * @param recordeds array list of <code>Assigned</code> object that used to construct <code>JobManager</code> object
     */
    public JobManagerBuilder(ArrayList<Recorded> recordeds) {
        super(recordeds);
    }

    @Override
    public RecordManager build() {
        return new JobManager(recordeds, mediator, observers);
    }
}
