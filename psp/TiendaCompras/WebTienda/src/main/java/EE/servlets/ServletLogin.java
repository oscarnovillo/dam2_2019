package EE.servlets;

import dao.modelo.Usuario;
import servicios.SvUsuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(name = "ServletLogin", urlPatterns = {"/login"})
public class ServletLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SvUsuarios svUsuarios = new SvUsuarios();
        AtomicReference<String> paginaDestino = new AtomicReference<>("");

        svUsuarios.usuarioLogin(new Usuario(request.getParameter("user"),
                request.getParameter("password")))
                .peek(usuario -> {
                    request.getSession().setAttribute("usuarioLogin", usuario);
                    request.getSession().setAttribute("nombreUsuario", usuario.getUsername());
                    paginaDestino.set("jsp/bienvenida.jsp");
                })
                .peekLeft(s -> {
                    request.setAttribute("errores", s);
                    paginaDestino.set("jsp/error.jsp");

                });


        request.getRequestDispatcher(paginaDestino.get()).forward(request, response);

    }
}
