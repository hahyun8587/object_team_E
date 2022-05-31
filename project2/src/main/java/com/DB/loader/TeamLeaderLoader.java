package com.DB.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.std.TeamLeader;
import com.util.GlobalVariables;

public class TeamLeaderLoader extends RankLoader { 
    /**
     * Constructs <code>TeamLeaderLoader with <code>users</code>. 
     */
    public TeamLeaderLoader(String id) {
        super(id);
        
        sql = GlobalVariables.FULLTIME_QUERY;
    }
    
    @Override
    protected Object initObj(ResultSet rs) throws SQLException{   
        rs.next();
        
        return new TeamLeader(rs.getString("role"), rs.getString("dept")); 
    }
}
