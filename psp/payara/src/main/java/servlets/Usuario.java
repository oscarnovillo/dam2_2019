package servlets;

import servicios.ServiciosUsuarios;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "Usuario",urlPatterns = {"/login"})
public class Usuario extends javax.servlet.http.HttpServlet {

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Jsonb jsonb = JsonbBuilder.create();
    dao.modelo.Usuario user = jsonb.fromJson(req.getReader(), dao.modelo.Usuario.class);

  }

  protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    //String body = request.getReader().lines().collect(Collectors.joining());
    Jsonb jsonb = JsonbBuilder.create();
    dao.modelo.Usuario user = jsonb.fromJson(request.getReader(), dao.modelo.Usuario.class);

    response.getWriter().println(user.getLogin());
  }

  @Inject
  @RequestScoped
  private ServiciosUsuarios su;

  protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    if (request.getParameter("id") != null)
    {

    }
    else
    {
      Jsonb jsonb = JsonbBuilder.create();
      jsonb.toJson(su.getUsers(),response.getWriter());
//      response.setStatus(403);
//      response.getWriter().println("mensaje del error");
    }
  }


}
