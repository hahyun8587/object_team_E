package com.util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that authenticate an user.
 */
public class UserAuthentication {
    private ArrayList<String> ids;
    private ArrayList<String> pws;

    /**
     * Constructs a <code>UserAuthentication</code> with <code>ids</code> and <code>pws</code>.
     * @param ids ids of all of the users
     * @param pws passwords of all of the users
     */
    public UserAuthentication(ArrayList<String> ids, ArrayList<String> pws) {
        this.ids = ids;
        this.pws = pws;
    }

    /**
     * Authenticate an user with ids and passwords.
     * @param id id of user 
     * @param pw password of user
     * @return true if given id and password is correct, otherwise, false
     */
    public boolean authenticate(String id, String pw) {
        Iterator iit = ids.iterator();
        Iterator pit = pws.iterator();

        while(iit.hasNext()) {
            if(id.equals(iit.next()) && pw.equals(pit.next()))
                return true;
        }
        return false;
    }  
}
