package wizard.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user", schema = "test", catalog = "")
public class UserEntityjpa {
  private String iduser;
  private String pass;
  private int type;
  private Collection<MemberEntityjpa> membersByIduser;

  @Id
  @Column(name = "iduser", nullable = false, length = 30)
  public String getIduser() {
    return iduser;
  }

  public void setIduser(String iduser) {
    this.iduser = iduser;
  }

  @Basic
  @Column(name = "pass", nullable = false, length = 100)
  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  @Basic
  @Column(name = "type", nullable = false)
  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserEntityjpa that = (UserEntityjpa) o;

    if (type != that.type) {
      return false;
    }
    if (iduser != null ? !iduser.equals(that.iduser) : that.iduser != null) {
      return false;
    }
    if (pass != null ? !pass.equals(that.pass) : that.pass != null) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return "UserEntityjpa{" +
        "iduser='" + iduser + '\'' +
        ", pass='" + pass + '\'' +
        ", type=" + type +

        '}';
  }

  @Override
  public int hashCode() {
    int result = iduser != null ? iduser.hashCode() : 0;
    result = 31 * result + (pass != null ? pass.hashCode() : 0);
    result = 31 * result + type;
    return result;
  }


  public void setMembersByIduser(Collection<MemberEntityjpa> membersByIduser) {
    this.membersByIduser = membersByIduser;
  }
}
