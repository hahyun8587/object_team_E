package com.display;

import javax.swing.JFrame;

import com.std.User;

public abstract class FramePage extends JFrame {
    protected UIDisplayer displayer;
    protected User user;

    public FramePage(UIDisplayer displayer, User user) {
        this.displayer = displayer;
        this.user = user;
        //System.out.println(user.getId());

        init();
    }
    
    public FramePage(UIDisplayer displayer) {
        this.displayer = displayer;
        
        init();
    }

    protected abstract void init();

    public void display() {
        setVisible(true);
    }
}
