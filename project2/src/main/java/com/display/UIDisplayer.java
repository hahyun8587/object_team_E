package com.display;

import java.util.LinkedList;

import com.display.page.loginpage.LoginPage;
import com.std.User;
import com.util.UserAuthentication;

/**
 * Class that displays a page.
 */
public class UIDisplayer {
    private LinkedList<FramePage> curr;
    private FrameDialog dialog;
    private User user;

    public UIDisplayer(UserAuthentication ua) {
        curr = new LinkedList<>();
        curr.add(new LoginPage(this, ua));
    }

    public void displayCurrentPage() {
        curr.getFirst().display();
    }

    public void hideCurrentPage() {
        curr.getFirst().setVisible(false);
    }

    public void disposeCurrentPage() {
        curr.removeFirst().dispose();
    }

    public void displayDialog() {
        dialog.display();
    }

    public void disposeDialog() {
        dialog.dispose();
    }

    public FramePage getCurrentPage() {
        return curr.getFirst();
    }

    public User getUser() {
        return user;
    }

    public void setCurrentPage(FramePage page) {
        curr.addFirst(page);
    }

    public void setDialog(FrameDialog dialog) {
        this.dialog = dialog;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
