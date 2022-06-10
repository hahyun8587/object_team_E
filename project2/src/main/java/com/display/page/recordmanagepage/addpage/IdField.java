package com.display.page.recordmanagepage.addpage;

import javax.swing.JTextField;
import com.display.ComponentMediator;

public class IdField extends JTextField {
    private ComponentMediator mediator;
    
    public IdField(ComponentMediator mediator) {
        this.mediator = mediator;
        
        ((AddRecordComponentMediator) mediator).registerIdField(this);
    }
}
