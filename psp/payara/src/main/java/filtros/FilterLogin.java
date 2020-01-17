package filtros;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterLogin", urlPatterns = {"/*"})
public class FilterLogin implements Filter {
  public void destroy() {
  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

    HttpServletRequest request = (HttpServletRequest) req;
    if (request.getSession().getAttribute("hola") == null) {
      request.getSession().setAttribute("hola", 1);
      HttpServletResponse response = (HttpServletResponse) resp;
      response.sendError(403, "hola ");
    } else {
      chain.doFilter(req, resp);
    }
  }

  public void init(FilterConfig config) throws ServletException {

  }

}
