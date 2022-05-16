package com.DB.loader;

import java.util.ArrayList;
import java.sql.ResultSet;
import com.std.User;
import com.record.Record;
import com.record.RecordManager;
import com.record.Schedule;
import com.record.ScheduleManager;
import com.record.Scheduled;

import java.sql.SQLException;

/**
 * Class that loads arraylist of <code>ScheduleManager</code> object.
 * This class is applied template design pattern. 
 */
public class ScheduleManagerListLoader extends RecordManagerListLoader {

    /**
     * Constructs <code>ScheduleManagerListLoader</code> object with <code>users</code>.
     * @param users array list of users
     */
    public ScheduleManagerListLoader(ArrayList<User> users) {
        super(users);
        name = "ScheduleManagerListLoader";
    }

    @Override
    protected Record getRecord(ResultSet rs) throws SQLException {
        return new Schedule(rs.getString("name"), rs.getString("date"));
    }

    @Override
    protected RecordManager getRecordManager() {
        return new ScheduleManager();
    }

    @Override
    protected void initRecorded(ResultSet rs, User participant, Record record, RecordManager rm) throws SQLException {
        new Scheduled(participant, (Schedule) record, (ScheduleManager) rm, rs.getString("alarm"));    
    }  
}

