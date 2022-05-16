package com.DB.loader;

import java.util.ArrayList;
import java.sql.ResultSet;

import com.std.User;

import java.sql.SQLException;

/**
 * Class that loads arraylist of users.
 * This class is applied template design pattern. 
 */
public class UserListLoader extends Loader {
    /**
     * Constructs a <code>UserListLoader</code> object.
     */
    public UserListLoader() {
        name = "UserListLoader";
    }

    @Override
    protected Object initObj(ResultSet rs) throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
        
        while(rs.next()) 
            users.add(new User(rs.getString("id"), rs.getString("password"), rs.getString("name")));
            
        return users;
    }
}
