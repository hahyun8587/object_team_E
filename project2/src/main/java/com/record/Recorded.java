package com.record;

import com.std.User;

/**
 * Association class that connects <code>User</code> class and <code>Record</code> class.
 * This class represents record of single participant.
 */
public class Recorded {
    private User participant;
    private Record record;

    /**
     * Gets participant of the record.
     * @return participant of the record
     */
    public User getParticipant(){
        return participant;
    }

    /**
     * Gets the record that <code>Recorded</code> object represents.
     * @return the record that <code>Recorded</code> object represents
     */
    public Record getRecord() {
        return record;
    } 

}
