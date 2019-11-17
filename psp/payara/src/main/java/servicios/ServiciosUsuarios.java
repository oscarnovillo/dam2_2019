package servicios;

import dao.DaoUsuarios;
import dao.modelo.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Named
public class ServiciosUsuarios {

  @Inject
  private DaoUsuarios usuario;


  public List<Usuario> getUsers(){
    return usuario.getUsuarios();
  }

  public String getUserString() { return "conseguido"; }


}
