package com.DB;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Array;
import java.sql.SQLException;
import com.DB.UserAuthentication;

public class DAO {
    private static DAO dao = null;
    private LoadMethod
    private Connection conn;
    private PreparedStatement pstmt;
    private String driver;
    private String url;
    private String id;
    private String pw;

    private DAO(String _driver, String _url, String _id, String _pw) {
        driver = _driver;
        url = _url;
        id = _id;
        pw = _pw;
        
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
        try {
            ResultSet rs = pstmt.executeQuery(sql);
            
        
    }
    
}



