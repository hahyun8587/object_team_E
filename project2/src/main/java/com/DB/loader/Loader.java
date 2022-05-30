package com.DB.loader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Abstract class that loads specific object from database.
 * This class is applied template design pattern.
 */
public abstract class Loader {  
    protected String sql;

    /**
     * Template method that loads specific object from database.
     * 
     * @param pstmt the <code>PreparedStatement</code> object that linked with database
     * @throws SQLException 
     * @return specific object
     */
    public Object load(Connection conn) throws SQLException {
        PreparedStatement pstmt;
        ResultSet rs; 
        Object obj; 

        pstmt = conn.prepareStatement(sql);
        
        prepare(pstmt);
        
        rs = pstmt.executeQuery();
        obj = initObj(rs);

        rs.close();
        pstmt.close();

        return obj;
    }

    /**
     * Prepares a statement for executing query.
     * @param pstmt <code>PreparedStatement</code> object
     * @throws SQLException
     */
    protected abstract void prepare(PreparedStatement pstmt) throws SQLException;

    /**
     * Primitive method that initializes specific object.
     * @param rs a <code>ResultSet</code> object that loaded from database
     * @throws SQLException
     * @return specific object
     */
    protected abstract Object initObj(ResultSet rs) throws SQLException;  
    
}
