/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDao;
import dao.AsignaturasDaoImpl;
import model.Asignatura;

import java.util.List;

/**
 *
 * @author oscar
 */
public class AsignaturasServicios {

    public List<Asignatura> getAllAsignatura() {
        AsignaturasDao dao = new AsignaturasDaoImpl();

        return dao.getAllAsignaturasJDBCTemplate();
    }

    public Asignatura getAsigntura(int id){
        AsignaturasDao dao = new AsignaturasDaoImpl();

        return dao.getAsignaturaJDBCTemplate(id);
    }

    public List<Asignatura> getAllAsignaturaNotas() {
        AsignaturasDao dao = new AsignaturasDaoImpl();

        return dao.getAllAsignaturasNotasJDBCTemplate();
    }

    public Asignatura insertAsignatura(Asignatura aignaturaNueva) {
        AsignaturasDao dao = new AsignaturasDaoImpl();

        return dao.addAsignaturaJDBCTemplate(aignaturaNueva);
    }

    public int updateAsignatura(Asignatura aignaturaNueva) {
        AsignaturasDao dao = new AsignaturasDaoImpl();

        return dao.updateJDBCTemplate(aignaturaNueva);
    }

    public int deleteAsignatura(int id) {
        AsignaturasDao dao = new AsignaturasDaoImpl();

        return dao.deleteJDBCTemplate(id);
    }

    public int deleteAsignaturaPK(Asignatura a) {
        AsignaturasDao dao = new AsignaturasDaoImpl();

        return dao.deleteTransaccJDBCTemplate(a);
    }
}
