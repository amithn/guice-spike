package com.spike.tasks;

import com.google.inject.Inject;
import com.mongodb.BasicDBObject;
import com.spike.service.HiveService;
import com.spike.service.MongoService;
import com.spike.tasks.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/9/14
 */
public class MongoDBTableLoaderTask implements Task {

    private final MongoService mongoService;
    private final HiveService hiveService;

    @Inject
    public MongoDBTableLoaderTask(HiveService hiveService, MongoService mongoService) {
        this.mongoService = mongoService;
        this.hiveService = hiveService;
    }

    @Override
    public void execute() {
        ResultSet resultSet = hiveService.executeQuery("SELECT name, amount FROM customers ORDER BY amount ASC");
        mongoService.removeCollection("customers");
        try {
            while(resultSet.next()) {
                System.out.println("Name is " + resultSet.getString(1) + " amount is " + resultSet.getFloat(2));
                BasicDBObject doc = getDocumentForRow(resultSet);
                mongoService.insert("customers", doc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private BasicDBObject getDocumentForRow(ResultSet resultSet) throws SQLException {
        return new BasicDBObject("name", resultSet.getString(1))
                                            .append("amount", resultSet.getString(2));
    }
}
