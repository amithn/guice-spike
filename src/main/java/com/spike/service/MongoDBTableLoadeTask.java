package com.spike.service;

import com.google.inject.Inject;
import com.mongodb.BasicDBObject;
import com.spike.tasks.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/9/14
 */
public class MongoDBTableLoadeTask implements Task {

    private final MongoService mongoService;
    private final HiveService hiveService;

    @Inject
    public MongoDBTableLoadeTask(HiveService hiveService, MongoService mongoService) {
        this.mongoService = mongoService;
        this.hiveService = hiveService;
    }

    @Override
    public void execute() {
        ResultSet resultSet = hiveService.executeQuery("select * from customers");
        try {
            while(resultSet.next()) {
                System.out.println("Name is " + resultSet.getString(1) + " amount is " + resultSet.getFloat(2));
                BasicDBObject doc = new BasicDBObject("name", resultSet.getString(1))
                                        .append("amount", resultSet.getString(2));
                mongoService.insert("customers", doc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
