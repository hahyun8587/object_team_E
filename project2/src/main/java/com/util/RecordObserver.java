package com.util;

import com.record.manager.RecordManager;

import java.sql.SQLException;

/**
 * Interface of observer that observes records' modification, registeration, and deletion. 
 */
public interface RecordObserver {
    /**
     * Updates whenever this record observer is notified.
     * @param manager a specific record manager that notified this record observer
     * @throws SQLException
     */
    public abstract void update(RecordManager manager) throws SQLException;
}
