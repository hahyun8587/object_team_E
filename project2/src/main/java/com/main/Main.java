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
            LoginPage l;
            String[] data;

            dao = DAO.getDAO(GlobalVariables.DRIVER, GlobalVariables.URL,GlobalVariables.ID, GlobalVariables.PASSWORD);

            dao.setLoader(new UserAuthenticationLoader());
            
            ua = (UserAuthentication) dao.loadInstance(GlobalVariables.USERLIST_QUERY);
            ud = new UIDisplayer();
            ud.setPage(l = new LoginPage());
            ud.displayPage();

            while((data = l.getData()) == null)
                
            Thread.sleep(1000);    
            
            if((user = ua.authenticate(data[0], data[1])) != null)
                System.out.println("Login Success");
            else 
                System.out.println("Login fail");
            
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(PatternSyntaxException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            e.printStackTrace();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }       
    }
}
