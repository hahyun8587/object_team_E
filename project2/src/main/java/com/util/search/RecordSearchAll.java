package com.util.search;

import java.util.ArrayList;

import com.record.manager.RecordManager;
import com.record.records.Record;

/**
 * Abstract class of a primary decorator that searchs all of the records. 
 * This class is applied decorator design pattern.
 */
public abstract class RecordSearchAll extends RecordSearch {
    protected RecordManager manager;

    /**
     * Constructs a specific searchAll with <code>manager</code>.
     * @param manager a specific record manager
     */
    public RecordSearchAll(RecordManager manager) {
        this.manager = manager;
    } 

    public abstract ArrayList<Record> search();
}
