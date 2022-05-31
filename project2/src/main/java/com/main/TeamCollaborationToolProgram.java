package com.main;

import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.sql.SQLException;

import com.DB.*;
import com.DB.loader.*;
import com.record.manager.*;
import com.record.records.*;
import com.std.*;
import com.util.*;
import com.util.builder.*;
import com.display.page.*;

/**
 * Class that represents team collaboration tool program.
 * This class is applied facade design pattern.
 */
public class TeamCollaborationToolProgram {
    private DAO dao;   
    private UserAuthentication ua;

    /**
     * Constructs <code>TeamCollaborationToolProgram</code> object.
     */
    public TeamCollaborationToolProgram() {
        try {
            dao = DAO.getDAO(GlobalVariables.DRIVER, GlobalVariables.URL, GlobalVariables.ID, GlobalVariables.PASSWORD);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads all of the data from database.
     */
    public void ready() {
        ArrayList<User> users = null;

        try {
            Mediator mediator;
            ArrayList<RecordManager>[] managers;
            Director director;
            String[] bnames = { "ConferenceManagerBuilder", "JobManagerBuilder", "ScheduleManagerBuilder" };
            String bpath = "com.util.builder", lpath = "com.DB.loader";
            int ntype = RecordType.values().length;
            int n;

            dao.setLoader(new UserListLoader());
           
            users = (ArrayList<User>) dao.loadInstance();
            
            RecordedListLoader[] loaders = { new ConferencedListLoader(users), new AssignedListLoader(users), new ScheduledListLoader(users) };
            
            managers = new ArrayList[ntype];
            
            for(int i = 0; i < ntype; i++) 
                managers[i] = new ArrayList<RecordManager>();
        
            mediator = new RecordManagerMediator(managers);
            
            for(int i = 0; i < loaders.length; i++) {
                ArrayList<Recorded>[] recordeds;
                Constructor<?> bconstr;

                dao.setLoader(loaders[i]);

                recordeds = (ArrayList<Recorded>[]) dao.loadInstance();
                bconstr = Class.forName(bpath + "." + bnames[i]).getConstructor(ArrayList.class);

                for(int j = 0; j < recordeds.length; j++) 
                    managers[i].add(new Director((RecordManagerBuilder) bconstr.newInstance(recordeds[j]), mediator).manager4Selector());
            }
            n = users.size();

            for(int i = 0; i < n; i++) {
                Selector selector = new Selector();
                Rank rank;

                for(int j = 0; j < ntype; j++) 
                    selector.addManager(managers[j].get(i));
                
                dao.setLoader((Loader) Class.forName(lpath + "." + users.get(i).getRankName() + "Loader").getConstructor(String.class).newInstance(users.get(i).getId()));
                
                rank = (Rank) dao.loadInstance();

                rank.setSelector(selector);
                users.get(i).setRank(rank);
            } 
        } catch(Exception e) {
            e.printStackTrace();
        }
        ua = new UserAuthentication(users);
    }

    public void start() {
        new LoginPage(ua).display();





    }

    public void terminate() {
        /*implement*/
    }
}
