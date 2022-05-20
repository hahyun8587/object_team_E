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

    public void registerRecordTo() {
        /*implement*/
    }

    public void deleteRecordFrom() {
        /*implement*/
    }

    public void searchRecord() {
        /*implement*/
    }

    public void manageUser() {
        /*implement*/
    }
}
