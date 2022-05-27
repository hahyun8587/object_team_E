package com.DB.loader;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.std.TeamLeader;

public class TeamLeaderLoader extends Loader { 
    /**
     * Constructs <code>TeamLeaderLoader with <code>users</code>. 
     */
    public TeamLeaderLoader() {
        name = "TeamLeaderLoader";
    }
    
    @Override
    protected Object initObj(ResultSet rs) throws SQLException{   
        rs.next();
        
        return new TeamLeader(rs.getString("role"), rs.getString("dept")); 
    }
}
