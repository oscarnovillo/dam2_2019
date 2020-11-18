package EE.filters;

import dao.modelo.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "FilterLogin", urlPatterns = {"/productos", "/cesta", "/bienvenida"})
public class FilterLogin implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Usuario usuarioLogin = (Usuario) ((HttpServletRequest) req).getSession().getAttribute("usuarioLogin");
        if (usuarioLogin != null) {
            chain.doFilter(req, resp);
        } else {
            req.setAttribute("errores", "No has iniciado sesión");
            req.getRequestDispatcher("jsp/error.jsp").forward(req, resp);
        }
    }



}
