package main;

import servicios.AsignaturasServicios;
import tablas.TablasDao;

public class Main {


  public static void main(String[] args) {
    TablasDao t = new TablasDao();
    t.crearModeloJDBC();

    AsignaturasServicios a = new AsignaturasServicios();
    a.getAllAsignatura().forEach(System.out::println);

    System.out.println(a.getAsigntura(830));
  }
}
