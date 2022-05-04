package com.DB;

import java.util.ArrayList;
import java.util.Iterator;
import com.std.User;
import com.record.JobManager;
import com.record.Job;

/**
 * Class that loads arraylist of job managers.
 * This class is applied template design pattern. 
 */
/*
public class JobManagerListLoader extends Loader {
    ArrayList<User> users;

    public JobManagerListLoader(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    protected Object initObj(ArrayList<Object>[] arr) {
        Iterator<User> it = users.iterator();
        ArrayList<JobManager> managers = new ArrayList<JobManager>();
        Job job = new Job((String) arr[1].get(0), (String) arr[2].get(0), (int) arr[3].get(0), (int) arr[4].get(0));

        

    }   
}
*/