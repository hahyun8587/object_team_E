package com.DB.loader;

import java.util.ArrayList;
import java.sql.ResultSet;
import com.std.User;
import com.record.records.Record;
import com.record.records.Recorded;

import java.sql.SQLException;

/**
 * Abstract class that loads array list of <code>RecordManager</code> object.
 * This class is applied template design pattern.
 */
public abstract class RecordedListLoader extends Loader {
    private ArrayList<User> users;
    
    /**
     * Constructs <code>RecordManagerListLoader</code> object with <code>users</code>.
     * @param users array list of user
     */
    public RecordedListLoader(ArrayList<User> users) {
        this.users = users;
        name = "RecordedListLoader";
    }

    @Override
    protected Object initObj(ResultSet rs) throws SQLException {
        int n = users.size();
        ArrayList<Recorded>[] recordeds = new ArrayList[n];
        Record record;

        rs.next();

        record = getRecord(rs);
        
        for(int i = 0; i < n; i++) 
            recordeds[i] = new ArrayList<Recorded>();

        do {
            User user;
            String id;
            int i;
            
            id = rs.getString("id");
            
            for(i = 0; i < n; i++) {
                if(users.get(i).getId().equals(id))
                    break;
            }
            user = users.get(i);

            if(!record.getName().equals(rs.getString("name"))) 
                record = getRecord(rs);
            
            recordeds[i].add(initRecorded(rs, user, record));    
        } while(rs.next());
        
        return recordeds;
    }

    /**
     * Returns current specific record from a <code>ResultSet</code> object.
     * @param rs an <code>ResultSet</code> whose cusor points right row
     * @throws SQLException
     * @return current specific record 
     */
    protected abstract Record getRecord(ResultSet rs) throws SQLException;

    /**
     * Initializes and returns specific recorded with <code>rs</code>, <code>participant</code>, and <code>record</code>.
     * @param rs a <coode>ResultSet</code> object whose cursor points right row
     * @param participant a participant that participates a record
     * @param record the record that recorded represents 
     * @throws SQLException
     * @retrun the initialized specific recorded 
     */
    protected abstract Recorded initRecorded(ResultSet rs, User participant, Record record) throws SQLException;
}
