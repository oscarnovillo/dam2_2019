package dao.modelo;


import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class Usuario {



  private String login;

  private String pass;

  @JsonbCreator
  public Usuario(@JsonbProperty("login") String login, @JsonbProperty("pass") String pass) {
    this.login = login;
    this.pass = pass;
  }



  public String getLogin() {
    return login;
  }



  public String getPass() {
    return pass;
  }


}
