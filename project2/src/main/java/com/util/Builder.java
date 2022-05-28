package com.util;

import com.record.manager.RecordManager;
import com.std.User;

/**
 * Inteface of builder classes.
 * This interface is applied builder design pattern.
 */
public interface Builder { 
    /**
     * Adds a specific record manager to <code>Selector</code> obejct.
     * @param manager a specific record manager to add
     * @return a specific builder object
     */
    public abstract Builder addManager(RecordManager manager);
    
    /**
     * Builds <code>User</code> object with the arguments setted.
     * @return <code>User</code> object that is built.
     */
    public abstract User build();
}
