package filters;

import org.w3c.dom.ls.LSOutput;
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
        String nombre = req.getParameter("nombre");
        if (null != nombre) {
            String nombreDescifrado = "";

            nombreDescifrado = nombre.chars().map(operand -> operand - 1)
                    .mapToObj(value -> String.valueOf((char) value)).collect(Collectors.joining());

//            for (int i = 0; i < nombre.length(); i++) {
//                nombreDescifrado += Character.toString((char) (nombre.charAt(i) - 1));
//            }
            req.setAttribute("nombre", nombreDescifrado);
        }
        String apellidos = req.getParameter("apellidos");
        if (null != apellidos) {
            String nombreDescifrado = "";
            nombreDescifrado = nombre.chars().map(operand -> operand - 1)
                    .mapToObj(value -> String.valueOf((char) value)).collect(Collectors.joining());
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
        resultadoCifrado = nombreDesCifrado.chars().map(operand -> operand + 1)
                .mapToObj(value -> String.valueOf((char) value)).collect(Collectors.joining());
        return resultadoCifrado;
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
