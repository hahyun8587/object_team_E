package com.DB.loader;

import java.sql.ResultSet;

import com.std.Staff;
import com.util.GlobalVariables;

import java.sql.SQLException;

/**
 * Class that loads <code>Staff</code> object.
 */
public class StaffLoader extends Loader {
    /**
     * Constructs a <code>StaffLoader</code> object.
     */
    public StaffLoader() {
        name = "StaffLoader";
        sql = GlobalVariables.FULLTIME_QUERY;
    }

    @Override
    protected Object initObj(ResultSet rs) throws SQLException{
        rs.next();

        return new Staff(rs.getString("role"), rs.getString("dept"));
    }
}
 