package com.spike.service;

import com.google.inject.Inject;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/9/14
 */
public class MongoLoggingService {
    DB hitwiseDB;
    private final MongoClient mongo;

    @Inject
    public MongoLoggingService(MongoClient mongo) {
        this.mongo = mongo;
        this.hitwiseDB = mongo.getDB("hitwise");
    }

    public void logJobMessage(BasicDBObject log) {
        DBCollection collection = hitwiseDB.getCollection("logs");
        collection.insert(log);
    }


}
