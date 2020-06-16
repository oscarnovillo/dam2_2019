package servlets;

import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Redis", urlPatterns = {"/redis"})
public class Redis extends HttpServlet {



  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    Jedis j = new Jedis("192.168.1.5");
    j.lrange("mensajes",0,j.llen("mensajes")).forEach(s -> {
      try {
        response.getWriter().println(s);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    processRequest(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    processRequest(req, resp);
  }
}
