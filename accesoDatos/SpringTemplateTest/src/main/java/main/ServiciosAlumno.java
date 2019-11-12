package main;

import dao.AlumnosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component("Wanted")
public class ServiciosAlumno {


  @Inject
  private AlumnosDao fooService;


  public void hola()
  {
    fooService.deleteDBUtils(16);
  }
}
