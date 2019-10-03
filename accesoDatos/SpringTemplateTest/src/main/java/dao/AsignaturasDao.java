package dao;

import model.Asignatura;

import java.util.List;

public interface AsignaturasDao {
  //select JDBCTemplate
  List<Asignatura> getAllAsignaturasJDBCTemplate();

  Asignatura getAsignaturaJDBCTemplate(int id);

  //Select JDBCTemplate
  List<Asignatura> getAllAsignaturasNotasJDBCTemplate();

  //insert spring jdbc template
  Asignatura addAsignaturaJDBCTemplate(Asignatura a);

  // update JDBCTemplate
  int updateJDBCTemplate(Asignatura a);

  //delete JDBCTemplate
  int deleteJDBCTemplate(int id);

  // delete trannsaccion JDBCTemplate
  int deleteTransaccJDBCTemplate(Asignatura a);
}
