package com.DB;

import java.util.ArrayList;
import com.std.User;
import com.util.UserAuthentication;

/**
 * Class that loads <code>UserAuthentication</code> object. 
 * This class is applied template design pattern.
 */
public class UserAuthenticationLoader extends Loader {
    @Override
    protected Object initObj(ArrayList<Object>[] arr) {            
        return new UserAuthentication((ArrayList<User>) new UserListLoader().initObj(arr));
    }
}