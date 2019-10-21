package filters;

import org.w3c.dom.ls.LSOutput;
import utils.CifradoCesar;
import utils.Constantes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

@WebFilter(filterName = "FilterDatos",
        urlPatterns = {"/cifrado", "/cifradoAppellidos"})
public class FilterDatos implements Filter {

    private void doBeforeProcessing(ServletRequest req) {
        CifradoCesar cf = new CifradoCesar();
        String nombre = req.getParameter("nombre");
        if (null != nombre) {
            String nombreDescifrado = "";

            nombreDescifrado = cf.descifra(nombre,1);

            //            for (int i = 0; i < nombre.length(); i++) {
//                nombreDescifrado += Character.toString((char) (nombre.charAt(i) - 1));
//            }
            req.setAttribute("nombre", nombreDescifrado);
        }
        String apellidos = req.getParameter("apellidos");
        if (null != apellidos) {
            String nombreDescifrado = "";
            nombreDescifrado =cf.descifra(nombre,1);
            req.setAttribute("apellidos", nombreDescifrado);
        }


        return;


    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        doBeforeProcessing(req);

        chain.doFilter(req, resp);

        String resultadoCifrado = doAfterProcessing((HttpServletRequest) req);

        resp.getWriter().println(resultadoCifrado);

    }

    private String doAfterProcessing(HttpServletRequest req) {
        String nombreDesCifrado = (String) req.getAttribute(Constantes.RESULTADO);
        String resultadoCifrado = "";
        CifradoCesar cf = new CifradoCesar();
        resultadoCifrado = cf.cifra(nombreDesCifrado,1);
        return resultadoCifrado;
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
