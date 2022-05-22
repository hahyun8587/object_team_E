package com.display;

import com.display.page.Displayable;

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

    /*
    public String[] getData() {
        
    }
    */
    
    public void setFont() {
        /*implement*/
    }

    public void setBackground() {
        /*implement*/
    }

    public void setResolution() {
        /*implement*/
    }
}
