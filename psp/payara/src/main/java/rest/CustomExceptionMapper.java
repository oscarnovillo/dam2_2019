package rest;

import dao.modelo.Book;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;



@Provider
public class CustomExceptionMapper implements ExceptionMapper<CustomException> {

  public Response toResponse(CustomException exception) {
    return Response.status(Response.Status.NOT_FOUND).entity("kk").type(MediaType.APPLICATION_JSON_TYPE).build();
  }

}
