package com.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

/**
 * Abstract class that loads specific object from database.
 * This class is applied template design pattern.
 */
public abstract class Loader {  
    /**
     * Template method that loads specific object from database.
     * 
     * @param pstmt the <code>PreparedStatement</code> object that linked with database
     * @param sql a sql query that executed
     * @param arg an argument that passed for initializing specific object, <code>null</code> if don't need 
     * @throws SQLException 
     * @throws PatternSyntaxException
     * @return specific object
     */
    public Object load(PreparedStatement pstmt, String sql, Object arg) throws SQLException, PatternSyntaxException {
        ArrayList<Object>[] arr;
        ResultSet rs = null;
        Object obj = null;

        arr = new ArrayList[numCol(sql)];

        for(int i = 0; i < arr.length; i++)
            arr[i] = new ArrayList<Object>();

        rs = pstmt.executeQuery(sql);
           
        do {
            for(int i = 0; i < arr.length; i++)
                arr[i].add(rs.getObject(i));
        } while(rs.next()); 
    
        rs.close();
      
        obj = initObj(arr, arg);

        return obj;
    }

    /**
     * Primitive method that initialize specific object.
     * @param rs
     * @param arg an argument that used for initializing specific object
     * @return the specific object
     */
    protected abstract Object initObj(ArrayList<Object>[] arr, Object arg);   

    /**
     * Returns the number of columns of the table that query returns.
     * 
     * @param sql the sql qeury that executed
     * @throws PatternSyntaxException
     * @return the number of columns of the table that the query returns 
     */
    private int numCol(String sql) throws PatternSyntaxException {
        String[] strs;
        int i;
        int count = 0;

        strs = sql.replaceAll(",", " ").split(" ");

        for(i = 0; !strs[i].toLowerCase().equals("select"); i++);
        
        for(i = i + 1; !strs[i].toLowerCase().equals("from"); i++) {
            if(!strs[i].equals("as")) 
                count++;
            else 
                i++;
        }
        return count;
    }
}
