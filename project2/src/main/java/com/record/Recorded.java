package com.record;

import com.std.User;

/**
 * Association class that connects <code>User</code> class and <code>Record</code> class.
 * This class represents a record of single participant.
 */
public class Recorded {
    private User participant;
    private Record record;

    /**
     * Constructs <code>Recorded</code> object with <code>participant</code> and <code>record</code>.
     * Constructed <code>Recorded</code> object is added to <code>Record</code> object and <code>rm</code> object that the constructor got.
     * @param participant a participant of the record 
     * @param record the record that <code>Recorded</code> object represents 
     * @param rm a record manager that manages the <code>Recorded</code> object
     */
    public Recorded(User participant, Record record, RecordManager rm) {
        this.participant = participant;
        this.record = record;

        record.add(this);
        rm.addRecorded(this);
    }

    /**
     * Gets a participant from <code>Recorded</code> object.
     * @return a participant of record
     */
    public User getParticipant(){
        return participant;
    }

    /**
     * Gets a record from <code>Recorded</code> object.
     * @return a record that <code>Recorded</code> object represents
     */
    public Record getRecord() {
        return record;
    } 
}