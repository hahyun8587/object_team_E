package com.main;

import com.DB.*;
import com.display.*;
import com.std.*;
import com.util.*;

import java.lang.NullPointerException;
import java.util.regex.PatternSyntaxException;
import java.sql.SQLException;

public class Main {
    
    public static void main(String[] args) {
        //try {
            //DAO dao = DAO.getDAO(GlobalVariables.DRIVER, GlobalVariables.URL,GlobalVariables.ID, GlobalVariables.PASSWORD);
            //UserAuthentication ua = (UserAuthentication) dao.loadData(GlobalVariables.USERLIST_QUERY);
            //User user;
            UIDisplayer ud;
            LoginPage l;
            String[] data;
        
            ud = new UIDisplayer();
            ud.setPage(l = new LoginPage());
            ud.displayPage();

            while((data = l.getData()) == null)
                System.out.println("");
            
            System.out.println("id: " + data[0]);
            System.out.println("pw: " + data[1]);
            
            /*
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
        */
        
    }
}
