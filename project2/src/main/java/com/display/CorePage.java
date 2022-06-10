package com.display;

import com.std.User;

public abstract class CorePage extends FramePage {
    
    public CorePage(UIDisplayer displayer, User user) {
        super(displayer, user);
    }

    public User getUser(){
        return user;
    }
}
