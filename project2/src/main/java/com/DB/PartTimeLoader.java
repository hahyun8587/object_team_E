package com.DB;

import java.util.ArrayList;
import com.std.PartTime;

/**
 * Class that loads <code>PartTime</code> object.
 */
public class PartTimeLoader extends Loader {
    @Override
    protected Object initObj(ArrayList<Object>[] arr) {
        return new PartTime((String) arr[0].get(0));
    }   
}