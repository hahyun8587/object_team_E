package com.record;

import java.util.ArrayList;
import java.util.Iterator;
import com.std.User;
import com.util.Observer;

/**
 * Abstract class that manages records.
 * This class is applied observer pattern.
 */
public abstract class RecordManager {
    private ArrayList<Recorded> recordeds;
    private ArrayList<Observer> observers; 
    protected Recorded temp;

    public void modify() {
        /*implement*/
    }

    /**
     * Add a <code>Recorded</code> object to specific <code>record</code> and <code>rm</code>.   
     * @param participant a participant who participates a record 
     * @param record the record to add
     * @param rm record manager that manages the record
     */
    public abstract void register(User participant, Record record, RecordManager rm); 
        
    /**
     * Removes ith <code>Recorded</code> object from array list.
     * The <code>Recorded</code> object is also removed from <code>Record</code> object's vector.
     * Removed object is assigned to <code>temp</code> for saving. 
     * @param i an index of <code>Recorded</code> object to remove
     */
    public void delete(int i) {
        temp = recordeds.get(i);
        
        temp.getRecord().delete(temp);
        recordeds.remove(i);
        _notifyAll();
    }

    /**
     * Adds an <code>Observer</code> object to array list of observer.
     * @param observer an <code>Observer</code> object to add
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Adds a <code>Recorded</code> object to array list of recorded.
     * @param recorded a <code>Recorded</code> object to add
     */
    public void addRecorded(Recorded recorded) {
        recordeds.add(recorded);
    }

    /**
     * Notifies all of the <code>Observer</code> objects in array list.
     */
    protected void _notifyAll() {
        Iterator<Observer> it = observers.iterator();
     
        while(it.hasNext())
            it.next().update(this); 
    }

    /**
     * Get array list of <code>Recorded</code> object.
     * @return array list of <code>Recorded</code> object
     */
    public ArrayList<Recorded> getRecordeds() {
        return recordeds;
    }

    /**
     * Get a temporary <code>Recorded</code> object for saving.
     * @return a temporary <code>Recorded</code> object
     */
    public Recorded getTemp() {
        return temp;
    }
}
