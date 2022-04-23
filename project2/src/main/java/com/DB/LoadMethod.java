package com.DB;

import java.sql.PreparedStatement;

public interface LoadMethod {
    public Object load(PreparedStatement pstmt, String sql);
}
