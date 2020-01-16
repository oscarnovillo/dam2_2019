package rest;

import dao.modelo.Book;
import rest.error.ApiError;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;



@Provider
public class CustomExceptionMapper implements ExceptionMapper<CustomException> {



  public Response toResponse(CustomException exception) {
    ApiError apiError = new ApiError(exception.getMessage());
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(apiError).type(MediaType.APPLICATION_JSON_TYPE).build();
  }

}
