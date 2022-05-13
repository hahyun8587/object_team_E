package com.util;

import com.record.RecordManager;

public interface Observer {
    public abstract void update(RecordManager rm);
}
