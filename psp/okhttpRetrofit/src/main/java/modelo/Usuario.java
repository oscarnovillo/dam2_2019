package modelo;

public class Usuario {


  private String login;
  private String pass;

  public Usuario(String login, String pass) {
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
