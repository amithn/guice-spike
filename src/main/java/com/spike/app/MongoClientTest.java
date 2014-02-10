package com.spike.app;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.Date;

public class MongoClientTest {

    public static void main(String[] args) {

        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DB db = mongoClient.getDB("hitwise");
        DBCollection jobsColl = db.getCollection("messages");

        BasicDBObject doc = new BasicDBObject("name", "CanadaJob").
                append("type", "ETL").
                append("time", new Date());

        jobsColl.insert(doc);
    }
}
