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
     * @param sql a sql query to execute
     * @throws SQLException 
     * @throws PatternSyntaxException
     * @return specific object
     */
    public Object load(PreparedStatement pstmt, String sql) throws SQLException, PatternSyntaxException {
        ArrayList<Object>[] arr;
        ResultSet rs = null;
        Object obj = null;

        arr = new ArrayList[numCol(sql)];

        for(int i = 0; i < arr.length; i++)
            arr[i] = new ArrayList<Object>();

        rs = pstmt.executeQuery(sql);
           
        while(rs.next()) {
            for(int i = 0; i < arr.length; i++)
                arr[i].add(rs.getObject(i + 1));
        }
        rs.close();
      
        obj = initObj(arr);

        return obj;
    }

    /**
     * Primitive method that initializes specific object.
     * @param arr array of arraylist of data that loaded from database
     * @return specific object
     */
    protected abstract Object initObj(ArrayList<Object>[] arr);   
    
    /**
     * Returns the number of columns of the table that query returns.
     * @param sql a sql qeury to execute
     * @throws PatternSyntaxException
     * @return the number of columns of the table that the query returns 
     */
    private int numCol(String sql) throws PatternSyntaxException {
        String[] strs;
        int i;
        int count = 0;

        strs = sql.toLowerCase().replaceAll(",", " ").split(" ");

        for(i = 0; !strs[i].equals("select"); i++);
        
        for(i = i + 1; !strs[i].equals("from"); i++) {

            if(strs[i].equals("as"))
                i++;
            else if(!strs[i].equals("as") && !strs[i].isBlank()) 
                count++;
        }
        return count;
    }
}
