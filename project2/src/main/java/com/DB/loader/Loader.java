package com.DB.loader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Abstract class that loads specific object from database.
 * This class is applied template design pattern.
 */
public abstract class Loader {  
    protected String name;

    /**
     * Template method that loads specific object from database.
     * 
     * @param pstmt the <code>PreparedStatement</code> object that linked with database
     * @param sql a sql query to execute
     * @throws SQLException 
     * @return specific object
     */
    public Object load(PreparedStatement pstmt, String sql) throws SQLException {
        ResultSet rs = pstmt.executeQuery(sql);
        Object obj = initObj(rs);

        rs.close();

        return obj;
    }

    /**
     * Primitive method that initializes specific object.
     * @param rs a <code>ResultSet</code> object that loaded from database
     * @throws SQLException
     * @return specific object
     */
    protected abstract Object initObj(ResultSet rs) throws SQLException;   
}
