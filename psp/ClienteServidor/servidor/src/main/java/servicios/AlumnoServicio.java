/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.DaoAlumno;
import java.util.List;
import javax.inject.Inject;
import model.Alumno;

/**
 *
 * @author oscar
 */
public class AlumnoServicio {
    
    @Inject
    DaoAlumno alumno;
    
    public List<Alumno> getAll(){
        return alumno.getAll();
    }
    
}
