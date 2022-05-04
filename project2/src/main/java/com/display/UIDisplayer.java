package com.display;

/**
 * Class that displays a page.
 */
public class UIDisplayer {
    private Displayable page;

    public void displayPage() {
        page.display();
    }

    public void setPage(Displayable page) {
        this.page = page;
    }

    public void getData() {
        
    }
}
