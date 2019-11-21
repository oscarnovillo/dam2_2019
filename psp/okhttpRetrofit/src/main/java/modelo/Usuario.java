package modelo;

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

  @Override
  public String toString() {
    return "Usuario{" +
        "login='" + login + '\'' +
        ", pass='" + pass + '\'' +
        '}';
  }
}
