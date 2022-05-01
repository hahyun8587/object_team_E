package com.DB;

import java.util.ArrayList;
import com.std.User;

/**
 * Class that loads <code>User</code> object.
 * This class is applied template design pattern.
 */
public class UserLoader extends Loader {
    @Override
    protected Object initObj(ArrayList<Object>[] arr) {
        return new User((String) arr[0].get(0), (String) arr[1].get(0), (String) arr[2].get(0));
    }
}