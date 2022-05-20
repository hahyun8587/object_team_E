package com.record;

import java.util.ArrayList;

/**
 * Class that manages conferences.
 */
public class ConferenceManager extends RecordManager {

    /**
     * Constructs <code>ConferenceManager</code> object with <code>conferenceds</code>.
     * @param conferenceds an array list of conferenced 
     */
    public ConferenceManager(ArrayList<Recorded> conferenceds) {
        super(conferenceds);
    }

    @Override
    protected Recorded create(String[] args) {
        return new Conferenced(recordeds.get(0).getParticipant(), new Conference(args[0]));
    }

    @Override
    public int registerTo(String id, String[] args) {
       return mediator.sendRegisteration(id, args, 0);
    }

    @Override
    public int deleteFrom(String id, int i) {
        return mediator.sendDeletion(id, 0, i);
    }
}
