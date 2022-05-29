package com.util.builder;

import java.util.ArrayList;

import com.record.manager.RecordManager;
import com.record.records.Recorded;
import com.util.Mediator;
import com.util.RecordObserver;

/**
 * Abstract class of record builders.
 * This class is applied builder design pattern.
 */
public abstract class RecordManagerBuilder {
    protected ArrayList<Recorded> recordeds;
    protected ArrayList<RecordObserver> observers;
    protected Mediator mediator;
      
    /**
     * Constructs a specific record manager builder with <code>recordeds</code>.
     * @param recordeds array list of <code>Recorded</code> object that used to construct a specific record manager
     */
    public RecordManagerBuilder(ArrayList<Recorded> recordeds) {
        this.recordeds = recordeds;
    }

    /**
     * Adds a specific record observer to array list.
     * @param observer a specific record observer to add
     * @return this specific record manger builder object
     */
    public RecordManagerBuilder addObserver(RecordObserver observer) {
        if(observers == null)
            observers = new ArrayList<RecordObserver>();
        
        observers.add(observer);

        return this;
    }

    /**
     * Sets <code>Mediator</code> object.
     * @param mediator <code>Mediator</code> object to set
     * @return this specific record manager builder object
     */
    public RecordManagerBuilder setMediator(Mediator mediator) {
        this.mediator = mediator;

        return this;
    }
    
    /**
     * Builds a specific record manager with the arguments setted.
     * @return a specific record manager that is built.
     */
    public abstract RecordManager build();
}
