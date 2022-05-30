package com.util.search;

import java.util.ArrayList;

import com.record.records.Record;

/**
 * Class of extended decorators that searches by speicific search requirement.
 * This class is applied decorator design pattern.
 */
public abstract class RecordSearchDecorator extends RecordSearch {
    private RecordSearch searchMethod;

    /**
     * Constructs a specific seach record decorator with <code>searchMethod</code>.
     * @param searchMethod a specific record search
     */
    public RecordSearchDecorator(RecordSearch searchMethod) {
        this.searchMethod = searchMethod;
    }

    @Override
    public ArrayList<Record> search() {
        return searchMethod.search();
    }
}
