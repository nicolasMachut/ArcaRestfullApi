package com.arca.app;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by nicolas on 27/02/16.
 */
public class MongoDbConnector {

    private MongoDatabase database;

    // It's a singleton ;)
    public final static MongoDbConnector INSTANCE = new MongoDbConnector();

    private MongoDbConnector() {

        // Connection properties
        String databaseName = "arcadb";
        //String host = "ds017248.mlab.com";
        String host = "localhost";
        String user = "arcaBatch";
        String password = "arca";
        //int port = 17248;
        int port = 27017;

        // Creating mongodb uri connection
        //MongoClientURI uri = new MongoClientURI("mongodb://" + user + ":" + password + "@" + host + ":" + port + "/" + databaseName);
        MongoClientURI uri = new MongoClientURI("mongodb://" + host + ":" + port + "/" + databaseName);

        // Creating mongodb connection
        MongoClient mongoClient = new MongoClient(uri);

        // getting mongodb database
        database = mongoClient.getDatabase(uri.getDatabase());
    }

    public MongoCollection<Document> getCollection (String collectionName) {
        return database.getCollection(collectionName);
    }
}
