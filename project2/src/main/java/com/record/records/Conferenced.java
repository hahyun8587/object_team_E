package com.record.records;

import com.std.User;

/**
 * Association class that connects <code>User</code> and <code>Conference</code>.
 * This class represents a conference of single participant. 
 */
public class Conferenced extends Recorded {
    /**
     * Constructs <code>Conferenced</code> object with <code>participant</code>, <code>conference</code>, and <code>cm</code>.
     * @param participant participant of the conference 
     * @param conference the conference that <code>Conferenced</code> object represents
     * @param cm conference manger that manages the <code>Conferenced</code> object
     */
    public Conferenced(User participant, Conference conference) {
        super(participant, conference);
    }

    @Override 
    public String toString() {
        return "conference";
    }
}