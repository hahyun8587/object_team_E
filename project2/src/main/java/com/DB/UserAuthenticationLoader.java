package com.DB;

import java.util.ArrayList;
import java.util.Arrays;
import com.util.UserAuthentication;

/**
 * Class that loads <code>UserAuthentication</code> object. 
 * This class is applied template design pattern.
 */
public class UserAuthenticationLoader extends Loader {
    @Override
    protected Object initObj(ArrayList<Object>[] arr, Object arg) {
        ArrayList<String> ids = new ArrayList<String>(Arrays.asList((String[]) arr[0].toArray()));
        ArrayList<String> pws = new ArrayList<String>(Arrays.asList((String[]) arr[1].toArray()));
                
        return new UserAuthentication(ids, pws);
    }
}