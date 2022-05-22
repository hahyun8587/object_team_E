package com.record.search;

import java.util.ArrayList;

import com.record.records.Record;

/**
 * Class that searchs records.
 * This class is applied decorator design pattern.
 */
public abstract class Search {
    /**
     * Searchs specific condition of records.
     * @return array list of a specific condition of record
     */
    public abstract ArrayList<Record> search();
}
