package com.DB.loader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

/**
 * Abstract class that loads a specific rank.
 * This class is applied factory method design pattern. 
 */
public abstract class RankLoader extends Loader {
    private String id;

    @Override
    protected void prepare(PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, id);
    }
}
