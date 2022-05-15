package com.DB.saver;

import java.sql.PreparedStatement;

import com.record.RecordManager;

import java.sql.SQLException;

/**
 * Class that execute insertion to database.
 * This class is applied observer pattern.
 */
public abstract class InsertSaver extends Saver {
    public InsertSaver() throws ClassNotFoundException, SQLException {

    }

    @Override
    public abstract void update(RecordManager rm);
}
