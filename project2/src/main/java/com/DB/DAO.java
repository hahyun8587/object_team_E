package com.DB;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.util.GlobalVariables;

import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

/**
 * Data Access Object class that access mysql database.
 * This class is applied singleton design pattern.
 */
public class DAO {
    private static DAO dao = null;
    private Loader loader;
    private Saver saver;
    private Connection conn;
    private PreparedStatement pstmt;

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
        pstmt = conn.prepareStatement(GlobalVariables.USER_LIST_QUERY);
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
     * @param sql a sql query to execute
     * @param arg an argument that used for initializing specific object
     * @return specific object
     * @throws SQLException
     * @throws PatternSyntaxException
     * @throws NullPointerException
     */
    public Object loadInstance(String sql) throws SQLException, PatternSyntaxException, NullPointerException {
        return loader.load(pstmt, sql);
    }

    public void saveData() {
        /*implement*/
    }

    /**
     * Closes all objects used for accessing database.
     * @throws SQLException
     */
    public void close() throws SQLException {
        conn.close();
        pstmt.close();
    }

    /**
     * Sets loader that loads specific object from database.
     * @param loader
     */
    public void setLoader(Loader loader) {
        this.loader = loader;
    }
}