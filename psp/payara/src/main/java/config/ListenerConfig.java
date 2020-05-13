package config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

@WebListener()
public class ListenerConfig implements ServletContextListener {

  // Public constructor is required by servlet spec
  public ListenerConfig() {
  }

  // -------------------------------------------------------
  // ServletContextListener implementation
  // -------------------------------------------------------
  public void contextInitialized(ServletContextEvent sce) {

    Configuration.getInstance(sce.getServletContext()
        .getResourceAsStream("/WEB-INF/config/config.yaml"));
  }

  public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
  }


}
