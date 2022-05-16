package com.util;

import com.record.RecordManager;

public interface RecordObserver {
    public abstract void update(RecordManager rm);
}
