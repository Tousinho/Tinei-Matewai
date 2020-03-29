package com.tousinho.client.controller;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MetricsControllerTest {

    @Mock
    MongoClient mongoClient;

    @Mock
    MongoDatabase mongoDb;

    @Mock
    MongoCollection<Document> collection;

    @Test
    public void controllerGetDatabase() {
        MetricsController controller = new MetricsController(mongoClient, "sersonName");
        Mockito.when(mongoClient.getDatabase(Mockito.anyString())).thenReturn(mongoDb);
        Mockito.when(mongoDb.getCollection(Mockito.anyString())).thenReturn(collection);
        controller.savePutWaterEvent();

        Mockito.verify(mongoClient).getDatabase(Mockito.anyString());
    }

    @Test
    public void controllerGetCollection() {
        MetricsController controller = new MetricsController(mongoClient, "sersonName");
        Mockito.when(mongoClient.getDatabase(Mockito.anyString())).thenReturn(mongoDb);
        Mockito.when(mongoDb.getCollection(Mockito.anyString())).thenReturn(collection);
        controller.savePutWaterEvent();

        Mockito.verify(mongoDb).getCollection(Mockito.anyString());
    }

    @Test
    public void controllerPutDocument() {
        MetricsController controller = new MetricsController(mongoClient, "sersonName");
        Mockito.when(mongoClient.getDatabase(Mockito.anyString())).thenReturn(mongoDb);
        Mockito.when(mongoDb.getCollection(Mockito.anyString())).thenReturn(collection);
        controller.savePutWaterEvent();

        Mockito.verify(collection).insertOne(Mockito.any(Document.class));
    }

    @Test
    public void controllerPutDocumentWithSensorNameAndDateTime() {
        MetricsController controller = new MetricsController(mongoClient, "sersonName");
        Mockito.when(mongoClient.getDatabase(Mockito.anyString())).thenReturn(mongoDb);
        Mockito.when(mongoDb.getCollection(Mockito.anyString())).thenReturn(collection);
        controller.savePutWaterEvent();

        Mockito.verify(collection).insertOne(Mockito.argThat(new DocumentMatcher()));
    }
}

class DocumentMatcher implements ArgumentMatcher<Document> {

    @Override
    public boolean matches(Document right) {
        return right.containsKey("sensorName") && right.containsKey("time");
    }
}