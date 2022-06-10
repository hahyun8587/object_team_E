package com.record.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.DB.Query;
import com.record.records.Recorded;
import com.record.records.Record;
import com.util.RecordObserver;
import com.util.search.RecordSearch;
import com.util.Mediator;

/**
 * Abstract class that manages records.
 * This class is applied observer, mediator, and factory design pattern.
 */
public abstract class RecordManager {
    protected ArrayList<Recorded> recordeds;
    protected Mediator mediator;
    protected int type;
    private ArrayList<RecordObserver> observers;
    private RecordSearch searchMethod;
    private String sql;

    /**
     * Constructs a specific record manager with <code>recordeds</code>.
     * @param recordeds
     */
    public RecordManager(ArrayList<Recorded> recordeds, Mediator mediator, ArrayList<RecordObserver> observers) {
        this.recordeds = recordeds;
        this.mediator = mediator;
        this.observers = observers;
    }

    public void modify() {
        /*implement*/
    }

    /**
     * Add a specific recorded to array list by using <code>args</code>. 
     * @param args arguments used to initialize a specific recorded 
     * @throws SQLException
     */
    public void register(String[] args) throws SQLException {
        Recorded recorded = create(args);
        sql = getInsertQuery(recorded);

        recordeds.add(recorded);
        _notifyAll();
    }
    
    /**
     * Gets a SQL query for inserting a speicific recorded into the database. 
     * @param recorded a recorded to add
     * @return a SQL query for inserting a specific recorded into the database
     */
    protected abstract String getInsertQuery(Recorded recorded);

    /**
     * Adds a specific recorded to an user's specific record manager whose id is <code>id</code>.  
     * @param id an id of user whose specific record manager to which its specific record is added
     * @param args arguments used to initialize the specific recorded
     * @return 0 if registeration succeeds, otherwise, -1
     * @throws SQLException
     */
    public int registerTo(String id, String[] args) throws SQLException {
        return mediator.sendRegisteration(id, args, type);
    }
        
    /**
     * Removes an ith specific recorded from array list.
     * The <code>Recorded</code> object is also removed from <code>Record</code> object's vector.
     * Sql query for deleting certain record is assigned to <code>sql</code>.
     * @param i an index of recorded to remove
     * @throws SQLException
     */
    public void delete(int i) throws SQLException {
        Recorded recorded = recordeds.get(i);
        
        sql = Query.getDeleteQuery(recorded);

        recorded.getRecord().delete(recorded);
        recordeds.remove(i);        
        _notifyAll();
    }

    /**
     * Removes an ith specific recorded from an user's specific record manager whose id is <code>id</code>.
     * @param id an id of user whose specific record manager from which its specific record is deleted 
     * @param recordName name of recorded to remove
     * @return 0 if deletion succeeds, otherwise, -1
     * @throws SQLException
     */
    public int deleteFrom(String id, String recordName) throws SQLException {
        

        return mediator.sendDeletion(id, type, recordName);
    }

    /**
     * Searches all of the specific condition of records either locally or globally.
     * @return array list of a specific condition of records
     */
    public ArrayList<Record> search() {
        return searchMethod.search();
    }

    /**
     * Creates a specific recorded using <code>args</code>. 
     * @param args arguments used to initialize a specific recorded
     * @return the specific reocrded
     */
    protected abstract Recorded create(String[] args);

    /**
     * Adds an <code>Observer</code> object to array list of observer.
     * @param observer an <code>Observer</code> object to add
     */
    public void attach(RecordObserver observer) {
        if(observers == null)
            observers = new ArrayList<RecordObserver>();
        
        observers.add(observer);
    }

    /**
     * Notifies all of the <code>Observer</code> objects in array list.
     * @throws SQLException
     */
    private void _notifyAll() throws SQLException {
        Iterator<RecordObserver> it = observers.iterator();
     
        while(it.hasNext())
            it.next().update(this); 
    }

    /**
     * Gets array list of specific recorded.
     * @return array list of specific recorded
     */
    public ArrayList<Recorded> getRecordeds() {
        return recordeds;
    }

    /**
     * Gets <code>Mediator</code> object.
     * @return <code>Mediator</code> object
     */
    public Mediator getMediator() {
        return mediator;
    }

    /**
     * Gets type of this record manager.
     * @return type of this record manager
     */
    public int getType() {
        return type;
    }

    /**
     * Gets a sql query for deleting or adding record.
     * @return a sql query for deleting or adding record
     */
    public String getSql() {
        return sql;
    }

    /**
     * Sets <code>Search</code> object.
     * @param searchMethod <code>Search</code> object
     */
    public void setSearchMethod(RecordSearch searchMethod) {
        this.searchMethod = searchMethod;
    }
}
