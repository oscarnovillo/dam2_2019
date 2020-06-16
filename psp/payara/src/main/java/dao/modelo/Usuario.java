package dao.modelo;


import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;

public class Usuario {

  @NotNull
  private String login;

  private String pass;

  public Usuario(String login, String pass) {
    this.login = login;
    this.pass = pass;
  }

  public Usuario() {
  }

  public void setLogin(String login) {
    this.login = login;
  }


  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getLogin() {
    return login;
  }



  public String getPass() {
    return pass;
  }


}
