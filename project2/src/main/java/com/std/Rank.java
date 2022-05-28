package com.std;

import java.util.ArrayList;

import com.record.manager.RecordManager;
import com.record.records.Record;
import com.util.Selector;
import com.util.search.RecordSearch;

/**
 * Class that represents rank of user.
 */
public abstract class Rank {
    private String role;
    protected RecordManager manager;
    private Selector selector;

    /**
     * Constructs <code>Rank</code> object with <code>role</code>.
     * @param role a role of this rank 
     */
    public Rank(String role) {
        this.role = role;
    }

    public void chat() {
        /*implement*/
    }

    public ArrayList<Record> searchRecord(RecordSearch searchMethod) {
        manager.setSearchMethod(searchMethod);
        
        return manager.search();
    }

    /**
     * Sets selector of <code>FullTime</code> object.
     * @param selector <code>Selector</code> object
     */
    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    /**
     * Sets a specific record manager of <code>FullTime</code> object.
     * @param i an index of specific record manager to set
     */
    public void setRecordManager(int i) {
        manager = selector.selectManager(i);
    }


}
