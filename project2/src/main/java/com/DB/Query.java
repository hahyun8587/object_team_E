package com.DB;

import com.record.Recorded;

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
     * Gets query for inserting certain record.
     * @param recorded a <code>Recorded</code> object to insert
     * @return query for inserting
     */
    public static String getInsertQuery(Recorded recorded) {       
        return "INSERT INTO " + recorded + "(id, name) VALUES (" + recorded.getParticipant().getId() + ", " + recorded.getRecord().getName() + ")";
    }

    public void getModifyQuery(Recorded recorded) {
        /*implement*/
    }
}