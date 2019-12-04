package rest;


import dao.modelo.Usuario;
import servicios.ServiciosUsuarios;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("usuario")
public class Usuarios {


  @Inject
  private ServiciosUsuarios su;


  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Usuario> getUsers()
  {
    ServiciosUsuarios su = new ServiciosUsuarios();
    return su.getUsers();
  }


  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Usuario getUser(@QueryParam("loginId") String login)
  {
    ServiciosUsuarios su = new ServiciosUsuarios();
    return su.getUser(login);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/get/{login}")
  public Usuario getUserLogin(@PathParam("login") String login,@QueryParam("loginId") String loginId)
  {
    if (login == null)
    {
      login = loginId;
    }
    ServiciosUsuarios su = new ServiciosUsuarios();
    return su.getUser(login);
  }


}
