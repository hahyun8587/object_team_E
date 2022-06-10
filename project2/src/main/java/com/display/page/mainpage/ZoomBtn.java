package com.display.page.mainpage;

import java.awt.event.ActionListener;

import com.display.CommonBtn;
import com.display.ComponentMediator;

import java.io.IOException;
import java.net.URISyntaxException;

public class ZoomBtn extends CommonBtn {

    public ZoomBtn(String text, ActionListener al, ComponentMediator mediator) {
        super(text, al, mediator);
    }

    public void execute() {
        try {
            ((MainComponentMediator) mediator).zoom();
        } catch(URISyntaxException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
