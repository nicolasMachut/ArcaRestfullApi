package com.arca.app.dao;

import com.arca.app.domain.Line;

/**
 * Created by machu on 03/03/2016.
 */
public interface LineRepository {

    public Line findFirst ();

    /*public List<Line> getAll (){
        List<Line> lines = new ArrayList<Line>();
        MongoCursor cursor = MongoDbConnector.INSTANCE.getCollection("arcaFile").find(new Document()).iterator();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        while (cursor.hasNext()) {
            Document obj = (Document) cursor.next();
            try {
                Line line = mapper.readValue(obj.toJson(), Line.class);
                lines.add(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }

    public List<Line> getGroupPays () {
        List<Line> lines = new ArrayList<Line>();
        ArrayList<Document> docs = new ArrayList<Document>();
        Document match = new Document();
        MongoDbConnector.INSTANCE.getCollection("arcaFile").find(new Document("$group", "country"));
        Aggregation aggregation = newAggregation(group("country").sum("value").as("total"));
        aggregation.toDbObject("test");
        return null;
    }*/
}
