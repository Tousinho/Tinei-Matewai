package com.tousinho.client.controller;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;

public class MetricsController {
    protected static final String SENSOR_NAME = "sensorName";
    protected static final String TIME = "time";
    public static final String DATABASE_NAME = "TineiMatewaiDB";
    public static final String COLLECTION_NAME = "PutWaterEvents";
    private MongoClient mongoClient;
    private final String sensorName;

    public MetricsController(MongoClient mongoClient, String sensorName) {
        this.mongoClient = mongoClient;
        this.sensorName = sensorName;
    }

    public void savePutWaterEvent() {
        MongoDatabase db = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        collection.insertOne(new Document(SENSOR_NAME, sensorName).append(TIME, new Date()));
    }
}
