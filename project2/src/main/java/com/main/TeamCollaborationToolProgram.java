package com.main;

import java.util.ArrayList;

import com.DB.*;
import com.DB.loader.*;
import com.record.manager.RecordManager;
import com.std.*;
import com.util.*;

import java.sql.SQLException;

/**
 * Class that represents team collaboration tool program.
 * This class is applied facade design pattern.
 */
public class TeamCollaborationToolProgram {
    UserAuthentication ua;

    public void ready() {
        try {
            DAO dao;
            ArrayList<User> users;
            Mediator mediator;
            ArrayList<RecordManager>[] managers;
            
            dao = DAO.getDAO(GlobalVariables.DRIVER, GlobalVariables.URL, GlobalVariables.ID, GlobalVariables.PASSWORD);
            
            dao.setLoader(new UserListLoader());
           
            users = (ArrayList<User>) dao.loadInstance();
            
            RecordedListLoader[] loaders = { new ConferencedListLoader(users), new AssignedListLoader(users), new ScheduledListLoader(users) };
            
            managers = new ArrayList[RecordType.values().length];

            





        
        
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }



    }

    public void start() {
        /*implement*/
    }

    public void terminate() {
        /*implement*/
    }
}
