package com.main;

import java.lang.Thread;
import com.DB.*;
import com.display.*;
import com.std.*;
import com.util.*;

import java.util.regex.PatternSyntaxException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DAO dao;  
            UserAuthentication ua;
            User user;
            UIDisplayer ud;
            LoginPage lp;
            String[] data;

            dao = DAO.getDAO(GlobalVariables.DRIVER, GlobalVariables.URL,GlobalVariables.ID, GlobalVariables.PASSWORD);

            dao.setLoader(new UserAuthenticationLoader());
            
            ua = (UserAuthentication) dao.loadInstance(GlobalVariables.USERLIST_QUERY);
            ud = new UIDisplayer();
            ud.setPage(lp = new LoginPage());
        
            do {
                ud.displayPage();

                while((data = lp.getData()) == null)
                    System.out.print("");
                
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }    
            } while((user = ua.authenticate(data[0], data[1])) == null);

            System.out.println("login succes");

            ud.setPage(new MainPage());
            ud.displayPage();

            dao.close();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(PatternSyntaxException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            e.printStackTrace();
        }       
    }
}
