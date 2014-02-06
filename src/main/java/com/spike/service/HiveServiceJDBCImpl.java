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
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error is " + e.getMessage());
        }
    }

    @Override
    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        Statement statement = getStatement();
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public void createTableFromTextFiles(String tableName, String SchemaString,
                                         Character fieldDelimiter, Character collDelim,
                                         Character mapDelim, Character lineDelim, String textFilesDirectory) {
        String query = String.format("CREATE EXTERNAL TABLE  %s (%s) ROW FORMAT DELIMITED FIELDS TERMINATED BY '%c'" +
                      " COLLECTION ITEMS TERMINATED BY '%c' MAP KEYS TERMINATED BY '%c' LINES TERMINATED BY '\n'" +
                      " STORED AS TEXTFILE LOCATION '%s'", tableName, SchemaString, fieldDelimiter, ':', '~', textFilesDirectory);
        System.out.println("creating " + query);
        execute(query);

    }

    private Statement getStatement() {
        Statement statement = null;
        try {
            statement = connection.get().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
