package com.util;

import java.sql.SQLException;

public interface UserObserver {
    public abstract void update(UserAuthentication ua) throws SQLException;    
}
