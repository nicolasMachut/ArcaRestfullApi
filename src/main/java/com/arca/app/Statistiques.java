package com.arca.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by machu on 03/03/2016.
 */
@Path("/statistiques")
public class Statistiques {

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test () {
        MongoDbConnector.INSTANCE.getCollection("arcaFileDao");
        return Response.ok("salut").header("Access-Control-Allow-Origin", "*").build();
    }
}
