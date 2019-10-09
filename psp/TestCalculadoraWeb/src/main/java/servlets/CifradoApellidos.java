package servlets;

import utils.Constantes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CifradoApellidos",urlPatterns = "/cifradoAppellidos" )
public class CifradoApellidos extends HttpServlet {
    private void processRequest(HttpServletRequest request) {
        String nombreDescifrado = (String) request.getAttribute("apellidos");

        nombreDescifrado = "Vivan las Constantes " + nombreDescifrado;

        request.setAttribute(Constantes.RESULTADO, nombreDescifrado);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request);
    }
}
