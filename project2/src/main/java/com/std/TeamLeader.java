package com.std;

import java.util.ArrayList;

public class TeamLeader extends FullTime {
    private ArrayList<User> users;
    
    public TeamLeader(String role, String dept, ArrayList<User> users) {
        super(role, dept);
        this.users = users;
    }

    public void modifyRecord() {
        /*implement*/
    }   

    public void registerRecord() {
        /*implement*/
    }

    /**
     * Deletes ith record.
     * @param i an index of record to delete
     */
    public void deleteRecord(int i) {
        rm.delete(i);
    }

    public void manageUser() {
        /*implement*/
    }
}
