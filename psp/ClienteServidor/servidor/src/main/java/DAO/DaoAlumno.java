/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Alumno;

/**
 *
 * @author oscar
 */
public interface DaoAlumno {
    
    public Alumno getAlumno();
    public List<Alumno> getAll();
}
