package com.DB;

import java.sql.PreparedStatement;

import java.sql.SQLException;

/**
 * Class that saves data to database.
 */
public class Saver {
    /**
     * Saves data to a database using query.
     * @param pstmt a <code>PreparedStatement</code> object that connected to a database
     * @param sql a sql query to execute
     * @throws SQLException
     */
    public static void save(PreparedStatement pstmt, String sql) throws SQLException {
        pstmt.executeUpdate(sql);
    } 
}
