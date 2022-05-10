package com.record;

import java.util.ArrayList;
import com.util.Observer;

/**
 * Abstract class that manage records.
 * This class is applied observer pattern.
 */
public abstract class RecordManager {
    private ArrayList<Recorded> recordeds;
    private ArrayList<Observer> observers; 

    /**
     * Adds recorded to array list of recorded.
     * @param recorded recorded to add
     */
    public void addRecorded(Recorded recorded) {
        recordeds.add(recorded);
    }

    public void modify() {
        /*implement*/
    }

    public void register() {
        /*implement*/
    }

    public void delete() {
        /*implement*/
    }

    public void getAllRecords() {
        /*implement*/
    }

    /**
     * Adds observer to array list of observer.
     * @param observer observer to add
     */
    public void addObeserver(Observer observer) {
        observers.add(observer);
    }

    private void notifiyAll() {
        /*implement*/
    }
}