package servlets;

import utils.Constantes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cifrado", urlPatterns = "/cifrado")
public class Cifrado extends HttpServlet {


    private void processResquest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nombreDescifrado = (String) request.getAttribute("nombre");

        nombreDescifrado = "hola " + nombreDescifrado;

        request.setAttribute(Constantes.RESULTADO, nombreDescifrado);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processResquest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processResquest(request, response);
    }
}
