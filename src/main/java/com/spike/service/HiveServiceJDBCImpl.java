package com.spike.service;

import com.google.inject.Inject;

import java.sql.ResultSet;
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
        Statement statement = getStatement();
        try {
            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        Statement statement = getStatement();
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return resultSet;
    }

    private Statement getStatement() {
        Statement statement = null;
        try {
            statement = connection.get().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return statement;
    }
}
