package servicios;

import dao.DaoUsuarios;
import dao.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import rest.CustomException;
import rest.dto.UserDTO;
import rest.dto.converters.UserConverter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;


@RequiredArgsConstructor

public class ServiciosUsuarios {

  @Inject
  private DaoUsuarios usuario;

  @Inject
  private UserConverter userConverter;


  public List<Usuario> getUsers() {

    return usuario.getUsuarios();
  }

  public Usuario getUser(String login) {

    if (login.isEmpty())
      throw new CustomException("login no vacio");
    return usuario.getUsuario(login);
  }

  public String getUserString() {
    return "conseguido";
  }

  public Usuario addUser(Usuario user) {
    return usuario.addUser(user);
  }

public UserDTO conversorUsertoDTO(Usuario user){

  return userConverter.converterUserUserDTO(user);
}

}
