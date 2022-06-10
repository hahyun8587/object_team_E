package com.util;

/**
 * Class that contains global variables.
 */
public class GlobalVariables {

    /*Database informations*/
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:9991/world?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    public static final String ID = "scott";
    public static final String PASSWORD = "oraCLE!(c";
    
    /*Queries*/
    public static final String USER_LIST_QUERY = "SELECT id, password, name, _rank FROM user";
    public static final String PARTTIME_QUERY = "SELECT role from employee where id = ?";
    public static final String FULLTIME_QUERY = "SELECT role, dept from employee where id = ?";
    public static final String SCHEDULED_LIST_QUERY = "SELECT id, name, date, alarm FROM schedule ORDER BY name"; 
    public static final String CONFERENCED_LIST_QUERY = "SELECT id, name, date FROM conference ORDER BY name";
    public static final String ASSIGNED_LIST_QUERY = "SELECT id, name, due_date, progress, priority FROM job ORDER BY name";
        
    public static final String[] RECORDED_LIST_QUERY = { CONFERENCED_LIST_QUERY, ASSIGNED_LIST_QUERY, SCHEDULED_LIST_QUERY };
} 
