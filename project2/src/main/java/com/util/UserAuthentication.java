package com.util;

import java.util.ArrayList;
import java.util.Iterator;
import com.std.User;

/**
 * Class that authenticate user.
 */
public class UserAuthentication {
    private ArrayList<User> users;
    
    /**
     * Constructs a <code>UserAuthentication</code> with <code>users</code>
     * @param users arraylist of users
     */
    public UserAuthentication(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * Authenticate user with ids and passwords.
     * @param id id of user 
     * @param pw password of user
     * @return <code>User</code> object if given id and password is correct, otherwise, null
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
}