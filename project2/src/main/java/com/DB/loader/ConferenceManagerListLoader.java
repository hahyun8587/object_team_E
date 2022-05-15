package com.DB.loader;

import java.util.ArrayList;
import java.sql.ResultSet;
import com.std.User;
import com.record.Record;
import com.record.RecordManager;
import com.record.Conference;
import com.record.ConferenceManager;
import com.record.Conferenced;

import java.sql.SQLException;

/**
 * Class that loads array list of <code>ConferenceManager</code> object.
 * This class is applied template design pattern.
 */
public class ConferenceManagerListLoader extends RecordManagerListLoader {
    /**
     * Constructs <code>ConferenceManagerListLoader</code> object with <code>users</code>.
     * @param users array list of user
     */
    public ConferenceManagerListLoader(ArrayList<User> users) {
        super(users);
    }

    @Override
    protected Record getRecord(ResultSet rs) throws SQLException {
        return new Conference(rs.getString("name"));
    }

    @Override
    protected RecordManager getRecordManager() {
        return new ConferenceManager();
    }

    @Override
    protected void initRecorded(ResultSet rs, User participant, Record record, RecordManager rm) {
        new Conferenced(participant, (Conference) record, (ConferenceManager) rm);
    }
}
