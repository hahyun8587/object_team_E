package com.main;

import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import com.DB.*;
import com.display.*;
import com.std.*;
import com.util.*;

public class Main {
    
    public static void main(String[] args) {
        try {
            DAO dao = DAO.getDAO(GlobalVariables.DRIVER, GlobalVariables.URL,GlobalVariables.ID, GlobalVariables.PASSWORD);
            UserAuthentication ua = (UserAuthentication) dao.loadData(GlobalVariables.USERLIST_QUERY);
            login l = new login();
            User user;
            String[] data = new String[2];
            
            new mainpage();

            l.show();
            data = l.getData();

            if((user = ua.authenticate(data[0], data[1])) != null)
                System.out.println("Login Success");
            else 
                System.out.println("Login fail");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(PatternSyntaxException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
    }
}
