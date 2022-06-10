package com.display.page.recordmanagepage.addpage;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.display.ComponentMediator;
import com.display.CorePage;
import com.display.UIDisplayer;
import com.display.page.recordmanagepage.RecordManagePage;
import com.std.User;
import com.std.TeamLeader;

import java.sql.SQLException;

public class AddRecordComponentMediator extends ComponentMediator {
    private JTable table;
    private JTextField idField;
    private JTextField[] argFields;

    public AddRecordComponentMediator(UIDisplayer displayer, JTable table, JTextField[] argFields) {
        super(displayer);
        
        this.table = table;
        this.argFields = argFields;
    }

    public void add() throws SQLException {
        String[] args = new String[argFields.length];
        RecordManagePage page = (RecordManagePage) displayer.getCurrentPage();
        User user = ((CorePage) page).getUser();

        for(int i = 0; i < argFields.length; i++) 
            args[i] = argFields[i].getText();

        if(user.getId().equals(idField.getText())) {
            ((TeamLeader) user.rank).registerRecord(args); 
            table.setModel(new DefaultTableModel(page.loadData(), page.getHeader()));
            prune();        
        }
        else { 
            if(((TeamLeader) user.rank).registerRecordTo(idField.getText(), args) == 0)
                JOptionPane.showConfirmDialog(displayer.getCurrentPage(), "일치하는 아이디가 없습니다.", "입력오류", JOptionPane.ERROR_MESSAGE);
            else {
                table.setModel(new DefaultTableModel(page.loadData(), page.getHeader()));
                prune();
            }
        }   
    }

    public void cancel() {
        prune();
    }

    public void registerIdField(JTextField idField) {
        this.idField = idField;
    }

}
