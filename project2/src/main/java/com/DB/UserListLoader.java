package com.DB;

import java.util.ArrayList;
import com.std.User;

/**
 * Class that loads arraylist of users.
 * This class is applied template design pattern. 
 */
public class UserListLoader extends Loader {
    @Override
    protected Object initObj(ArrayList<Object>[] arr) {
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Object>[] data = new ArrayList[arr.length];
        UserLoader ul = new UserLoader();
        int n = arr[0].size();

        for(int i = 0; i < arr.length; i++) 
            data[i] = new ArrayList<Object>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < arr.length; j++) 
                data[j].add(arr[j].get(i));
            
            users.add((User) ul.initObj(data));
            
            for(int j = 0; j < arr.length; j++) 
                data[j].remove(0);
        }
        return users;
    }
}
