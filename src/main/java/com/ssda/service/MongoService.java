package com.ssda.service;

import com.google.inject.Inject;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/9/14
 */
public class MongoService {
    DB hitwiseDB;
    private final MongoClient mongo;

    @Inject
    public MongoService(MongoClient mongo) {
        this.mongo = mongo;
        this.hitwiseDB = mongo.getDB("hitwise");
    }

    public void insert(String collectionName, BasicDBObject record) {
        DBCollection collection = hitwiseDB.getCollection(collectionName);
        collection.insert(record);
    }

    public void removeCollection(final String collection) {
        hitwiseDB.getCollection(collection).drop();
    }
}
