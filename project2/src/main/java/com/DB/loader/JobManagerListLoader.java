package com.DB.loader;

import java.util.ArrayList;
import java.sql.ResultSet;
import com.std.User;
import com.record.Record;
import com.record.RecordManager;
import com.record.Job;
import com.record.JobManager;
import com.record.Assigned;

import java.sql.SQLException;

/**
 * Class that loads arraylist of <code>JobManager</code> object.
 * This class is applied template design pattern. 
 */
public class JobManagerListLoader extends RecordManagerListLoader {

    /**
     * Constructs <code>JobManagerListLoader</code> with <code>users</code>.
     * @param users array list of user
     */
    public JobManagerListLoader(ArrayList<User> users) {
        super(users);
        name = "JobManagerListLoader";
    }

    @Override
    protected Record getRecord(ResultSet rs) throws SQLException {
        return new Job(rs.getString("name"), rs.getString("due_date"), rs.getInt("progress"), rs.getInt("priority"));
    }

    @Override
    protected RecordManager getRecordManager() {
        return new JobManager();
    }

    @Override
    protected void initRecorded(ResultSet rs, User participant, Record record, RecordManager rm) {
        new Assigned(participant, (Job) record, (JobManager) rm);    
    }  
}
