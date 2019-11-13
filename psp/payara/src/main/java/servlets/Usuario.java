package servlets;

import servicios.ServiciosUsuarios;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Usuario",urlPatterns = {"/login"})
public class Usuario extends javax.servlet.http.HttpServlet {

  protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

  }

  @Inject
  private ServiciosUsuarios su;

  protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    Jsonb jsonb = JsonbBuilder.create();
    jsonb.toJson(su.getUsers(),response.getWriter());

  }


}
