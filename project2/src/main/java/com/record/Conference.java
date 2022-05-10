package com.record;

/**
 * Class that represents conference.
 */
public class Conference extends Record {
    private String date;

    /**
     * Constructs <code>Conference</code> object with <code>name</code>.
     * @param name name of the conference
     */    
    public Conference(String name) {
        super(name);
    }

    /**
     * Sets date of the conference.
     * @param date date of the conference to set
     */
    public void setDate(String date) {
        this.date = date;
    }
}