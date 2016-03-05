package com.arca.app.resources;

import com.arca.app.dao.LineDao;
import com.arca.app.domain.Line;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
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
    public String test () {
        System.out.println("hrllo");
        //List<Line> lines = lineDao.getAll();
            //String json = new ObjectMapper().writeValueAsString(lines);
        /*return Response.
                ok(json)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .allow("OPTIONS")
                .build();*/
        return "test";
    }
}
