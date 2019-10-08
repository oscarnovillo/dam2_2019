package seguridad;

import javax.servlet.http.HttpServletRequest;

public class Seguridad {

    public boolean testLogin(HttpServletRequest request)
    {
        return (request.getSession().getAttribute("login") != null)
                && (request.getSession().getAttribute("login").equals("OK"));
    }
}
