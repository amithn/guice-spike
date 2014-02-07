package com.spike.tasks;


import com.google.inject.Inject;
import com.spike.logger.Log;
import com.spike.service.HiveService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinCustomersHiveTask implements Task {

    private final HiveService hiveService;

    @Inject
    public JoinCustomersHiveTask(HiveService hiveService) {
        this.hiveService = hiveService;
    }

    @Log
    @Override
    public void execute() {
        hiveService.execute("drop table customers");
        hiveService.createTableFromTextFiles("customers", "id INT, name String", ',', ':', '~', '-', "/user/cloudera/customer/input");

        ResultSet resultSet = hiveService.executeQuery("show tables");
        try {
            while (resultSet.next()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
