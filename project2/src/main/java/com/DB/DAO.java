package com.DB;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {
    private static DAO dao = null;
    private Loader loader;
    private Connection conn;
    private PreparedStatement pstmt;

    private DAO(String driver, String url, String id, String pw) {
        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url, id, pw);
            pstmt = conn.prepareStatement(null);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }      

    public static synchronized DAO getDAO(String driver, String url, String id, String pw) {   
        if(dao == null)
           dao = new DAO(driver, url, id, pw);
        
        return dao;    
    }

    public Object loadData(String sql) {
        
    }

    public void setLoader(Loader loader) {
        this.loader = loader;
    }
}



