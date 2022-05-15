package com.DB;

import java.sql.PreparedStatement;
import com.util.Observer;
import com.record.RecordManager;
import com.util.GlobalVariables;

import java.sql.SQLException;

/**
 * Class that saves database changes.
 * This class is applied observer pattern.
 */
public abstract class Saver implements Observer {
    private PreparedStatement pstmt;

    /**
     * Constructs a <code>Saver</code> object.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Saver() throws ClassNotFoundException, SQLException {
        pstmt = DAO.getDAO(GlobalVariables.DRIVER, GlobalVariables.URL, GlobalVariables.ID, GlobalVariables.PASSWORD).getPstmt(); 
    }

    /**
     * Saves database changes by using <code>sql</code>.
     * @param pstmt a <code>PreparedStatement</code> object
     * @param sql a sql query to execute
     * @throws SQLException
     */
    public void save(PreparedStatement pstmt, String sql) throws SQLException {
        pstmt.executeUpdate(sql);
    }

    public abstract void update(RecordManager rm);    
}
