/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import io.jsonwebtoken.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
@WebServlet(name = "CheckJWT", urlPatterns = {"/checkJWT"})
public class CheckJWT extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            
            String jwsString = request.getHeader("Authorization");

            //"Bearer :skldjfalskdfnlaskdflsfdaslkf"
            jwsString = jwsString.substring(7);

            X509EncodedKeySpec clavePublicaSpec = null;


            int chars;
            try {


                byte[] bufferPub = new byte[5000];
                InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/jwt.publica");
                chars = in.read(bufferPub, 0, 5000);
                in.close();

                byte[] bufferPub2 = new byte[chars];
                System.arraycopy(bufferPub, 0, bufferPub2, 0, chars);
                clavePublicaSpec = new X509EncodedKeySpec(bufferPub);
                // 4.2 Recuperar clave publica desde datos codificados en formato X509




            } catch (IOException ex) {
                Logger.getLogger(JWT.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            KeyFactory keyFactoryRSA = null;
            keyFactoryRSA = KeyFactory.getInstance("RSA");


            PublicKey clavePublica2 = keyFactoryRSA.generatePublic(clavePublicaSpec);
            Jws<Claims> jws = null;
            try {
                jws = Jwts.parserBuilder() // (1)
                        .setSigningKey(clavePublica2) // (2)
                        .build()
                        .parseClaimsJws(jwsString); // (3)

                // we can safely trust the JWT
            } catch (ExpiredJwtException ex) {       // (4)
               response.sendError(403,ex.getMessage());
            }
            catch (JwtException ex) {       // (4)
                response.sendError(403,ex.getMessage());
            }
            
            if (jws != null) {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet CheckJWT</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet CheckJWT at " + jws.getBody().get("name", String.class) + "</h1>");
                    out.println("<h1>Servlet CheckJWT at " + jws.getBody().get("scope", String.class) + "</h1>");
                    out.println("<h1>Servlet CheckJWT at " + jws.getBody().get("admin", Boolean.class) + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CheckJWT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(CheckJWT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
