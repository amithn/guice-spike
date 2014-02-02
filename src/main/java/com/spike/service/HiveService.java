package com.spike.service;


import java.sql.ResultSet;

public interface HiveService {
    void execute(String query);

    ResultSet executeQuery(String query);
}
