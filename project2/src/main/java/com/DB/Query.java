package com.DB;

import com.record.records.Recorded;
import com.record.records.Conference;
import com.record.records.Job;
import com.record.records.Schedule;
import com.record.records.Scheduled;

public class Query {
    /**
     * Gets query for deleting certain record.
     * @param recorded a <code>Recorded</code> object to delete
     * @return query for deleting
     */
    public static String getDeleteQuery(Recorded recorded) {
        return "DELETE FROM " + recorded + " WHERE id = \"" + recorded.getParticipant().getId() + "\" and name = \"" + recorded.getRecord().getName() + "\"";
    }
    
    /**
     * Gets query for inserting values into conference table.
     * @param recorded a specific <code>Recorded</code> object to insert
     * @return query for inserting values into conference table
     */

    public static String getInsertConferenceQuery(Recorded recorded) {
        return "INSERT INTO " + recorded + "(id, name, date) VALUES (\"" + 
                recorded.getParticipant().getId() + "\", \"" + recorded.getRecord().getName() + 
                "\", \"" + ((Conference) recorded.getRecord()).getDate() + "\")";
    }

    /**
     * Gets query for inserting values into job table.
     * @param recorded a specific code>Recorded</code> object to insert
     * @return query for inserting values into job table
     */
    public static String getInsertJobQuery(Recorded recorded) {
        Job job = (Job) recorded.getRecord();        

        return "INSERT INTO " + recorded + "(id, name, due_date, progress, priority) VALUES (\"" + 
                recorded.getParticipant().getId() + "\", \"" + job.getName() + 
                "\", \"" + job.getDueDate() + "\", " + job.getProgress() + ", " + job.getPriority() + ")";
    }

    /**
     * Gets query for inserting values into schedule table.
     * @param recorded a specific <code>Recorded</code> object to insert
     * @return query for inserting values into schedule table
     */
    public static String getInsertScheduleQuery(Recorded recorded) {
        return "INSERT INTO " + recorded + "(id, name, date, alarm) VALUES (\"" + 
                recorded.getParticipant().getId() + "\", \"" + recorded.getRecord().getName() + 
                "\", \"" + ((Schedule) recorded.getRecord()).getDate() + "\", \"" + ((Scheduled) recorded).getAlarm() + "\")";
    }

    public void getModifyQuery(Recorded recorded) {
        /*implement*/
    }
}