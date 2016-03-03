package com.arca.app.resources;

import com.arca.app.MongoDbConnector;
import com.arca.app.dao.LineDao;
import com.arca.app.domain.Line;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by nicolas on 26/02/16.
 */
@Path("/entry-point")
public class EntryPoint {

    private LineDao lineDao;

    public EntryPoint () {
        this.lineDao = new LineDao();
    }

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test () {

        List<Line> lines = lineDao.getAll();
        GenericEntity<List<Line>> booksEntity = new GenericEntity<List<Line>>(lines) {
        };

        return Response.ok(booksEntity)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
}
