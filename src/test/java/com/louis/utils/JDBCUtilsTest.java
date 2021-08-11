package com.louis.utils;

import junit.framework.TestCase;

import java.sql.Connection;

public class JDBCUtilsTest extends TestCase {

    public void testGetConnection() {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }
}