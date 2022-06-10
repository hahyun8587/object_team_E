package com.display.page.recordmanagepage;

import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.display.ComponentMediator;
import com.display.CorePage;
import com.display.UIDisplayer;
import com.std.User;
import com.util.search.RecordSearchGlobal;
import com.util.search.RecordSearchLocal;
import com.util.search.RecordSearchName;
import com.util.search.RecordSearch;

public abstract class RecordManageComponentMediator extends ComponentMediator{
    private JCheckBox[] searchOptions; 
    private JTextField searchField;
    protected JTable table;
    private User user;
    private HashMap<String, String> decoratorMap = new HashMap<>();

    public RecordManageComponentMediator(UIDisplayer displayer, JCheckBox[] searchOptions) {
        super(displayer);

        this.searchOptions = searchOptions;
        user = ((CorePage) displayer.getCurrentPage()).getUser();
        decoratorMap.put("전체조회", "com.util.search.RecordSearchGlobal");
        decoratorMap.put("지역조회", "com.util.search.RecordSearchLocal");
        decoratorMap.put("이름조회", "com.util.search.RecordSearchName");
    }

    public abstract void add(); 


    public void delete() {
        
    }

    public void search() {
        
    }

    public void view() {
        /* implement */
    }

    public void registerSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public void registerTable(JTable table) {
        this.table = table;
    }
} 