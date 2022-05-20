package com.record;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;

import com.std.User;

/**
 * Class that represents record.
 */
public abstract class Record {
    private String name;
    private Vector<Recorded> recordeds = new Vector<Recorded>();

    /**
     * Constructs <code>Record</code> object with <code>name</code>.
     * @param name name of the record
     */
    public Record(String name) {
        this.name = name;
    }

    /**
     * Adds <code>recorded</code> to <code>Record</code> object.
     * @param recorded recorded to add
     */
    public void add(Recorded recorded) {
        recordeds.add(recorded);
    }

    /**
     * Remove specific </code>Reocroded</code> object in array list. 
     * @param recorded a <code>Recorded</code> object to remove
     */
    public void delete(Recorded recorded) {
        recordeds.remove(recorded);
    }

    /**
     * Gets each participant of all <code>Recorded</code> objects in array list.  
     * @return an array list of participant
     */
    public ArrayList<User> getAllParticipants() {
        ArrayList<User> participants = new ArrayList<User>();
        Iterator<Recorded> it = recordeds.iterator();

        while(it.hasNext()) 
            participants.add(it.next().getParticipant());
        
        return participants;
    }

    /**
     * Gets name of the record.
     * @return name of the record
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the record.
     * @param name name of the record to set
     */
    public void setName(String name) {
        this.name = name;
    }
}