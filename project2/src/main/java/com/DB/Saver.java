package com.DB;

import java.sql.Connection;

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
    public void save(Connection conn, String sql) throws SQLException {
        conn.prepareStatement(sql).executeUpdate();
    } 
}
