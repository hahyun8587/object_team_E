package com.DB;

import java.sql.DriverManager;
import java.sql.Connection;

import com.DB.loader.Loader;
import com.record.manager.RecordManager;
import com.util.RecordObserver;
import com.util.UserAuthentication;
import com.util.UserObserver;

import java.sql.SQLException;

/**
 * Data Access Object class that access mysql database.
 * This class is applied singleton design pattern and observer design pattern.
 */
public class DAO implements RecordObserver, UserObserver {
    private static DAO dao = null;
    private Loader loader;
    private Saver saver = new Saver();
    private Connection conn;

    /**
     * Constructs a <code>DAO</code> object with given <code>driver</code>, <code>url</code>, <code>id</code>, <code>pw</code>.
     * @param driver a database driver 
     * @param url a database url
     * @param id an id for database access
     * @param pw an password for database access
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private DAO(String driver, String url, String id, String pw) throws ClassNotFoundException, SQLException {
        Class.forName(driver);

        conn = DriverManager.getConnection(url, id, pw);
    }      

    /**
     * Gives <code>DAO</code> object that access database.
     * @param driver a database driver
     * @param url a database url
     * @param id an id for database access
     * @param pw an password for database access
     * @return a <code>DAO</code> object
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static synchronized DAO getDAO(String driver, String url, String id, String pw) throws ClassNotFoundException, SQLException {   
        if(dao == null)
           dao = new DAO(driver, url, id, pw);
        
        return dao;    
    }

    /**
     * Loads specific object from database by using <code>Loader</code>.
     * @param arg an argument that used for initializing specific object
     * @return specific object
     * @throws SQLException
     */
    public Object loadInstance() throws SQLException {
        return loader.load(conn);
    }

    /**
     * Saves data to a database using query.
     * @param sql a sql query to execute
     * @throws SQLException
     */
    public void saveData(String sql) throws SQLException {
        saver.save(conn, sql);
    }

    @Override
    public void update(RecordManager manager) throws SQLException {
        saver.save(conn, manager.getSql());
    }

    @Override
    public void update(UserAuthentication ua) throws SQLException {
        saver.save(conn, ua.getSql());
    }

    /**
     * Closes all objects used for accessing database.
     * @throws SQLException
     */
    public void close() throws SQLException {
        conn.close();
    }

    public void setLoader(Loader loader) {
        this.loader = loader;
    }
}