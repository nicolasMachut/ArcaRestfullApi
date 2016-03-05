package com.arca.app.resources;

import com.arca.app.MongoDbConnector;
import com.arca.app.domain.GroupedLine;
import com.arca.app.domain.Line;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by machu on 05/03/2016.
 */
@Path("/lines")
public class LineResource {

    @GET
    @Path("lineByCountry")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test () {
        AggregateIterable<Document> docs =  MongoDbConnector.INSTANCE.getCollection("arcaFile").aggregate(Arrays.asList(new Document("$group", new Document("_id", "$country").append("sum", new Document("$sum", "$value")))));
        final ObjectMapper mapper = new ObjectMapper();
        final ArrayList<GroupedLine> lignes = new ArrayList<GroupedLine>();
        docs.forEach(new Block<Document>() {
            public void apply(Document document) {
                GroupedLine line = null;
                try {
                    System.out.println(document.toJson());
                    line = mapper.readValue(document.toJson(), GroupedLine.class);
                    lignes.add(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        String res = null;
        try {
            res = mapper.writeValueAsString(lignes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Response.ok(res).build();
    }
}
