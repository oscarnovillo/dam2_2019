package main;

import dao.SpringTemplate.AsignaturasDaoImplSpring;
import model.Asignatura;
import servicios.AlumnosServicios;
import servicios.AsignaturasServicios;
import tablas.TablasDao;

public class Main {


  public static void main(String[] args) {
    TablasDao t = new TablasDao();
    t.crearModeloJDBC();

    AsignaturasServicios a = new AsignaturasServicios();
    a.getAllAsignatura().forEach(System.out::println);

    System.out.println(a.getAsigntura(212));


    AlumnosServicios al = new AlumnosServicios();
    al.getAllAlumnos().forEach(System.out::println);

    AsignaturasDaoImplSpring sp = new AsignaturasDaoImplSpring();
    System.out.println(sp.insertJDBCTemplate(a.getAsigntura(212)));
    System.out.println(sp.insertJDBCTemplate(a.getAsigntura(212)));

  }
}
