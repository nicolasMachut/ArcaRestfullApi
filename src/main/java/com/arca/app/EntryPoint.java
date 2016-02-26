package com.arca.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by nicolas on 26/02/16.
 */
@Path("/entry-point")
public class EntryPoint {

    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test () {
        return "bonjour a tous";
    }
}
