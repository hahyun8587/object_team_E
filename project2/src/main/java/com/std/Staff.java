package com.std;

import com.record.manager.JobManager;

public class Staff extends FullTime {
    /**
     * Constructs <code>Staff</code> object with <code>role</code>, <code>department</code>, and <code>manager</code>.
     * @param role a role of user
     * @param department a department of the user
     * @param manager <code>JobManager</code> object 
     */
    public Staff(String role, String department, JobManager manager) {
        super(role, department);
   
        this.manager = manager;
    }
}