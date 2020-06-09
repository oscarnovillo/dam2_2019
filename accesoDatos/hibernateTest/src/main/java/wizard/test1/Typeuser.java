package wizard.test1;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Typeuser {
  private int idtypeuser;
  private String description;

  @Id
  @Column(name = "idtypeuser", nullable = false)
  public int getIdtypeuser() {
    return idtypeuser;
  }

  public void setIdtypeuser(int idtypeuser) {
    this.idtypeuser = idtypeuser;
  }

  @Basic
  @Column(name = "description", nullable = true, length = 45)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Typeuser typeuser = (Typeuser) o;
    return idtypeuser == typeuser.idtypeuser &&
        Objects.equals(description, typeuser.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idtypeuser, description);
  }
}
