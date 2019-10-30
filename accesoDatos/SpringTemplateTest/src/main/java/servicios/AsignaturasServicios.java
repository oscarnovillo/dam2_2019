/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDao;
import dao.SpringTemplate.AsignaturasDaoImplSpring;
import dao.FactoriaDao;
import model.Asignatura;

import java.util.List;

/**
 *
 * @author oscar
 */
public class AsignaturasServicios {


    private FactoriaDao factoriaDao = new FactoriaDao();
    private AsignaturasDao dao = factoriaDao.getAsignaturasDAO(FactoriaDao.DAO_SPRING);

    public List<Asignatura> getAllAsignatura() {
        return dao.getAllAsignaturasJDBCTemplate();
    }

    public Asignatura getAsigntura(int id){
        FactoriaDao factoriaDao = new FactoriaDao();
        AsignaturasDao dao = factoriaDao.getAsignaturasDAO(FactoriaDao.DAO_SPRING);

        return dao.getAsignaturaJDBCTemplate(id);
    }

    public List<Asignatura> getAllAsignaturaNotas() {
        AsignaturasDao dao = new AsignaturasDaoImplSpring() ;

        return dao.getAllAsignaturasNotasJDBCTemplate();
    }

    public Asignatura insertAsignatura(Asignatura aignaturaNueva) {
        AsignaturasDao dao = new AsignaturasDaoImplSpring();

        return dao.addAsignaturaJDBCTemplate(aignaturaNueva);
    }

    public int updateAsignatura(Asignatura aignaturaNueva) {
        AsignaturasDao dao = new AsignaturasDaoImplSpring();

        return dao.updateJDBCTemplate(aignaturaNueva);
    }

    public int deleteAsignatura(int id) {
        AsignaturasDao dao = new AsignaturasDaoImplSpring();

        return dao.deleteJDBCTemplate(id);
    }

    public int deleteAsignaturaPK(Asignatura a) {
        AsignaturasDao dao = new AsignaturasDaoImplSpring();

        return dao.deleteTransaccJDBCTemplate(a);
    }
}
