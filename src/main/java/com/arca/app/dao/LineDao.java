package com.arca.app.dao;

import com.arca.app.MongoDbConnector;
import com.arca.app.domain.Line;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by machu on 03/03/2016.
 */
public class LineDao {

    public List<Line> getAll (){
        List<Line> lines = new ArrayList<Line>();
        MongoCursor cursor = MongoDbConnector.INSTANCE.getCollection("arcaFile").find(new Document()).iterator();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        while (cursor.hasNext()) {
            Document obj = (Document) cursor.next();
            try {
                lines.add(mapper.readValue(obj.toJson(), Line.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }
}
