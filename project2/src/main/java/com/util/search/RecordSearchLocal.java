package com.util.search;

import java.util.ArrayList;

import com.record.manager.RecordManager;
import com.record.records.Record;
import com.record.records.Recorded;

/**
 * Class of primitive decorator that searches all of the records locally.
 * This class is applied decorator design pattern.
 */
public class RecordSearchLocal extends RecordSearchAll {

    /**
     * Constructs <code>SearchLocal</code> object with <code>manger</code>.
     * @param manager a specific record manager
     */
    public RecordSearchLocal(RecordManager manager) {
        super(manager);
    }

    @Override
    public ArrayList<Record> search() {
        ArrayList<Record> records = new ArrayList<Record>();

        for(Recorded recorded : manager.getRecordeds()) 
            records.add(recorded.getRecord());
        
        return records;
    }
}
