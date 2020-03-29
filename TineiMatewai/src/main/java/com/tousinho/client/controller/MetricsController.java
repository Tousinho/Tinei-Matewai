package com.tousinho.client.controller;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;

public class MetricsController {
    private MongoClient mongoClient;
    private final String sensorName;

    public MetricsController(MongoClient mongoClient, String sensorName) {
        this.mongoClient = mongoClient;
        this.sensorName = sensorName;
    }

    public void savePutWaterEvent() {
        MongoDatabase db = mongoClient.getDatabase("dbName");
        MongoCollection<Document> collection = db.getCollection("collectionName");
        collection.insertOne(new Document("sensorName", sensorName).append("time", new Date()));
    }
}
