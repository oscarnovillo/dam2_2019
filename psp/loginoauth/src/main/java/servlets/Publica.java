package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "publica", urlPatterns = {"/publica"})
public class Publica extends HttpServlet {


  private void doTheThing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    byte[] bufferPriv = new byte[5000];
    InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/jwt.privada");

    X509EncodedKeySpec clavePublicaSpec = null;
    int chars;
    try {
      chars = in.read(bufferPriv, 0, 5000);
      in.close();
      byte[] bufferPriv2 = new byte[chars];
      System.arraycopy(bufferPriv, 0, bufferPriv2, 0, chars);


      byte[] bufferPub = new byte[5000];
      in = request.getServletContext().getResourceAsStream("/WEB-INF/jwt.publica");
      chars = in.read(bufferPub, 0, 5000);
      in.close();

      byte[] bufferPub2 = new byte[chars];
      System.arraycopy(bufferPub, 0, bufferPub2, 0, chars);
      clavePublicaSpec = new X509EncodedKeySpec(bufferPub);
      // 4.2 Recuperar clave publica desde datos codificados en formato X509




    } catch (IOException ex) {
      Logger.getLogger(JWT.class.getName()).log(Level.SEVERE, null, ex);
    }

    response.getWriter().println(Base64.getUrlEncoder().encodeToString(clavePublicaSpec.getEncoded()));
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doTheThing(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doTheThing(request,response);
  }
}
