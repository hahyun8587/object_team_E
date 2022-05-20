package com.DB.loader;

import java.util.ArrayList;
import java.sql.ResultSet;
import com.std.User;
import com.record.Record;
import com.record.Recorded;
import com.record.Schedule;
import com.record.Scheduled;

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

