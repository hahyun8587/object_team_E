package com.DB;

import com.util.Observer;
import com.record.RecordManager;

public abstract class Saver implements Observer {
    public abstract void update(RecordManager rm);
    
    
}
