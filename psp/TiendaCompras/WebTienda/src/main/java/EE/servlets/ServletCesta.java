package EE.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ServletCesta", urlPatterns = {"/cesta"})
public class ServletCesta extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cesta(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cesta(request, response);
    }

    protected void cesta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> productosCesta = (List<String>) request.getSession().getAttribute("listaCesta");
        if ( productosCesta == null) {
            productosCesta = new ArrayList<>();
        }

        var opcion = request.getParameter("opcion");
        if (opcion != null) {
            switch (opcion) {
                case "add":
                    var itemsCesta = request.getParameterValues("producto");
                    if (itemsCesta != null) {
                        productosCesta.addAll(Arrays.asList(request.getParameterValues("producto")));
                    }
                    if (productosCesta.isEmpty()) {
                        request.setAttribute("cestaMensaje", "No hay productos en la cesta");
                    }
                    break;
                case "buy":
                    if (!productosCesta.isEmpty()) {
                        productosCesta.clear();
                        request.setAttribute("cestaMensaje", "Productos comprados correctamente. \nGracias por comprar en nuestra tienda");
                    } else {
                        request.setAttribute("cestaMensaje", "La lista esta vacia no puedes comprar");
                    }
                    break;
                case "clear":
                    if (!productosCesta.isEmpty()) {
                        productosCesta.clear();
                    }
                    request.setAttribute("cestaMensaje", "Has vaciado la cesta correctamente");
                    break;
            }
        } else {
            request.setAttribute("cestaMensaje", "No hay productos en la cesta");
        }
        request.getSession().setAttribute("listaCesta", productosCesta);
        request.getRequestDispatcher("jsp/cesta.jsp").forward(request, response);

    }
}
