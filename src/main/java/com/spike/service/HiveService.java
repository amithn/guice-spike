package com.spike.service;


import java.sql.ResultSet;

public interface HiveService {
    void execute(String query);
    ResultSet executeQuery(String query);
    void createTableFromTextFiles(String tableName, String SchemaString,
                                  Character fieldDelimiter, Character collDelim,
                                  Character mapDelim, Character lineDelim, String textFilesDirectory);
}
