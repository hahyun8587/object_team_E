package com.DB;

import java.util.ArrayList;

import com.record.records.Recorded;
import com.std.User;
import com.util.GlobalVariables;

import java.sql.SQLException;

/**
 * Class that operates with data.
 */
public class Data {
    private DAO dao;
    private ArrayList<User> users;
    private ArrayList<ArrayList<Recorded>> recordeds;

    /**
     * Constructs <code>Data</code> object with <code>dao</code>.
     * @param dao <code>DAO</code> object
     */
    public Data(DAO dao) {
        this.dao = dao;
    }

    /**
     * Loads array list of not fully initialized <code>User</code> object.
     * @throws SQLException
     */
    public void loadUsers() throws SQLException {
        users = (ArrayList<User>) dao.loadInstance(GlobalVariables.USER_LIST_QUERY);
    }

    /**
     * Loads array list of array list of recordeds.
     * @throws SQLException
     */
    public void loadRecordeds() throws SQLException {
        recordeds = new ArrayList<ArrayList<Recorded>>();
        
        for(int i = 0; i < GlobalVariables.RECORDED_LIST_QUERY.length; i++)
            recordeds.add((ArrayList<Recorded>) dao.loadInstance(GlobalVariables.RECORDED_LIST_QUERY[i]));
    }

    public void authenticate() {
        /*implement*/
    }
}
