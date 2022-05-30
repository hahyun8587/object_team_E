package com.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.std.User;

/**
 * Class that authenticates user.
 */
public class UserAuthentication {
    private ArrayList<User> users;
    private UserObserver observer;
    private String sql;

    /**
     * Constructs <code>UserAuthentication</code> object with <code>dao</code>
     * @param DAO
     */
    public UserAuthentication(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * Authenticate user with ids and passwords.
     * @param id id of user 
     * @param pw password of user
     * @return <code>User</code> object if given id and password is correct, otherwise, <code>null</code>
     */
    public User authenticate(String id, String pw) {
        Iterator<User> it = users.iterator();
        
        while(it.hasNext()) {
            User user = it.next();

            if(id.equals(user.getId()) && pw.equals(user.getPw()))
                return user;
        }
        return null;
    }

    public void addUser(User user) {
        /*implement*/
    }

    public void deleteUser(User user){
        /*implement*/
    }

    public void _notify() throws SQLException {
        observer.update(this);
    }

    /**
     * Gets arraylist of user
     * @return arraylist of user
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Gets a sql query for deleting or adding user.
     * @return a sql query for deleting or adding user
     */
    public String getSql() {
        return sql;
    }
}