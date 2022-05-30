package com.std;

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
     */
    public void registerRecord(String[] args) {
        manager.register(args); 
    }

    /**
     * Deletes ith record.
     * @param i an index of record to delete
     */
    public void deleteRecord(int i) {   
        manager.delete(i);
    }

    public void reserveAlarm() {
        /*implement*/
    }
}
