package com.display.page;

import javax.swing.JFrame;
import java.awt.Color;

import com.std.User;

public abstract class FramePage extends JFrame implements Displayable {
    protected User user;
    
    public FramePage() {}
    
    public FramePage(User user, Color color) {
        setBackground(color);  
        
        this.user = user;
    }
}
