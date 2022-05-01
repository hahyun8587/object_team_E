package com.DB;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;
import com.std.User;
import com.std.TeamLeader;
import com.util.GlobalVariables;

public class TeamLeaderLoader extends Loader {
    @Override
    protected Object initObj(ArrayList<Object>[] arr) {
        try {
            DAO dao = DAO.getDAO(GlobalVariables.DRIVER, GlobalVariables.URL, GlobalVariables.ID, GlobalVariables.PASSWORD);
            
            dao.setLoader(new UserListLoader());
            
            return new TeamLeader((String) arr[0].get(0), (String) arr[1].get(0), (ArrayList<User>) dao.loadData(GlobalVariables.USERLIST_QUERY)); 
        } catch(ClassCastException e) {
            e.printStackTrace();
        } catch(PatternSyntaxException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }
}
