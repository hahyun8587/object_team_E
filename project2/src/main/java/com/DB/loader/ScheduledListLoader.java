package com.DB.loader;

import java.util.ArrayList;
import java.sql.ResultSet;
import com.std.User;
import com.util.GlobalVariables;
import com.record.records.Record;
import com.record.records.Recorded;
import com.record.records.Schedule;
import com.record.records.Scheduled;

import java.sql.SQLException;

/**
 * Class that loads arraylist of <code>ScheduleManager</code> object.
 * This class is applied template design pattern. 
 */
public class ScheduledListLoader extends RecordedListLoader {

    /**
     * Constructs <code>ScheduleManagerListLoader</code> object with <code>users</code>.
     * @param users array list of users
     */
    public ScheduledListLoader(ArrayList<User> users) {
        super(users);
        
        name = "ScheduledListLoader";
        sql = GlobalVariables.SCHEDULED_LIST_QUERY;
    }

    @Override
    protected Record getRecord(ResultSet rs) throws SQLException {
        return new Schedule(rs.getString("name"), rs.getString("date"));
    }

    @Override
    protected Recorded initRecorded(ResultSet rs, User participant, Record record) throws SQLException {
        return new Scheduled(participant, (Schedule) record, rs.getString("alarm"));    
    }  
}

