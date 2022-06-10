package com.display;

import javax.swing.JDialog;

public abstract class FrameDialog extends JDialog {
    protected UIDisplayer displayer;

    public FrameDialog(UIDisplayer displayer, FramePage owner) {
        super(owner, true);
        
        this.displayer = displayer;        

        init();
    }

    protected abstract void init();

    public void display() {
        setVisible(true);
    }
}
