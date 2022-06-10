package com.DB.loader;

import java.util.ArrayList;
import java.sql.ResultSet;
import com.std.User;
import com.util.GlobalVariables;
import com.record.records.Conference;
import com.record.records.Conferenced;
import com.record.records.Record;
import com.record.records.Recorded;

import java.sql.SQLException;

/**
 * Class that loads array list of <code>ConferenceManager</code> object.
 * This class is applied template design pattern.
 */
public class ConferencedListLoader extends RecordedListLoader {
    
    /**
     * Constructs <code>ConferenceManagerListLoader</code> object with <code>users</code>.
     * @param users array list of user
     */
    public ConferencedListLoader(ArrayList<User> users) {
        super(users);
        
        sql = GlobalVariables.CONFERENCED_LIST_QUERY;
    }

    @Override
    protected Record getRecord(ResultSet rs) throws SQLException {
        return new Conference(rs.getString("name"), rs.getString("date"));
    }

    @Override
    protected Recorded initRecorded(ResultSet rs, User participant, Record record) {
        return new Conferenced(participant, (Conference) record);
    }
}
