package com.DB;

import java.util.ArrayList;

import com.std.User; 
import com.record.RecordManager;

/**
 * Class that contains data of
 */
public class Data {
    private ArrayList<User> users;
    private ArrayList<RecordManager> managers;

    public Data(ArrayList<User> users, ArrayList<RecordManager> managers) {
        this.users = users;
        this. managers = managers;
    }
}
