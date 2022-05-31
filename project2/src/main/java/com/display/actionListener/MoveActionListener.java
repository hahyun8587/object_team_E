package com.display.actionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.display.page.FramePage;

public class MoveActionListener implements ActionListener {
    private FramePage to, from;

    public MoveActionListener(FramePage to, FramePage from) {
       this.to = to;
       this.from = from;
    }

    public void actionPerformed(ActionEvent e) {
        from.setVisible(false);
        to.display();
    }
}
