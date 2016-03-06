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
import java.util.List;

/**
 * Created by machu on 05/03/2016.
 */
public class LineDaoImpl implements LineDao {

    public List<GroupedLine> getByCountry() {
        final ObjectMapper mapper = new ObjectMapper();
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

    public List<ChartLine> getForChart(int year) {
        final ObjectMapper mapper = new ObjectMapper();
        final ArrayList<ChartLine> lines = new ArrayList<ChartLine>();
        AggregateIterable<Document> documentsReturnedByMongo =  MongoDbConnector.
                INSTANCE
                .getCollection("arcaFile")
                .aggregate(Arrays.asList(new Document("$group", new Document("_id", new Document("day", new Document("$dayOfYear", "$timestamp")).get("day")).append("sum", new Document("$sum", "$value")))));
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
