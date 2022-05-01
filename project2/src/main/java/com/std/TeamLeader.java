package com.std;

import java.util.ArrayList;

public class TeamLeader extends FullTime {
    private ArrayList<User> users;
    
    public TeamLeader(String role, String department, ArrayList<User> users) {
        super(role, department);
        this.users = users;
    }

    public void modifyRecord() {
        /*implement*/
    }   

    public void registerRecord() {
        /*implement*/
    }

    public void deleteRecord() {
        /*implement*/
    }

    public void manageUser() {
        /*implement*/
    }
}
