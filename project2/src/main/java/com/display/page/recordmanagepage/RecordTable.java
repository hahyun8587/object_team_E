package com.display.page.recordmanagepage;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.display.ComponentMediator;

public class RecordTable extends JTable {
    private ComponentMediator mediator;

    public RecordTable(ComponentMediator mediator, Object[][] data, String[] header) {
        this.mediator = mediator;

        setModel(new DefaultTableModel(data, header));
        ((RecordManageComponentMediator) mediator).registerTable(this);
    }
}
