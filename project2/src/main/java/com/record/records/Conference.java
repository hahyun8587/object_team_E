package com.record.records;

/**
 * Class that represents conference.
 */
public class Conference extends Record {
    private String date;

    /**
     * Constructs <code>Conference</code> object with <code>name</code>.
     * @param name name of the conference
     * @param date date of the conference
     */    
    public Conference(String name, String date) {
        super(name);
        
        this.date = date;
    }

    /**
     * Gets date of the conference.
     * @return date of the conference
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date of the conference.
     * @param date date of the conference to set
     */
    public void setDate(String date) {
        this.date = date;
    }
}