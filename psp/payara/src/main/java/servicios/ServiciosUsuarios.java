package servicios;

import dao.DaoUsuarios;
import dao.modelo.Usuario;

import javax.inject.Inject;
import java.util.List;

public class ServiciosUsuarios {

  @Inject
  private DaoUsuarios usuario;


  public List<Usuario> getUsers(){
    return usuario.getUsuarios();
  }




}
