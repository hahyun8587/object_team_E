package com.util;

/**
 * Class that contains global variables.
 */
public class GlobalVariables {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:9991/world?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    public static final String ID = "scott";
    public static final String PASSWORD = "oraCLE!(c";
    public static final String USERLIST_QUERY = "SELECT id, password, name, _rank FROM user";
    public static final String PARTTIME_QUERY = "SELECT role from employee where id = ?";
    public static final String FULLTIME_QUERY = "SELECT role, department form employee where id = ?";
}
