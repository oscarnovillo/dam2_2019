package main;

import dao.AlumnosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;

public class App {





  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);


    ServiciosAlumno a = BeanFactoryAnnotationUtils.qualifiedBeanOfType(ctx.getBeanFactory(), ServiciosAlumno.class, "Wanted");
    a.hola();
    ServiciosAlumno sa = ctx.getBean(ServiciosAlumno.class);
    //sa.setFooService(ctx.getBean(AlumnosDao.class));
    sa.hola();
  }
}
