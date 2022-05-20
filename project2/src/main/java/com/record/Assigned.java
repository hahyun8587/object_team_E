package com.record;

import com.std.User;

/**
 * Association class that connects <code>User</code> and <code>Job</code>.
 * This class represents a job of single participant. 
 */
public class Assigned extends Recorded {
    /**
     * Constructs <code>Assigned</code> object with <code>participant</code>, <code>job</code>, and <code>jm</code>.
     * Constructed <code>Assigned</code> object is added to <code>Job</code> object and <code>JobManager</code> object that the constructor got.
     * @param participant participant of the job 
     * @param job the job that <code>Assigned</code> object represents 
     * @param jm job manager that manages the <code>Assigned</code> object
     */
    public Assigned(User participant, Job job) {
        super(participant, job);
    }     

    @Override
    public String toString() {
        return "job";
    }
}