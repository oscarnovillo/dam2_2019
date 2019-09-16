/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import model.Alumno;
import servicios.AlumnoServicio;

/**
 * REST Web Service
 *
 * @author oscar
 */
@Path("alumno")
@RequestScoped
public class AlumnoResource {

    @Context
    private UriInfo context;

    @Inject
    AlumnoServicio alumnoS;
    /**
     * Creates a new instance of AlumnoResource
     */
    public AlumnoResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.servidor.AlumnoResource
     * @return an instance of model.Alumno
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alumno> getJson() {
        //TODO return proper representation object
        return alumnoS.getAll();
    }

    /**
     * PUT method for updating or creating an instance of AlumnoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putXml(List<Alumno> content) {
        System.out.println(content);
    }
}
