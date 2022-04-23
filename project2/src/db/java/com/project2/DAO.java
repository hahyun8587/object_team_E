package com.project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
    private static DAO dao = null;
    private static String driver;
    private static String url;
    private static String id;
    private static String pw;

    private DAO(String _driver, String _url, String _id, String _pw) {
        driver = _driver;
        url = _url;
        id = _id;
        pw = _pw;
    }      

    public static synchronized DAO getDAO(String driver, String url, String id, String pw) {   
        if(dao == null)
           dao = new DAO(driver, url, id, pw);
        
        return dao;    
    }

    
}