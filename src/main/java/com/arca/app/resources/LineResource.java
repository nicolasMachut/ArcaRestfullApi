package com.arca.app.resources;

import com.arca.app.bo.LineBo;
import com.arca.app.bo.LineBoImpl;
import com.arca.app.domain.GroupedLine;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/lines")
public class LineResource {

    private LineBo lineBo;

    public LineResource () {
        this.lineBo = new LineBoImpl();
    }

    @GET
    @Path("lineByCountry")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDataGroupByCountry() throws JsonProcessingException {
        System.out.println("test");
        final ObjectMapper mapper = new ObjectMapper();
        List<GroupedLine> res = lineBo.getByCountry();
        String json = mapper.writeValueAsString(res);
        return Response.ok(json).build();
    }

    @GET
    @Path("chart/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDataGroupByDayForAYear(@PathParam("year") int year) throws JsonProcessingException {

        final ObjectMapper mapper = new ObjectMapper();
        List<GroupedLine> res = lineBo.getForChart(year);
        String json = mapper.writeValueAsString(res);
        return Response.ok(json).build();
    }
}
