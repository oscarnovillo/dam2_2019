package rest;


import dao.modelo.Usuario;
import servicios.ServiciosUsuarios;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Usuarios {


  @Inject
  private ServiciosUsuarios su;


  @GET
  public List<Usuario> getUsers(@Context HttpServletResponse response, @Context HttpServletRequest request)
  {
    ServiciosUsuarios su = new ServiciosUsuarios();
    if (request.getSession().getAttribute("kk") == null)
    {
      request.getSession().setAttribute("kk",0);
    }
    request.getSession().setAttribute("kk", ((Integer)request.getSession().getAttribute("kk"))+1);

//    try {
//      response.sendError(403,"ERROR DE MIERDA "+request.getSession().getAttribute("kk"));
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
    return su.getUsers();
  }


//  @GET
//  @Produces(MediaType.APPLICATION_JSON)
//  public Usuario getUser(@QueryParam("loginId") String login)
//  {
//    ServiciosUsuarios su = new ServiciosUsuarios();
//    return su.getUser(login);
//  }

//  @GET
//  @Produces(MediaType.APPLICATION_JSON)
//  @Path("/get/{login}")
//  public Usuario getUserLogin(@PathParam("login") String login,@QueryParam("loginId") String loginId)
//  {
//    if (login == null)
//    {
//      login = loginId;
//    }
//    ServiciosUsuarios su = new ServiciosUsuarios();
//    return su.getUser(login);
//  }

  @POST
  public Response addUsuario(Usuario user )
  {
    return Response.ok(su.addUser(user)).build();
  }


  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  public Response addUsuario(String user )
  {
    return Response.ok(su.addUser(new Usuario(user,user))).build();
  }

  @PUT
  public Response updateUsuario(Usuario user )
  {
    return Response.ok(su.addUser(user)).build();
  }

  @DELETE
  public Response delUsuario( )
  {
    return Response.ok().build();
  }

}
