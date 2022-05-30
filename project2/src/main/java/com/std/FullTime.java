package com.std;

import java.sql.SQLException;

public abstract class FullTime extends Rank {
    private String dept;

    /**
     * Constructs <code>FullTime</code> object with <code>role</code> and <code>dept</code>. 
     * @param role a role of this user
     * @param dept a department of the user
     */
    public FullTime(String role, String dept) {
        super(role);
        
        this.dept = dept;
    }

    /**
     * Registers a specific record to its specific record manager. 
     * @param args arguments used to initialize a specific recorded
     * @throws SQLException 
     */
    public void registerRecord(String[] args) throws SQLException {
        manager.register(args); 
    }

    /**
     * Deletes ith record.
     * @param i an index of record to delete
     * @throws SQLException
     */
    public void deleteRecord(int i) throws SQLException {   
        manager.delete(i);
    }

    public void reserveAlarm() {
        /*implement*/
    }
}
