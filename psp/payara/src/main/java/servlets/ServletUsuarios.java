package servlets;

import servicios.ServiciosUsuarios;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "Usuario", urlPatterns = {"/login"})
public class ServletUsuarios extends javax.servlet.http.HttpServlet {

    @Inject
    @RequestScoped
    private ServiciosUsuarios su;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        dao.modelo.Usuario user = jsonb.fromJson(req.getReader(), dao.modelo.Usuario.class);

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //String body = request.getReader().lines().collect(Collectors.joining());
        Jsonb jsonb = JsonbBuilder.create();
        dao.modelo.Usuario user = jsonb.fromJson(request.getReader(), dao.modelo.Usuario.class);
        if (user.getLogin().equals("ERROR")) {
            response.setStatus(500);
        } else {
            response.getWriter().println(user.getLogin());
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("hola");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if (request.getParameter("id") != null) {

        } else {
            ServiciosUsuarios su = new ServiciosUsuarios();
            Jsonb jsonb = JsonbBuilder.create();
            jsonb.toJson(su.getUsers(), response.getWriter());

            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-512");
                digest.update(su.getUsers().get(0).getPass().getBytes());
                byte[] bytes = digest.digest();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                            .substring(1));
                }
                //Get complete hashed password in hex format
                //generatedPassword = sb.toString();
                System.out.println(sb.toString());

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
//      response.setStatus(403);
//      response.getWriter().println("mensaje del error");
        }
    }


}
