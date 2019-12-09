package rest;


import dao.modelo.Book;
import dao.modelo.Usuario;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Books {


  @POST
  public Response addUsuario(Book user )
  {
    System.out.println(user);
    return Response.ok().build();
  }
}
