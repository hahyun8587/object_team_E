package com.record.manager;

import java.util.ArrayList;

import com.record.records.Conference;
import com.record.records.Conferenced;
import com.record.records.Recorded;
import com.util.Mediator;
import com.util.RecordObserver;

/**
 * Class that manages conferences.
 * This class is applied factory design pattern.
 */
public class ConferenceManager extends RecordManager {

    /**
     * Constructs <code>ConferenceManager</code> object with <code>conferenceds</code>, <code>mediator</code>, and <code>observer</code>.
     * @param conferenceds array list of <code>Conferenced</code> object
     * @param mediator <code>Mediator</code> object
     * @param observer array list of a specific record observer
     */
    public ConferenceManager(ArrayList<Recorded> conferenceds, Mediator mediator, ArrayList<RecordObserver> observers) {
        super(conferenceds, mediator, observers);

        type = 0;
    }

    @Override
    protected Recorded create(String[] args) {
        return new Conferenced(recordeds.get(0).getParticipant(), new Conference(args[0]));
    }
}
