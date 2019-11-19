package dao;



import dao.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DaoUsuarios {

  public List<Usuario> getUsuarios()
  {
    List<Usuario> users =  new ArrayList<>();
    users.add(new Usuario("1","C@sita2028LA"));
    users.add(new Usuario("2","2"));
    return users;
  }
}
