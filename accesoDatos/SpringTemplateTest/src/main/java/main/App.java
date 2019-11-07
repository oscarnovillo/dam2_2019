package main;

import dao.AlumnosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;

public class App {

  @Autowired
  public AlumnosDao fooService;



  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    //AlumnosDao fooService = ctx.getBean(AlumnosDao.class);
    App app = new App(
    );

    app.fooService.deleteDBUtils(10);
  }
}
