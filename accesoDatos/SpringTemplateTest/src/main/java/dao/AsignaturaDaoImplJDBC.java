package dao;

import model.Asignatura;

import java.util.List;

public class AsignaturaDaoImplJDBC implements AsignaturasDao{
    @Override
    public List<Asignatura> getAllAsignaturasJDBCTemplate() {
        return null;
    }

    @Override
    public Asignatura getAsignaturaJDBCTemplate(int id) {
        return null;
    }

    @Override
    public List<Asignatura> getAllAsignaturasNotasJDBCTemplate() {
        return null;
    }

    @Override
    public Asignatura addAsignaturaJDBCTemplate(Asignatura a) {
        return null;
    }

    @Override
    public int updateJDBCTemplate(Asignatura a) {
        return 0;
    }

    @Override
    public int deleteJDBCTemplate(int id) {
        return 0;
    }

    @Override
    public int deleteTransaccJDBCTemplate(Asignatura a) {
        return 0;
    }
}
