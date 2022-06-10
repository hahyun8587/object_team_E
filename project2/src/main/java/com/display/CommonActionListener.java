package com.display;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CommonActionListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ((Command) e.getSource()).execute();
    }
}
