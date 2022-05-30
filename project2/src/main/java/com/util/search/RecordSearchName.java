package com.util.search;

import java.util.ArrayList;

import com.record.records.Record;

/**
 * Class of extended decorator that searches records by name.
 * This class is applied decorator design pattern.
 */
public class RecordSearchName extends RecordSearchDecorator {
    private String name;

    /**
     * Constructs <code>RecordSearchName</code> object with <code>searchMethod</code>.
     * Construction of record search must end with <code>RecordSearchLocal</code> or <code>RecordSearchGlobal</code> object.
     * @param searchMethod a speicific record search  
     * @param name a name of record to search
     */
    public RecordSearchName(RecordSearch searchMethod, String name) {
        super(searchMethod);

        this.name = name;
    }

    @Override
    public ArrayList<Record> search() {
        ArrayList<Record> dst = new ArrayList<Record>();
        ArrayList<Record> src = super.search();
 
        for(Record record : src) {
            if(record.getName().contains(name))
                dst.add(record);
        } 
        return dst;
    }
}
