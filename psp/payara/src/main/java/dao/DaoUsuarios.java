package dao;



import dao.modelo.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class DaoUsuarios {


  private static List<Usuario> users;

  static {
    users =  new ArrayList<>();
    users.add(new Usuario("1","C@sita2028LA"));
    users.add(new Usuario("2","2"));
  }

  public List<Usuario> getUsuarios()
  {
    return users;
  }

  public Usuario getUsuario(String login)
  {
    return users.stream().filter(usuario -> usuario.getLogin().equals(login)).findFirst().orElse(null);
  }

  public Usuario addUser(Usuario u)
  {
    users.add(u);
    return u;

  }

  @PostConstruct
  public void init()
  {

  }



}
