package com.util;

import com.record.manager.RecordManager;

public interface RecordObserver {
    public abstract void update(RecordManager rm);
}
