package dao;

import model.Asignatura;

import java.util.List;

public interface AsignaturasDao {
    List<Asignatura> getAllAsignaturasJDBCTemplate();

    Asignatura getAsignaturaJDBCTemplate(int id);

    List<Asignatura> getAllAsignaturasNotasJDBCTemplate();

    Asignatura addAsignaturaJDBCTemplate(Asignatura a);

    int updateJDBCTemplate(Asignatura a);

    int deleteJDBCTemplate(int id);

    int deleteTransaccJDBCTemplate(Asignatura a);
}
