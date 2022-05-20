package com.record;

import java.util.ArrayList;
import java.util.Iterator;

import com.DB.Query;
import com.util.RecordObserver;
import com.util.Mediator;

/**
 * Abstract class that manages records.
 * This class is applied observer, mediator, and factory design pattern.
 */
public abstract class RecordManager {
    protected ArrayList<Recorded> recordeds;
    private ArrayList<RecordObserver> observers;
    protected Mediator mediator;
    private String sql;

    /**
     * Constructs <code>RecordManager</code>
     * @param recordeds
     */
    public RecordManager(ArrayList<Recorded> recordeds) {
        this.recordeds = recordeds;
    }

    public void modify() {
        /*implement*/
    }

    /**
     * Add a specific recorded to array list by using <code>args</code>. 
     * @param args arguments used to initialize a specific recorded 
     */
    public void register(String[] args) {
        Recorded recorded = create(args);
        sql = Query.getInsertQuery(recorded);

        recordeds.add(recorded);
        _notifyAll();
    }
    
    /**
     * Adds a specific recorded to user whose id is <code>id</code>.  
     * @param id an id of user who will be added a specific recorded
     * @param args arguments used to initialize the specific recorded
     * @return 0 if registeration succeeds, otherwise, -1
     */
    public abstract int registerTo(String id, String[] args); 
        
    /**
     * Removes an ith specific recorded from array list.
     * The <code>Recorded</code> object is also removed from <code>Record</code> object's vector.
     * Sql query for deleting certain record is assigned to <code>sql</code>.
     * @param i an index of recorded to remove
     */
    public void delete(int i) {
        Recorded recorded = recordeds.get(i);
        
        sql = Query.getDeleteQuery(recorded);

        recorded.getRecord().delete(recorded);
        recordeds.remove(i);        
        _notifyAll();
    }

    /**
     * Removes an ith specific recorded from user whose id is <code>id</code>.
     * @param id an id of user who will be deleted a specific recorded 
     * @param i an index of the recorded to remove
     * @return 0 if deletion succeeds, otherwise, -1
     */
    public abstract int deleteFrom(String id, int i);

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
        observers.add(observer);
    }

    /**
     * Notifies all of the <code>Observer</code> objects in array list.
     */
    protected void _notifyAll() {
        Iterator<RecordObserver> it = observers.iterator();
     
        while(it.hasNext())
            it.next().update(this); 
    }

    /**
     * Get array list of <code>Recorded</code> object.
     * @return array list of <code>Recorded</code> object
     s*/
    public ArrayList<Recorded> getRecordeds() {
        return recordeds;
    }
}
