package com.DB;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.std.User;
import com.std.TeamLeader;

public class TeamLeaderLoader extends Loader {
    private ArrayList<User> users;
    
    /**
     * Constructs <code>TeamLeaderLoader with <code>users</code>.
     * @param users array list of user 
     */
    public TeamLeaderLoader(ArrayList<User> users) {
        this.users = users;
    }
    
    @Override
    protected Object initObj(ResultSet rs) throws SQLException{   
        rs.next();
        
        return new TeamLeader(rs.getString("role"), rs.getString("dept"), users); 
    }
}
