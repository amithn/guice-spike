package com.spike.tasks;

import com.spike.service.HiveService;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/2/14
 */
public class AggregateCustomersTask implements Task {

    private final HiveService hiveService;

    @Inject
    public AggregateCustomersTask(HiveService hiveService) {
        this.hiveService = hiveService;
    }

    @Override
    public void execute() {
        ResultSet resultSet = hiveService.executeQuery("show tables");
        try {
            while (resultSet.next()) {
                System.out.println("Table Name is " + resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
