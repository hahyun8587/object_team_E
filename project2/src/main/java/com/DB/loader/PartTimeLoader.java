package com.DB.loader;

import java.sql.ResultSet;

import com.std.PartTime;
import com.util.GlobalVariables;

import java.sql.SQLException;

/**
 * Class that loads <code>PartTime</code> object.
 */
public class PartTimeLoader extends RankLoader {
    /**
     * Constructs a <code>PartTimeLoader</code> object.
     */
    public PartTimeLoader(String id) {
        super(id);
        
        sql = GlobalVariables.PARTTIME_QUERY;
    }
    
    @Override
    protected Object initObj(ResultSet rs) throws SQLException {
        rs.next();

        return new PartTime(rs.getString("role"));
    }   
}