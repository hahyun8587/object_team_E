package com.DB.loader;

import java.sql.ResultSet;

import com.std.PartTime;

import java.sql.SQLException;

/**
 * Class that loads <code>PartTime</code> object.
 */
public class PartTimeLoader extends Loader {
    @Override
    protected Object initObj(ResultSet rs) throws SQLException {
        rs.next();

        return new PartTime(rs.getString("role"));
    }   
}