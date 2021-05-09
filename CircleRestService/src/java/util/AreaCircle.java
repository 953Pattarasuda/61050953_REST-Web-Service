/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.StringWriter;
import static java.lang.Math.PI;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXB;
import model.Result;

/**
 * REST Web Service
 *
 * @author luksorn
 */
@Path("area")
public class AreaCircle {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AreaCircle
     */
    public AreaCircle() {
    }

    /**
     * Retrieves representation of an instance of util.AreaCircle
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{radius}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public String getXml(@PathParam("radius")  double radius) {
        double area = PI*(radius*radius);
        double circum = 2*PI*radius;
        StringWriter writer = new StringWriter();
        Result result = new Result();
        result.setArea(area);
        result.setCircum(circum);
        JAXB.marshal(result, writer);
        return writer.toString();
    }

    /**
     * PUT method for updating or creating an instance of AreaCircle
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
