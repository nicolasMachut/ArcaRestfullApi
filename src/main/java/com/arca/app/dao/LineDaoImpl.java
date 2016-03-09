package com.arca.app.dao;

import com.arca.app.utils.MongoDbConnector;
import com.arca.app.domain.GroupedLine;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LineDaoImpl implements LineDao {

    private static final ObjectMapper mapper = new ObjectMapper();

    public List<GroupedLine> getByCountry() {
        return toListOfPojo(executeQueryGetByCountry());
    }

    public AggregateIterable<Document> executeQueryGetByCountry () {
        return MongoDbConnector.
                INSTANCE.
                getCollection("arcaFile").
                aggregate(Arrays.asList(new Document("$group", new Document("_id", "$country").
                        append("sum", new Document("$sum", "$value")))));
    }

    public List<GroupedLine> getForChart(Date start, Date end) {
        return toListOfPojo(executeQueryGetForChart(start, end));
    }

    public AggregateIterable<Document> executeQueryGetForChart (Date start, Date end) {
        return MongoDbConnector.
                INSTANCE
                .getCollection("arcaFile")
                .aggregate(Arrays.asList(new Document("$match", new Document("timestamp", new Document("$gte", start).
                        append("$lte", end))),new Document("$group", new Document("_id", new Document("day", new Document("$dayOfYear", "$timestamp")).
                        get("day")).append("sum", new Document("$sum", "$value"))), new Document("$sort", new Document("_id", 1))));
    }

    private ArrayList<GroupedLine> toListOfPojo(MongoIterable<Document> documentsReturnedByMongo) {
        final ArrayList<GroupedLine> lines = new ArrayList<>();
        documentsReturnedByMongo.forEach(new Block<Document>() {
            public void apply(Document document) {

                try {
                    GroupedLine line = mapper.readValue(document.toJson(), GroupedLine.class);
                    lines.add(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return lines;
    }
}
