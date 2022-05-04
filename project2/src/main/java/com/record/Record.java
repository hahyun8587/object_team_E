package com.record;

import java.util.Vector;

/**
 * Class that represents record.
 */
public class Record {
    private String name;
    private Vector<Recorded> recordeds;

    /**
     * Constructs <code>Record</code> object with <code>name</code>.
     * @param name name of the record
     */
    public Record(String name) {
        this.name = name;
    }

    public void add() {
        /*implement*/
    }

    public void delete() {
        /*implement*/
    }

    public void getAllParticipants() {
        /*implement*/
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