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

    /**
     * Constructs a specific rank loader with <code>id</code>.
     * @param id an id of user
     */
    public RankLoader(String id) {
        this.id = id;
    }

    @Override
    protected void prepare(PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, id);
    }
}
