package com.std;

import com.record.RecordManager;

/**
 * Class that represents rank of user.
 */
public class Rank {
    private String role;
    private RecordManager rm;

    /**
     * Constructs a <code>Rank</code> object with <code>role</code> and <code>rm</code>.
     * @param role a role of this rank
     * @param rm a record manager 
     */
    public Rank(String role) {
        this.role = role;
    }

    public void chat() {
        /*implement*/
    }

    public void viewRecord() {
        /*implement*/
    }

    public void checkJob() {
        /*implement*/
    }
}
