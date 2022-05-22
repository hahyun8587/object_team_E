package com.record.manager;

import java.util.ArrayList;

import com.record.records.Conference;
import com.record.records.Conferenced;
import com.record.records.Recorded;
import com.util.Mediator;

/**
 * Class that manages conferences.
 */
public class ConferenceManager extends RecordManager {

    /**
     * Constructs <code>ConferenceManager</code> object with <code>conferenceds</code>.
     * @param conferenceds an array list of conferenced 
     */
    public ConferenceManager(ArrayList<Recorded> conferenceds, Mediator mediator) {
        super(conferenceds, mediator);

        type = 0;
    }

    @Override
    protected Recorded create(String[] args) {
        return new Conferenced(recordeds.get(0).getParticipant(), new Conference(args[0]));
    }
}
