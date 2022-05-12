package com.std;

import com.util.UserAuthentication;

/**
 * Class that represents user.
 */
public class User {
    private String id;
    private String pw;
    private String name;
    public Rank rank; 

    /**
     * Constructs <code>User</code> object with <code>id</code>, <code>pw</code>, <code>name</code>.
     * @param id id of user
     * @param pw password of user
     * @param name name of user
     */
    public User(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public void signUp() {
        /*implement*/
    }

    /**
     * Gives <code>User</code> object by using <code>id</code> and <code>pw</code>.
     * Gives <code>null</code> if login fails.
     * @param ua <code>UserAuthentication</code> object
     * @param id id of user
     * @param pw password of user
     * @return <code>User</code> object if id and password is correct, otherwise, <code>null</code>
     */
    public static User login(UserAuthentication ua, String id, String pw) {
        return ua.authenticate(id, pw);
    }

    public void logout() {
        /*implement*/
    }

    /**
     * Sets id of <code>User</code> object.
     * @param id id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets password of <code>User</code> object.
     * @param pw password to set
     */
    public void setPw(String pw) {
        this.pw = pw;
    }

    /**
     * Sets name of <code>User</code> object.
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets rank of <code>User</code> object.
     * @param rank rank to set
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }
    
    /**
     * Gets id from <code>User</code> object.
     * @return id of user
     */
    public String getId() {
        return id;
    }

    /**
     * Gets password from <code>User</code> object.
     * @return password of user
     */
    public String getPw() {
        return pw;
    }
}
