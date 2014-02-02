package com.spike.service;

import java.sql.Connection;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/2/14
 */
public class HiveConnection {
    Connection connection;

    public HiveConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection get() {
        return connection;
    }
}
