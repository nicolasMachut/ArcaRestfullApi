package com.arca.app.utils;

import com.arca.app.server.JettyServer;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDbConnector {

    private MongoDatabase database;

    // It's a singleton ;)
    public final static MongoDbConnector INSTANCE = new MongoDbConnector();

    private MongoDbConnector() {

        // Creating mongodb uri connection
        //MongoClientURI uri = new MongoClientURI("mongodb://" + user + ":" + password + "@" + host + ":" + port + "/" + databaseName);
        MongoClientURI uri = new MongoClientURI("mongodb://" + JettyServer.databaseHost + ":" + JettyServer.databasePort + "/" + JettyServer.databaseName);

        // Creating mongodb connection
        MongoClient mongoClient = new MongoClient(uri);

        // getting mongodb database
        database = mongoClient.getDatabase(uri.getDatabase());
    }

    public MongoCollection<Document> getCollection (String collectionName) {
        return database.getCollection(collectionName);
    }
}
