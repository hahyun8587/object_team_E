package com.util.builder;

import java.util.ArrayList;

import com.record.records.Recorded;
import com.record.manager.RecordManager;
import com.record.manager.ConferenceManager;

/**
 * Class that builds <code>ConferenceManager</code> object.
 * This class is applied builder design pattern.
 */
public class ConferenceManagerBuilder extends RecordManagerBuilder {

    /**
     * Constructs <code>ConferenceManagerBuilder</code> object with <code>recordeds</code>.
     * @param recordeds array list of <code>Conferenced</code> object that used to construct <code>ConferenceManger</code> object
     */
    public ConferenceManagerBuilder(ArrayList<Recorded> recordeds) {
        super(recordeds);
    }

    @Override
    public RecordManager build() {
        return new ConferenceManager(recordeds, mediator, observers);
    }
}
