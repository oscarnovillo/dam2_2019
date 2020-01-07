package rest;


import dao.modelo.Book;
import dao.modelo.Usuario;

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
}
