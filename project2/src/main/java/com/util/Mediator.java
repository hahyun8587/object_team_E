package com.util;

import java.util.ArrayList;

import com.record.records.Record;

import java.sql.SQLException;

/**
 * Interface of mediator.
 * This interface is applied mediator design pattern.
 */
public interface Mediator {
    /**
     * Adds a specific recorded to a specific record manager whose users' id is <code>id</code>.
     * @param id an id of user who owns a specific record manager to which add a specific recorded    
     * @param args arguments used to initialize a specific recorded
     * @param i an index that indicates a type of the recorded 
     * @return 0 if registeration succeeds, otherwise, -1
     * @throws SQLException
     */
    public abstract int sendRegisteration(String id, String[] args, int i) throws SQLException;

    /**
     * Removes a specific recorded to a specific record manager whose users' id is <code>id</code>.
     * @param id an id of user who owns a specific record manager from which remove a specific recorded  
     * @param i an index that indicates a type of the recorded
     * @param j an index of the recorded to remove
     * @return 0 if deletion succeeds, otherwise, -1
     * @throws SQLException
     */
    public abstract int sendDeletion(String id, int i, int j) throws SQLException;

    /**
     * Merges all of the specific recordeds of all of the users.
     * Duplicates are removed.
     * @param i an index that indicates a type of recorded
     * @return array list of merged specific recorded
     */
    public abstract ArrayList<Record> sendAllList(int i);
}
