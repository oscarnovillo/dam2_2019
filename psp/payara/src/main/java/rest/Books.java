package rest;


import dao.modelo.Book;
import dao.modelo.Usuario;
import rest.error.ApiError;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Books {


  @GET
  public List<Book> getBooks()
  {
    return new ArrayList();
  }


  @POST
  public Book addUsuario(Book user)
  {
    if (user.getName().equals("error"))
          throw new CustomException("Hola q tal");
    return user;
}
  @PUT
  public Response putUsuario(Book user)
  {

    if (user.getName().equals("error")) {
      ApiError apiError = new ApiError("mi mensaje");
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
              .entity(apiError)
              .type(MediaType.APPLICATION_JSON_TYPE).build();
    }
    return Response.ok(user).build();
  }


}
