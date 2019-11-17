package dao.modelo;

import javax.json.bind.annotation.JsonbProperty;

public class Usuario {


  @JsonbProperty
  private String login;
  @JsonbProperty
  private String pass;

  public Usuario(String login, String pass) {
    this.login = login;
    this.pass = pass;
  }

  public Usuario() {
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }
}
