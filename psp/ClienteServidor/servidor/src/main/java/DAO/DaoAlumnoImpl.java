/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Arrays;
import java.util.List;
import model.Alumno;

/**
 *
 * @author oscar
 */
public class DaoAlumnoImpl implements DaoAlumno{

    
    @Override
    public Alumno getAlumno() {
        return new Alumno("kk","kk");
    }

    
    @Override
    public List<Alumno> getAll() {
        return Arrays.asList(new Alumno[]{new Alumno("k1","k2"),new Alumno("k4","k2")});
    }
    
}
