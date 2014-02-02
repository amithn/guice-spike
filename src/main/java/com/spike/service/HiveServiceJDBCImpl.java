package com.spike.service;

import com.google.inject.Inject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveServiceJDBCImpl implements HiveService {

    HiveConnection connection;

    @Inject
    public HiveServiceJDBCImpl(HiveConnection connection) {
       this.connection = connection;
    }

    @Override
    public void execute(String query) {
        try {
            Statement statement = connection.get().createStatement();
            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
