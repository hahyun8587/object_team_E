package com.record.search;

import java.util.ArrayList;

import com.record.manager.RecordManager;
import com.record.records.Record;

/**
 * Class of primitive decorator that searches all of the records globally.
 * This class is applied decorator design pattern. 
 */
public class SearchGlobal extends SearchAll {
    
    /**
     * Constructs <code>SearchGlobal</code> object with <code>manager</code>.
     * @param manager a specific record manager 
     */
    public SearchGlobal(RecordManager manager) {
        super(manager);
    }

    @Override
    public ArrayList<Record> search() {
        return manager.getMediator().sendAllList(manager.getType());
    }
}
