package com.DB.loader;

import java.sql.ResultSet;

import com.std.Staff;

import java.sql.SQLException;

/**
 * Class that loads <code>Staff</code> object.
 */
public class StaffLoader extends Loader {
    @Override
    protected Object initObj(ResultSet rs) throws SQLException{
        rs.next();

        return new Staff(rs.getString("role"), rs.getString("dept"));
    }
}
 