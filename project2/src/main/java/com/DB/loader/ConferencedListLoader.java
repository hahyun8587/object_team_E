package com.DB.loader;

import java.util.ArrayList;
import java.sql.ResultSet;
import com.std.User;
import com.record.Record;
import com.record.Recorded;
import com.record.Conference;
import com.record.Conferenced;

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
        name = "ConferencedListLoader";
    }

    @Override
    protected Record getRecord(ResultSet rs) throws SQLException {
        return new Conference(rs.getString("name"));
    }

    @Override
    protected Recorded initRecorded(ResultSet rs, User participant, Record record) {
        return new Conferenced(participant, (Conference) record);
    }
}
