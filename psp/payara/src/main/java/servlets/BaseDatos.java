package servlets;

import dao.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

@WebServlet(name = "BaseDatos",urlPatterns = "/checkBD")
public class BaseDatos extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      DBConnection db = new DBConnection();
      Connection con = null;
      Statement stmt = null;
      ResultSet rs=null;

      try {
        con = db.getConnection();
        stmt = con.createStatement();

        rs = stmt.executeQuery("select * from teacher");

        while (rs.next())
        {
          response.getWriter().print(rs.getInt("idteacher") + " kk");

          response.getWriter().println();
        }

      } catch (Exception e) {
        response.getWriter().println(e.getMessage());
        Logger.getLogger("Main").info(e.getMessage());
      } finally {
        db.cerrarResultSet(rs);
        db.cerrarStatement(stmt);
        db.cerrarConexion(con);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
