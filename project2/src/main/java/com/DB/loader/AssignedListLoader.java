package com.DB.loader;

import java.util.ArrayList;
import java.sql.ResultSet;
import com.std.User;
import com.util.GlobalVariables;
import com.record.records.Assigned;
import com.record.records.Job;
import com.record.records.Record;
import com.record.records.Recorded;

import java.sql.SQLException;

/**
 * Class that loads arraylist of <code>JobManager</code> object.
 * This class is applied template design pattern. 
 */
public class AssignedListLoader extends RecordedListLoader {

    /**
     * Constructs <code>JobManagerListLoader</code> with <code>users</code>.
     * @param users array list of user
     */
    public AssignedListLoader(ArrayList<User> users) {
        super(users);
    
        sql = GlobalVariables.ASSIGNED_LIST_QUERY;
    }

    @Override
    protected Record getRecord(ResultSet rs) throws SQLException {
        return new Job(rs.getString("name"), rs.getString("due_date"), rs.getInt("progress"), rs.getInt("priority"));
    }

    @Override
    protected Recorded initRecorded(ResultSet rs, User participant, Record record) {
        return new Assigned(participant, (Job) record);    
    }  
}
