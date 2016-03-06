package com.arca.app.dao;

import com.arca.app.MongoDbConnector;
import com.arca.app.domain.ChartLine;
import com.arca.app.domain.GroupedLine;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by machu on 05/03/2016.
 */
public class LineDaoImpl implements LineDao {

    // Static objects should be avoided but it's fine for the mapper :)
    private static final ObjectMapper mapper = new ObjectMapper();

    public List<GroupedLine> getByCountry() {
        AggregateIterable<Document> documentsReturnedByMongo =  MongoDbConnector.INSTANCE.getCollection("arcaFile").aggregate(Arrays.asList(new Document("$group", new Document("_id", "$country").append("sum", new Document("$sum", "$value")))));
        final ArrayList<GroupedLine> lines = new ArrayList<GroupedLine>();
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

    public List<ChartLine> getForChart(Date start, Date end) {
        AggregateIterable<Document> documentsReturnedByMongo =  MongoDbConnector.
                INSTANCE
                .getCollection("arcaFile")
                .aggregate(Arrays.asList(new Document("$match", new Document("timestamp", new Document("$gte", start.getTime()).append("$lte", end.getTime()))),new Document("$group", new Document("_id", new Document("day", new Document("$dayOfYear", "$timestamp")).get("day")).append("sum", new Document("$sum", "$value"))), new Document("$sort", new Document("day", 1))));

        return addToList(documentsReturnedByMongo);
    }

    private ArrayList<ChartLine> addToList(AggregateIterable<Document> documentsReturnedByMongo) {
        final ArrayList<ChartLine> lines = new ArrayList<ChartLine>();
        documentsReturnedByMongo.forEach(new Block<Document>() {
            public void apply(Document document) {

                try {
                    ChartLine line = mapper.readValue(document.toJson(), ChartLine.class);
                    lines.add(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return lines;
    }
}
