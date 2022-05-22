package com.util;

import java.util.ArrayList;

import com.record.manager.RecordManager;

public class Selector {
    private ArrayList<RecordManager> managers = new ArrayList<RecordManager>();
    private RecordManager selectedManager;

    /**
     * Adds a specific record manager to array list.
     * @param manager a specific record manager to add
     */
    public void addManager(RecordManager manager) {
        managers.add(manager);
    }

    /**
     * Selects a record manager to use.
     * @param i an index of record manager
     * @return a specific record manager
     */
    public RecordManager selectManager(int i) {
        if(i > managers.size() - 1)
            return null; 

        return selectedManager = managers.get(i);
    }
}
