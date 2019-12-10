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


  public List<Usuario> getUsers() {

    usuario = new DaoUsuarios();
    return usuario.getUsuarios();
  }

  public Usuario getUser(String login) {

    usuario = new DaoUsuarios();
    return usuario.getUsuario(login);
  }

  public String getUserString() {
    return "conseguido";
  }

  public Usuario addUser(Usuario user) {
    return usuario.addUser(user);
  }


}
