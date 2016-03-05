package com.arca.app.resources;

import com.arca.app.dao.LineDao;
import com.arca.app.domain.Line;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(lines);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Response.
                ok(json)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .build();
    }
}
