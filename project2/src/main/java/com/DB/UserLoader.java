package com.DB;

import java.util.ArrayList;
import com.std.User;
import com.std.*;

/**
 * Class that loads <code>User</code> object.
 * This class is applied template design pattern.
 */
public class UserLoader extends Loader {
    @Override
    protected Object initObj(ArrayList<Object>[] arr, Object arg) {
        ((User) arg).setId((String) arr[0].get(0));
        ((User) arg).setPw((String) arr[1].get(0));
        ((User) arg).setName((String) arr[2].get(0));

        return arg;
    }
}