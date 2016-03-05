package com.arca.app.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by machu on 05/03/2016.
 */
@Path("/batch")
public class BatchResource {

    @POST
    @Path("new")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newBatch () {
        try {
            Process pro = Runtime.getRuntime().exec("java -jar C://Users/machu/Documents/BatchArca/target/bonjour.jar");
        } catch (IOException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }
}
