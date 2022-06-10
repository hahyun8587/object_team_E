package com.display;

import javax.swing.JButton;

public abstract class ComponentMediator {
    protected UIDisplayer displayer;
    private JButton backBtn;

    public ComponentMediator(UIDisplayer displayer) {
        this.displayer = displayer;
    }

    public void back() {
        backward();
    }

    protected void forward(FramePage to) {
        displayer.hideCurrentPage();
        displayer.setCurrentPage(to);
        displayer.displayCurrentPage();
    }

    protected void backward() {
        displayer.disposeCurrentPage();
        displayer.displayCurrentPage();
    }

    protected void branch(FrameDialog dialog) {
        displayer.setDialog(dialog);
        displayer.displayDialog();
    }

    protected void prune() {
        displayer.disposeDialog();
    }

    public void registerBack(JButton backBtn) {
        this.backBtn = backBtn;
    }
}
