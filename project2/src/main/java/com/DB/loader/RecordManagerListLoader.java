package com.DB.loader;

import java.util.ArrayList;
import java.sql.ResultSet;
import com.std.User;
import com.record.Record;
import com.record.RecordManager;

import java.sql.SQLException;

/**
 * Abstract class that loads array list of <code>RecordManager</code> object.
 * This class is applied template design pattern.
 */
public abstract class RecordManagerListLoader extends Loader {
    private ArrayList<User> users;
    
    /**
     * Constructs <code>RecordManagerListLoader</code> object with <code>users</code>.
     * @param users array list of user
     */
    public RecordManagerListLoader(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    protected Object initObj(ResultSet rs) throws SQLException {
        ArrayList<RecordManager> managers = new ArrayList<RecordManager>();
        int n = users.size();
        Record record;

        rs.next();

        record = getRecord(rs);
        
        for(int i = 1; i <= n; i++) 
            managers.add(getRecordManager());

        do {
            User user;
            RecordManager rm;
            String id;
            int i;
            
            id = rs.getString("id");
            
            for(i = 0; i < n; i++) {
                if(users.get(i).getId().equals(id))
                    break;
            }
            user = users.get(i);
            rm = managers.get(i);

            if(!record.getName().equals(rs.getString("name"))) 
                record = getRecord(rs);
            
            initRecorded(rs, user, record, rm);    
        } while(rs.next());
        
        return managers;
    }

    /**
     * Returns current specific record from a <code>ResultSet</code> object.
     * @param rs an <code>ResultSet</code> whose cusor points right row
     * @throws SQLException
     * @return current specific record 
     */
    protected abstract Record getRecord(ResultSet rs) throws SQLException;
    
    /**
     * Returns a specific record manager.
     * @return a specific record manager 
     */
    protected abstract RecordManager getRecordManager();

    /**
     * Initializes specific recorded with <code>rs</code>, <code>participant</code>, <code>record</code>, and <code>rm</code>.
     * @param rs a <coode>ResultSet</code> object whose cursor points right row
     * @param participant a participant that participates a record
     * @param record the record that recorded represents 
     * @param rm a record manager that manages the specific recorded 
     * @throws SQLException
     */
    protected abstract void initRecorded(ResultSet rs, User participant, Record record, RecordManager rm) throws SQLException;
}
