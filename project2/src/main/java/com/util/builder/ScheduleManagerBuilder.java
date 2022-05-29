package com.util.builder;

import java.util.ArrayList;

import com.record.records.Recorded;
import com.record.manager.RecordManager;
import com.record.manager.ScheduleManager;

/**
 * Class that builds <code>ScheduleManager</code> object.
 * This class is applied builder design pattern.
 */
public class ScheduleManagerBuilder extends RecordManagerBuilder {
    
     /**
     * Constructs <code>ScheduleManagerBuilder</code> object with <code>recordeds</code>.
     * @param recordeds array list of <code>Scheduled</code> object that used to construct <code>ScheduleManager</code> object
     */
    public ScheduleManagerBuilder(ArrayList<Recorded> recordeds) {
        super(recordeds);
    }
    
    @Override
    public RecordManager build() {
        return new ScheduleManager(recordeds, mediator, observers);
    }

}
