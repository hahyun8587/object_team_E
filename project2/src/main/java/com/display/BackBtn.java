package com.display;

import java.awt.event.ActionListener;

public class BackBtn extends CommonBtn {
    
    public BackBtn(ActionListener al, ComponentMediator mediator) {
        super("뒤로가기", al, mediator);
    }

    public void execute() {
        mediator.back();
    }
}
