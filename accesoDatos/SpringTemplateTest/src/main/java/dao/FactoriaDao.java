/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.SpringTemplate.AsignaturasDaoImplSpring;

/**
 *
 * @author oscar
 */
public class FactoriaDao {
  
  public static final int DAO_JDBC = 1;
  public static final int DAO_SPRING = 2;
  
  
  public AlumnosDao getAlumnosDAO(int tipoDAO)
  {
    AlumnosDao dao = null;
    if (tipoDAO == DAO_JDBC)
      dao = new AlumnosDaoImpl();
    else if (tipoDAO == DAO_SPRING)
      dao = new AlumnosDaoImpl();
    return dao;
  }

  public AsignaturasDao getAsignaturasDAO(int tipoDAO)
  {
    AsignaturasDao dao = null;
    if (tipoDAO == DAO_JDBC)
      dao = new AsignaturasDaoImplJDBC();
    else if (tipoDAO == DAO_SPRING)
      dao = new AsignaturasDaoImplSpring();
    return dao;
  }
  
}
