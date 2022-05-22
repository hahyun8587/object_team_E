package com.std;

import java.util.ArrayList;

import com.record.manager.RecordManager;
import com.record.records.Record;
import com.record.search.Search;
import com.util.Selector;

/**
 * Class that represents rank of user.
 */
public class Rank {
    private String role;
    protected RecordManager manager;
    protected Selector selector;

    /**
     * Constructs a <code>Rank</code> object with <code>role</code>.
     * @param role a role of this rank 
     */
    public Rank(String role) {
        this.role = role;
    }

    public void chat() {
        /*implement*/
    }

    public void searchRecord(Search searchMethod) {
        /*implement*/
    }
}
