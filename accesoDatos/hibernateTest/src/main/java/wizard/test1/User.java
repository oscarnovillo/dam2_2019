package wizard.test1;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
  private String username;
  private String passwd;
  private Typeuser typeuserByIdtypeuser;

  @Id
  @Column(name = "username", nullable = false, length = 45)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Basic
  @Column(name = "passwd", nullable = true, length = 45)
  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(username, user.username) &&
        Objects.equals(passwd, user.passwd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, passwd);
  }

  @ManyToOne
  @JoinColumn(name = "idtypeuser", referencedColumnName = "idtypeuser")
  public Typeuser getTypeuserByIdtypeuser() {
    return typeuserByIdtypeuser;
  }

  public void setTypeuserByIdtypeuser(Typeuser typeuserByIdtypeuser) {
    this.typeuserByIdtypeuser = typeuserByIdtypeuser;
  }
}
